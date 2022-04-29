package io.renren.modules.sys.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.alibaba.excel.EasyExcel;
import io.renren.common.utils.*;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sys.excel.CompetitorExcel;
import io.renren.modules.sys.excel.ControllerTableExcel;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.sys.entity.ControllerTableEntity;
import io.renren.modules.sys.service.ControllerTableService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-04-27 15:28:54
 */
@RestController
@RequestMapping("sys/controllertable")
public class ControllerTableController {
    @Autowired
    private ControllerTableService controllerTableService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:controllertable:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = controllerTableService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:controllertable:info")
    public R info(@PathVariable("id") Integer id){
        ControllerTableEntity controllerTable = controllerTableService.getById(id);

        return R.ok().put("controllerTable", controllerTable);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:controllertable:save")
    public R save(@RequestBody ControllerTableEntity controllerTable){
        controllerTableService.save(controllerTable);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:controllertable:update")
    public R update(@RequestBody ControllerTableEntity controllerTable){
        ValidatorUtils.validateEntity(controllerTable);
        controllerTableService.updateById(controllerTable);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:controllertable:delete")
    public R delete(@RequestBody Integer[] ids){
        controllerTableService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @PostMapping("/import")
    public R importExcel(@RequestParam("upfile") MultipartFile file) throws Exception {
        EasyExcel.read(file.getInputStream(), ControllerTableExcel.class, new ExcelListener1(controllerTableService)).sheet().doRead();
        return R.ok();

    }

    @RequestMapping("/downloadExcel")
    public void downloadExcel(HttpServletResponse response) throws IllegalAccessException, IOException, InstantiationException {
        List<ControllerTableExcel> list = controllerTableService.getAll();
        DownExcel.download(response, ControllerTableExcel.class, list);
    }

    @PostMapping("/upload")
    public R upload (@RequestParam("file") MultipartFile file) throws Exception {
        // 文件名
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(fileName.indexOf("."));
        String uploadFolder = "D:\\picture\\";
        fileName = UUID.randomUUID() + extension;
        File dest = new File(uploadFolder + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            return new R().ok("/upload/" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return new R().ok("上传失败");
        }
    }

}
