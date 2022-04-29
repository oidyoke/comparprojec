package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.ControllerTableEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.excel.CompetitorExcel;
import io.renren.modules.sys.excel.ControllerTableExcel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-04-27 15:28:54
 */
@Mapper
public interface ControllerTableDao extends BaseMapper<ControllerTableEntity> {

    List<ControllerTableExcel> selectAll();
    void save(List<ControllerTableExcel> list);
}
