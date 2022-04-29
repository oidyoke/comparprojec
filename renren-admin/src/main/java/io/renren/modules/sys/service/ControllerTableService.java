package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.ControllerTableEntity;

import io.renren.modules.sys.excel.ControllerTableExcel;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-04-27 15:28:54
 */
public interface ControllerTableService extends IService<ControllerTableEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ControllerTableExcel> getAll();

    void save(List<ControllerTableExcel> list);
}

