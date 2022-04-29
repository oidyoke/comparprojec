package io.renren.modules.sys.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
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
 * @date 2022-04-27 15:28:54
 */
@Data
@TableName("controller_table")
public class ControllerTableEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键自增
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
	 * 产品名称
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
	 * 制造商
	 */

	private String producer;
	/**
	 * 生产厂家
	 */

	private String manufacturer;
	/**
	 * 证书编号
	 */

	private String fertificate;
	/**
	 * 首次发证日期
	 */

	private Date firstissuedate;
	/**
	 * 换发证日期
	 */

	private Date renewaldate;
	/**
	 * 有效期
	 */

	private Date termvalidity;
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

	private Date report;
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
	 * 关键器件型号
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
	 * 外形尺寸
	 */
	private String overalldimension;
	/**
	 * 设备容量
	 */
	private String equipmentcapacity;
	/**
	 * 电池
	 */
	private String batterysize;
	/**
	 * 外壳材质
	 */
	private String material;
	/**
	 * 通信方式
	 */
	private String communicationmode;
	/**
	 * 输出节点组数
	 */
	private String outputnode;
	/**
	 * 记录功能
	 */
	private String recordingfunction;
	/**
	 * 报警设定值
	 */
	private String alarmpoint;
	/**
	 * 额外功能
	 */
	private String extrafeatures;
	/**
	 * 接线端子标注
	 */
	private String terminalmarking;
	/**
	 * 警告用语
	 */
	private String wording;
	/**
	 * 有无产品证书和产品编号
	 */
	private String havedatenumber;
	/**
	 * 分型与主型的差异
	 */
	@ExcelProperty(value = "分型与主型的差异", index = 34)
	private String difference;
	/**
	 * 与以下产品的配接工作
	 */
	@ExcelProperty(value = "与以下产品的配接工作", index = 35)
	private String patch;
	/**
	 * 图形显示装置
	 */
	@ExcelProperty(value = "图形显示装置", index = 36)
	private String graphicdisplay;
	/**
	 * 产品图片
	 */
	@ExcelProperty(value = "产品图片", index = 37)
	private String productpicture;
	/**
	 * 检验机构
	 */
	@ExcelProperty(value = "检验机构", index = 38)
	private String inspectionorganization;
	/**
	 * 编制人
	 */
	@ExcelProperty(value = "编制人", index = 39)
	private String organization;
	/**
	 * 审核人
	 */
	@ExcelProperty(value = "审核人", index = 40)
	private String examine;
	/**
	 * 批准人
	 */
	@ExcelProperty(value = "批准人", index = 41)
	private String approval;
	/**
	 * 产品证书
	 */
	@ExcelProperty(value = "产品证书", index = 42)
	private String productcertificate;
	/**
	 * 检验报告
	 */
	@ExcelProperty(value = "检验报告", index = 43)
	private String inspectionreport;

}
