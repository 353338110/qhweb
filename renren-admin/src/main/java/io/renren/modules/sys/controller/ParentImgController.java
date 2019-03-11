package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.ParentImgEntity;
import io.renren.modules.sys.service.ParentImgService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-03-10 13:45:04
 */
@RestController
@RequestMapping("sys/parentimg")
public class ParentImgController {
    @Autowired
    private ParentImgService parentImgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:parentimg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = parentImgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:parentimg:info")
    public R info(@PathVariable("id") String id){
        ParentImgEntity parentImg = parentImgService.getById(id);

        return R.ok().put("parentImg", parentImg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:parentimg:save")
    public R save(@RequestBody ParentImgEntity parentImg){
        parentImgService.save(parentImg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:parentimg:update")
    public R update(@RequestBody ParentImgEntity parentImg){
        ValidatorUtils.validateEntity(parentImg);
        parentImgService.updateById(parentImg);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:parentimg:delete")
    public R delete(@RequestBody String[] ids){
        parentImgService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
