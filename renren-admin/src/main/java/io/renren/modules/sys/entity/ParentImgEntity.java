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
@TableName("parent_img")
public class ParentImgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.UUID)
	private String id;
	/**
	 * 
	 */
	private String imageUrl;
	/**
	 * 
	 */
	private String iamgeName;
	/**
	 * 
	 */
	private String imageDetail;
	/**
	 * 
	 */
	private Integer parentId;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date updateTime;

}
