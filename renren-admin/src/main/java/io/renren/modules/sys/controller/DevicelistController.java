package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.DevicelistEntity;
import io.renren.modules.sys.service.DevicelistService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2021-12-17 16:00:10
 */
@RestController
@RequestMapping("sys/devicelist")
public class DevicelistController {
    @Autowired
    private DevicelistService devicelistService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:devicelist:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = devicelistService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:devicelist:info")
    public R info(@PathVariable("id") Long id){
        DevicelistEntity devicelist = devicelistService.getById(id);

        return R.ok().put("devicelist", devicelist);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:devicelist:save")
    public R save(@RequestBody DevicelistEntity devicelist){
        devicelistService.save(devicelist);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:devicelist:update")
    public R update(@RequestBody DevicelistEntity devicelist){
        ValidatorUtils.validateEntity(devicelist);
        devicelistService.updateById(devicelist);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:devicelist:delete")
    public R delete(@RequestBody Long[] ids){
        devicelistService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
