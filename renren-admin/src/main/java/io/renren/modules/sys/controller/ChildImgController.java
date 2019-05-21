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

import io.renren.modules.sys.entity.ChildImgEntity;
import io.renren.modules.sys.service.ChildImgService;
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
@RequestMapping("sys/childimg")
public class ChildImgController {
    @Autowired
    private ChildImgService childImgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
   // @RequiresPermissions("sys:childimg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = childImgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
   // @RequiresPermissions("sys:childimg:info")
    public R info(@PathVariable("id") String id){
        ChildImgEntity childImg = childImgService.getById(id);

        return R.ok().put("childImg", childImg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
  //  @RequiresPermissions("sys:childimg:save")
    public R save(@RequestBody ChildImgEntity childImg){
        childImgService.save(childImg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
  //  @RequiresPermissions("sys:childimg:update")
    public R update(@RequestBody ChildImgEntity childImg){
        ValidatorUtils.validateEntity(childImg);
        childImgService.updateById(childImg);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("sys:childimg:delete")
    public R delete(@RequestBody String[] ids){
        childImgService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    @RequestMapping("/listParentId")
    // @RequiresPermissions("sys:childimg:list")
    public R list(int page,int limit,int parentId){
        PageUtils pageUtils = childImgService.getByParentId(page, limit, parentId);
        return R.ok().put("page", pageUtils);
    }
}
