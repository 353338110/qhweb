package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.ChildImgDao;
import io.renren.modules.sys.entity.ChildImgEntity;
import io.renren.modules.sys.service.ChildImgService;


@Service("childImgService")
public class ChildImgServiceImpl extends ServiceImpl<ChildImgDao, ChildImgEntity> implements ChildImgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ChildImgEntity> page = this.page(
                new Query<ChildImgEntity>().getPage(params),
                new QueryWrapper<ChildImgEntity>().orderByDesc("create_time")
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils getByParentId(int curPage, int limit, int parentId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("parent_id",parentId);
        queryWrapper.orderByAsc("create_time");
        IPage<ChildImgEntity> page = this.page(
                new Page<>(curPage,limit),
                queryWrapper
        );
        return new PageUtils(page);
    }

}
