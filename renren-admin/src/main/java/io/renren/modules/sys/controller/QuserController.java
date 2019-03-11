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

import io.renren.modules.sys.entity.QuserEntity;
import io.renren.modules.sys.service.QuserService;
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
@RequestMapping("sys/quser")
public class QuserController {
    @Autowired
    private QuserService quserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:quser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = quserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:quser:info")
    public R info(@PathVariable("id") String id){
        QuserEntity quser = quserService.getById(id);

        return R.ok().put("quser", quser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:quser:save")
    public R save(@RequestBody QuserEntity quser){
        quserService.save(quser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:quser:update")
    public R update(@RequestBody QuserEntity quser){
        ValidatorUtils.validateEntity(quser);
        quserService.updateById(quser);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:quser:delete")
    public R delete(@RequestBody String[] ids){
        quserService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
