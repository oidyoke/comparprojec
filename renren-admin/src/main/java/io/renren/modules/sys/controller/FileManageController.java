package io.renren.modules.sys.controller;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import io.renren.common.utils.OxFileUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


@RestController
@RequestMapping(value = "/filesManager")
public class FileManageController {

    @Value("${filemanager.root}")
    private String root;

    @RequestMapping("list")
    public Object list(@RequestBody JSONObject json) throws ServletException {
        try {
            String path = json.getString("path");
            List<JSONObject> fileItems = new ArrayList<>();
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(root, path))) {
                String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat dt = new SimpleDateFormat(DATE_FORMAT);
                for (Path pathObj : directoryStream) {
                    BasicFileAttributes attrs = Files.readAttributes(pathObj, BasicFileAttributes.class);
                    JSONObject fileItem = new JSONObject();
                    fileItem.put("name", pathObj.getFileName().toString());
                    fileItem.put("date", dt.format(new Date(attrs.lastModifiedTime().toMillis())));
                    fileItem.put("size", attrs.size());
                    fileItem.put("type", attrs.isDirectory() ? "dir" : "file");
                    fileItems.add(fileItem);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("result", fileItems);
            return jsonObject;
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    @RequestMapping("upload")
    public Object upload(@RequestParam("destination") String destination, HttpServletRequest request) {
        try {
            Collection<Part> parts = request.getParts();
            for (Part part : parts) {
                if (part.getContentType() != null) {
                    String path = root + destination;
                    File f = new File(path, OxFileUtils.getFileName(part.getHeader("content-disposition")));
                    if (!OxFileUtils.write(part.getInputStream(), f)) {
                        throw new Exception("文件上传失败");
                    }
                }
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    @RequestMapping("preview")
    public void preview(HttpServletResponse response, String path) throws IOException {
        File file = new File(root, path);
        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource Not Found");
            return;
        }

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", URLEncoder.encode(file.getName(), "UTF-8")));
        response.setContentLength((int) file.length());
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }
    }

    @RequestMapping("createFolder")
    public Object createFolder(@RequestBody JSONObject json) {
        try {
            String newPath = json.getString("newPath");
            File newDir = new File(root + newPath);
            if (!newDir.mkdir()) {
                throw new Exception("不能创建目录: " + newPath);
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    @RequestMapping("copy")
    public Object copy(@RequestBody JSONObject json, HttpServletRequest request) {
        try {
            String newpath = json.getString("newPath");
            JSONArray items = json.getJSONArray("items");
            for (int i = 0; i < items.size(); i++) {
                String path = items.getString(i);
                File srcFile = new File(root, path);
                File destFile = new File(root + newpath, srcFile.getName());
                FileCopyUtils.copy(srcFile, destFile);
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    @RequestMapping("move")
    public Object move(@RequestBody JSONObject json) {
        try {
            String newpath = json.getString("newPath");
            JSONArray items = json.getJSONArray("items");
            for (int i = 0; i < items.size(); i++) {
                String path = items.getString(i);
                File srcFile = new File(root, path);
                File destFile = new File(root + newpath, srcFile.getName());
                if (srcFile.isFile()) {
                    FileUtils.moveFile(srcFile, destFile);
                } else {
                    FileUtils.moveDirectory(srcFile, destFile);
                }
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    @RequestMapping("remove")
    public Object remove(@RequestBody JSONObject json) {
        try {
            JSONArray items = json.getJSONArray("items");
            for (int i = 0; i < items.size(); i++) {
                String path = items.getString(i);
                File srcFile = new File(root, path);
                if (!FileUtils.deleteQuietly(srcFile)) {
                    throw new Exception("删除失败: " + srcFile.getAbsolutePath());
                }
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    @RequestMapping("rename")
    public Object rename(@RequestBody JSONObject json) {
        try {
            String path = json.getString("item");
            String newPath = json.getString("newItemPath");
            File srcFile = new File(root, path);
            File destFile = new File(root, newPath);
            if (srcFile.isFile()) {
                FileUtils.moveFile(srcFile, destFile);
            } else {
                FileUtils.moveDirectory(srcFile, destFile);
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    @RequestMapping("getContent")
    public Object getContent(@RequestBody JSONObject json) {
        try {
            String path = json.getString("item");
            File srcFile = new File(root, path);
            String content = FileUtils.readFileToString(srcFile);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("result", content);
            return jsonObject;
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    @RequestMapping("edit")
    public Object edit(@RequestBody JSONObject json) {
        try {
            String path = json.getString("item");
            String content = json.getString("content");
            File srcFile = new File(root, path);
            FileUtils.writeStringToFile(srcFile, content);
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    private JSONObject error(String msg) {
        JSONObject result = new JSONObject();
        result.put("success", false);
        result.put("error", msg);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;
    }

    private JSONObject success() {
        JSONObject result = new JSONObject();
        result.put("success", true);
        result.put("error", null);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;
    }

}
