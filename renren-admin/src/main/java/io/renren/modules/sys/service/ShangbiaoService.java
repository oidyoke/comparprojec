package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.ShangbiaoEntity;
import io.renren.modules.sys.excel.ControllerTableExcel;
import io.renren.modules.sys.excel.ShangbiaoExcel;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-04-28 12:16:57
 */
public interface ShangbiaoService extends IService<ShangbiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);


    List<ShangbiaoExcel> getAll();


    void save(List<ShangbiaoExcel> list);
}

