package io.renren.modules.sys.entity;

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
 * @date 2022-04-28 12:16:57
 */
@Data
@TableName("shangbiao")
public class ShangbiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 申请日期
	 */
	private Date applicationDate;
	/**
	 * 商标图片
	 */
	private String trademarkImages;
	/**
	 * 商标名称
	 */
	private String trademarkName;
	/**
	 * 注册号
	 */
	private String registrationNumber;
	/**
	 * 国际分类
	 */
	private String interClassification;
	/**
	 * 商标状态
	 */
	private String trademarkState;
	/**
	 * 注册公告日期
	 */
	private Date enrollDate;

}
