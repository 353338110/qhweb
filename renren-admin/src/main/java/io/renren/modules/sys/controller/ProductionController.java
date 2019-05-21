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

import io.renren.modules.sys.entity.ProductionEntity;
import io.renren.modules.sys.service.ProductionService;
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
@RequestMapping("sys/production")
public class ProductionController {
    @Autowired
    private ProductionService productionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
   // @RequiresPermissions("sys:production:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productionService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
  //  @RequiresPermissions("sys:production:info")
    public R info(@PathVariable("id") String id){
        ProductionEntity production = productionService.getById(id);

        return R.ok().put("production", production);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("sys:production:save")
    public R save(@RequestBody ProductionEntity production){
        productionService.save(production);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
   // @RequiresPermissions("sys:production:update")
    public R update(@RequestBody ProductionEntity production){
        ValidatorUtils.validateEntity(production);
        productionService.updateById(production);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("sys:production:delete")
    public R delete(@RequestBody String[] ids){
        productionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
