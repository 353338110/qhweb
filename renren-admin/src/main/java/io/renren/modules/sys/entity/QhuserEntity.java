package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-05-22 10:11:07
 */
@Data
@TableName("qhuser")
public class QhuserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId(type = IdType.UUID)
	private String qhUserId;
	/**
	 * 手机号
	 */
	private String qhUserTel;
	/**
	 * 用户名
	 */
	private String qhUserName;
	/**
	 * 密码
	 */
	private String qhUserPassword;

}
