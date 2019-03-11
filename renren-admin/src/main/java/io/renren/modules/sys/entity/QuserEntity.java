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
 * @date 2019-03-10 13:45:04
 */
@Data
@TableName("quser")
public class QuserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户
	 */
	@TableId(type = IdType.UUID)
	private String id;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;

}
