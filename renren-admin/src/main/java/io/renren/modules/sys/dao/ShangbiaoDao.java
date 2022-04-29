package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.ShangbiaoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.excel.ControllerTableExcel;
import io.renren.modules.sys.excel.ShangbiaoExcel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-04-28 12:16:57
 */
@Mapper
public interface ShangbiaoDao extends BaseMapper<ShangbiaoEntity> {

    List<ShangbiaoExcel> selectAll();


    void save(List<ShangbiaoExcel> list);
	
}
