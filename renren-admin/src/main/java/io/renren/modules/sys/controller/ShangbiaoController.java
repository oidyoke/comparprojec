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
import io.renren.modules.sys.excel.ShangbiaoExcel;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.sys.entity.ShangbiaoEntity;
import io.renren.modules.sys.service.ShangbiaoService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-04-28 12:16:57
 */
@RestController
@RequestMapping("sys/shangbiao")
public class ShangbiaoController {
    @Autowired
    private ShangbiaoService shangbiaoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:shangbiao:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shangbiaoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:shangbiao:info")
    public R info(@PathVariable("id") Long id){
        ShangbiaoEntity shangbiao = shangbiaoService.getById(id);

        return R.ok().put("shangbiao", shangbiao);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:shangbiao:save")
    public R save(@RequestBody ShangbiaoEntity shangbiao){
        shangbiaoService.save(shangbiao);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:shangbiao:update")
    public R update(@RequestBody ShangbiaoEntity shangbiao){
        ValidatorUtils.validateEntity(shangbiao);
        shangbiaoService.updateById(shangbiao);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:shangbiao:delete")
    public R delete(@RequestBody Long[] ids){
        shangbiaoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }
    @PostMapping("/import")
    public R importExcel(@RequestParam("upfile") MultipartFile file) throws Exception {
        EasyExcel.read(file.getInputStream(), ShangbiaoExcel.class, new ExcelListenerShangbiao(shangbiaoService)).sheet().doRead();
        return R.ok();
    }


    @RequestMapping("/downloadExcel")
    public void downloadExcel(HttpServletResponse response) throws IllegalAccessException, IOException, InstantiationException {
        List<ShangbiaoExcel> list = shangbiaoService.getAll();
        DownExcel.download(response, ShangbiaoExcel.class, list);
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
