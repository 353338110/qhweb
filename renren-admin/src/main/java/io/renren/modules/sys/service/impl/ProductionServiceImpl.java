package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.ProductionDao;
import io.renren.modules.sys.entity.ProductionEntity;
import io.renren.modules.sys.service.ProductionService;


@Service("productionService")
public class ProductionServiceImpl extends ServiceImpl<ProductionDao, ProductionEntity> implements ProductionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductionEntity> page = this.page(
                new Query<ProductionEntity>().getPage(params),
                new QueryWrapper<ProductionEntity>()
        );

        return new PageUtils(page);
    }

}
