package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-01-17 09:32:49
 */
@Data
@TableName("competitor")
public class CompetitorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 产品类别
	 */
	private String categor;
	/**
	 *  产品名称
	 */
	private String product;
	/**
	 * 产品型号
	 */
	private String model;
	/**
	 * 公司曾用名
	 */
	private String usedname;
	/**
	 * 生产者
	 */
	private String producer;
	/**
	 * 生产企业
	 */
	private String manufacturer;
	/**
	 * 证书编号
	 */
	private String fertificate;
	/**
	 * 首次发证日期
	 */
	private String firstissuedate;
	/**
	 * 发（换）证日期
	 */
	private String renewaldate;
	/**
	 * 有效期
	 */
	private String termvalidity;
	/**
	 * 实施规则
	 */
	private String implementationrule;
	/**
	 * 认证模式
	 */
	private String certification;
	/**
	 * 标准号
	 */
	private String standardnumber;
	/**
	 * 检验报告编号
	 */
	private String inspectionnumber;
	/**
	 * 报告签发日期
	 */
	private String report;
	/**
	 * 检验类别
	 */
	private String inspectioncategory;
	/**
	 * 检验项目
	 */
	private String inspectionitems;
	/**
	 * 关键器件
	 */
	private String device;
	/**
	 * 关键件型号
	 */
	private String keymodels;
	/**
	 * 关键器件生产厂家
	 */
	private String keymanufacturers;
	/**
	 * 供电方式
	 */
	private String powerupply;
	/**
	 * 气体种类
	 */
	private String gastype;
	/**
	 * 量程
	 */
	private String rangey;
	/**
	 * 报警设定值
	 */
	private String alarm;
	/**
	 * 使用环境
	 */
	private String useenvironment;
	/**
	 * 防爆标志
	 */
	private String explosionproof;
	/**
	 * 警告用语
	 */
	private String wording;
	/**
	 * 外壳材质
	 */
	private String material;
	/**
	 * 工作方式
	 */
	private String workingmode;
	/**
	 * 采样方式
	 */
	private String samplingmode;
	/**
	 * 使用工作条件
	 */
	private String usecondition;
	/**
	 * 显示功能
	 */
	private String displayfunction;
	/**
	 * 显示器件
	 */
	private String displaydevice;
	/**
	 * 分型与主型差异
	 */
	private String difference;
	/**
	 * 与以下产品配接工作
	 */
	private String patch;
	/**
	 * 输出节量点数
	 */
	private String outputnode;
	/**
	 * 产品图片
	 */
	private String productpicture;
	/**
	 * 检验机构
	 */
	private String inspectionorganization;
	/**
	 * 编制人
	 */
	private String organization;
	/**
	 * 审核人
	 */
	private String examine;
	/**
	 * 批准人
	 */
	private String approval;
	/**
	 * 产品证书
	 */
	private String productcertificate;
	/**
	 * 检验报告
	 */
	private String inspectionreport;

}
