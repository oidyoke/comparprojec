package io.renren.modules.sys.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.DevicelistDao;
import io.renren.modules.sys.entity.DevicelistEntity;
import io.renren.modules.sys.service.DevicelistService;


@Service("devicelistService")
public class DevicelistServiceImpl extends ServiceImpl<DevicelistDao, DevicelistEntity> implements DevicelistService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("mn");
        String name1 = (String) params.get("province");
        String name2 = (String) params.get("city");
        String name3 = (String) params.get("area");
        IPage<DevicelistEntity> page = this.page(
                new Query<DevicelistEntity>().getPage(params),
                new QueryWrapper<DevicelistEntity>()
                        .orderByDesc("id")
                        .like(StringUtils.isNotBlank(name),"mn", name)
                        .like(StringUtils.isNotBlank(name1), "province", name1)
                        .like(StringUtils.isNotBlank(name2), "city", name2)
                        .like(StringUtils.isNotBlank(name3), "area", name3)
        );

        return new PageUtils(page);
    }

}
