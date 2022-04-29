package io.renren.modules.sys.service.impl;

import io.renren.modules.sys.excel.ControllerTableExcel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.ControllerTableDao;
import io.renren.modules.sys.entity.ControllerTableEntity;
import io.renren.modules.sys.service.ControllerTableService;


@Service("controllerTableService")
public class ControllerTableServiceImpl extends ServiceImpl<ControllerTableDao, ControllerTableEntity> implements ControllerTableService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ControllerTableEntity> page = this.page(
                new Query<ControllerTableEntity>().getPage(params),
                new QueryWrapper<ControllerTableEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<ControllerTableExcel> getAll() {
        return this.baseMapper.selectAll();
    }

    public void save(List<ControllerTableExcel> list){
        baseMapper.save(list);
    }

}
