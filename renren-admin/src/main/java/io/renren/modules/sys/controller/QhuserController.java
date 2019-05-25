package io.renren.modules.sys.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.QhuserEntity;
import io.renren.modules.sys.service.QhuserService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 *
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-05-22 10:11:07
 */
@RestController
@RequestMapping("sys/qhuser")
public class QhuserController {
    @Autowired
    private QhuserService qhuserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:qhuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qhuserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{qhUserId}")
    @RequiresPermissions("sys:qhuser:info")
    public R info(@PathVariable("qhUserId") String qhUserId){
        QhuserEntity qhuser = qhuserService.getById(qhUserId);

        return R.ok().put("qhuser", qhuser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:qhuser:save")
    public R save(@RequestBody QhuserEntity qhuser){
        qhuserService.save(qhuser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:qhuser:update")
    public R update(@RequestBody QhuserEntity qhuser){
        ValidatorUtils.validateEntity(qhuser);
        qhuserService.updateById(qhuser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:qhuser:delete")
    public R delete(@RequestBody String[] qhUserIds){
        qhuserService.removeByIds(Arrays.asList(qhUserIds));

        return R.ok();
    }
    public static String encodeByMd5(String string) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        Base64.Encoder base64Encoder = Base64.getEncoder();
        // 加密字符串
        return base64Encoder.encodeToString(md5.digest(string.getBytes("utf-8")));
    }
    @RequestMapping("/create")
    public R create( @RequestBody QhuserEntity qhuser) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (null!=qhuser.getQhUserPassword()){
            qhuser.setQhUserPassword(encodeByMd5(qhuser.getQhUserPassword()));
        }
        qhuserService.save(qhuser);
        return R.ok();
    }

    @RequestMapping("/login")
    public R login(String username,String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (null!=username){
            QhuserEntity qh_user_name = qhuserService.getOne(new QueryWrapper<QhuserEntity>().eq("qh_user_name", username));
            if (null==qh_user_name){
                return R.error("账号或者密码错误");
            }
            if (qh_user_name.getQhUserPassword().equals(encodeByMd5(password))){
                return R.ok();
            }else {
                return R.error("账号或者密码错误");
            }
        }else {
            return R.error("用户名不能为空");
        }

    }

}
