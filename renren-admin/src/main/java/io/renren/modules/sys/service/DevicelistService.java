package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.DevicelistEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2021-12-17 16:00:10
 */
public interface DevicelistService extends IService<DevicelistEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

