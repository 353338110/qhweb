package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.QhuserEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-05-22 10:11:07
 */
public interface QhuserService extends IService<QhuserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

