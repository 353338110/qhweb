package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.QhuserDao;
import io.renren.modules.sys.entity.QhuserEntity;
import io.renren.modules.sys.service.QhuserService;


@Service("qhuserService")
public class QhuserServiceImpl extends ServiceImpl<QhuserDao, QhuserEntity> implements QhuserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QhuserEntity> page = this.page(
                new Query<QhuserEntity>().getPage(params),
                new QueryWrapper<QhuserEntity>()
        );

        return new PageUtils(page);
    }

}
