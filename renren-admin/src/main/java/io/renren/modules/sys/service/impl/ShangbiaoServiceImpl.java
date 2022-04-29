package io.renren.modules.sys.service.impl;

import io.renren.modules.sys.excel.ControllerTableExcel;
import io.renren.modules.sys.excel.ShangbiaoExcel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.ShangbiaoDao;
import io.renren.modules.sys.entity.ShangbiaoEntity;
import io.renren.modules.sys.service.ShangbiaoService;


@Service("shangbiaoService")
public class ShangbiaoServiceImpl extends ServiceImpl<ShangbiaoDao, ShangbiaoEntity> implements ShangbiaoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShangbiaoEntity> page = this.page(
                new Query<ShangbiaoEntity>().getPage(params),
                new QueryWrapper<ShangbiaoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<ShangbiaoExcel> getAll() {
        return this.baseMapper.selectAll();
    }



    @Override
    public void save(List<ShangbiaoExcel> list) {

            baseMapper.save(list);

    }

}
