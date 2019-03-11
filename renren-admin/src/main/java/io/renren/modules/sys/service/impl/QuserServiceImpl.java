package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.QuserDao;
import io.renren.modules.sys.entity.QuserEntity;
import io.renren.modules.sys.service.QuserService;


@Service("quserService")
public class QuserServiceImpl extends ServiceImpl<QuserDao, QuserEntity> implements QuserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QuserEntity> page = this.page(
                new Query<QuserEntity>().getPage(params),
                new QueryWrapper<QuserEntity>()
        );

        return new PageUtils(page);
    }

}
