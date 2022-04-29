package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2021-12-17 16:00:10
 */
@Data
@TableName("devicelist")
public class DevicelistEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键,自增长
	 */
	@TableId
	private Long id;
	/**
	 * 设备编号
	 */
	@NotBlank(message="设备编号不能为空")
	private String mn;
	/**
	 * 上传时间
	 */
	private Date datatime;
	/**
	 * 油烟浓度
	 */
	private Double oilconcentration;
	/**
	 * 油烟浓度状态（N 正常，D故障，T超标，F 关闭，B 通讯异常）
	 */
	private String oiltype;
	/**
	 * 非甲烷总烃
	 */
	private Double nmhc;
	/**
	 * 非甲烷总烃状态（N 正常，D故障，T超标，F 关闭，B 通讯异常）
	 */
	private String nmhctype;
	/**
	 * 颗粒物浓度
	 */
	private Double pm10;
	/**
	 * 颗粒物浓度状态（N 正常，D故障，T超标，F 关闭，B 通讯异常）
	 */
	private String pm10type;
	/**
	 * 风机电流值
	 */
	private Long current;
	/**
	 * 风机电流值状态（N 正常，D故障，T超标，F 关闭，B 通讯异常）
	 */
	private String currenttype;
	/**
	 * 净化器电流值
	 */
	private Long purifier;
	/**
	 * 净化器电流值状态（N 正常，D故障，T超标，F 关闭，B 通讯异常）
	 */
	private String purifiertype;
	/**
	 * 安装位置
	 */
	private String installAddr;
	/**
	 * 在线状态（0离线，1在线）
	 */
	private String onlineType;
	/**
	 * 使用状态(0,启用，1禁用)
	 */
	private String usestatus;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 区/县
	 */
	private String area;

}
