package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.ParentImgDao;
import io.renren.modules.sys.entity.ParentImgEntity;
import io.renren.modules.sys.service.ParentImgService;


@Service("parentImgService")
public class ParentImgServiceImpl extends ServiceImpl<ParentImgDao, ParentImgEntity> implements ParentImgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ParentImgEntity> page = this.page(
                new Query<ParentImgEntity>().getPage(params),
                new QueryWrapper<ParentImgEntity>()
        );

        return new PageUtils(page);
    }

}
