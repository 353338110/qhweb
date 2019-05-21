package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.ChildImgEntity;

import java.util.Map;

/**
 *
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-03-10 13:45:04
 */
public interface ChildImgService extends IService<ChildImgEntity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils getByParentId(int page,int limit ,int parentId);
}

