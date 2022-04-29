package io.renren.modules.sys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "竞争对手分析")
public class CompetitorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "公司名称")
    private String company;
    @ApiModelProperty(value = "产品类别")
    private String categor;
    @ApiModelProperty(value = "产品名称")
    private String product;
    @ApiModelProperty(value = "产品型号")
    private String model;
    @ApiModelProperty(value = "公司曾用名")
    private String usedName;
    @ApiModelProperty(value = "生产者")
    private String producer;
    @ApiModelProperty(value = "生产企业")
    private String manuFacturer;
    @ApiModelProperty(value = "证书编号")
    private String fertificateumber;
    @ApiModelProperty(value = "首次发证日期")
    private Date firstissueDate;
    @ApiModelProperty(value = "发（换）证日期")
    private Date renewalDate;
    @ApiModelProperty(value = "有效期")
    private Date termValidity;
    @ApiModelProperty(value = "实施规则")
    private String implementationRule;
    @ApiModelProperty(value = "认证模式")
    private String certificationRules;
    @ApiModelProperty(value = "标准号")
    private String standardNumber;
    @ApiModelProperty(value = "检验报告编号")
    private String inspectionNumber;
    @ApiModelProperty(value = "报告签发日期")
    private Date reportDate;
    @ApiModelProperty(value = "检验类别")
    private String inspectionCategory;
    @ApiModelProperty(value = "检验项目")
    private String inspectionItems;
    @ApiModelProperty(value = "关键器件")
    private String device;
    @ApiModelProperty(value = "关键件型号")
    private String keyModels;
    @ApiModelProperty(value = "关键器件生产厂家")
    private String keyManufacturers;
    @ApiModelProperty(value = "供电方式")
    private String powerSupply;
    @ApiModelProperty(value = "气体种类")
    private String gasType;
    @ApiModelProperty(value = "量程")
    private String rangey;
    @ApiModelProperty(value = "报警设定值")
    private String alarm;
    @ApiModelProperty(value = "使用环境")
    private String useEnvironment;
    @ApiModelProperty(value = "防爆标志")
    private String explosionProof;
    @ApiModelProperty(value = "警告用语")
    private String wording;
    @ApiModelProperty(value = "外壳材质")
    private String material;
    @ApiModelProperty(value = "工作方式")
    private String workingMode;
    @ApiModelProperty(value = "采样方式")
    private String samplingMode;
    @ApiModelProperty(value = "使用工作条件")
    private String useCondition;
    @ApiModelProperty(value = "显示功能")
    private String displayFunction;
    @ApiModelProperty(value = "显示器件")
    private String displayDevice;
    @ApiModelProperty(value = "分型与主型差异")
    private String difference;
    @ApiModelProperty(value = "与以下产品配接工作")
    private String patch;
    @ApiModelProperty(value = "输出节量点数")
    private String outputNode;
    @ApiModelProperty(value = "产品图片")
    private String productPicture;
    @ApiModelProperty(value = "检验机构")
    private String inspectionOrganization;
    @ApiModelProperty(value = "编制人")
    private String organization;
    @ApiModelProperty(value = "审核人")
    private String examine;
    @ApiModelProperty(value = "批准人")
    private String approval;
    @ApiModelProperty(value = "产品证书")
    private String productCertificate;
    @ApiModelProperty(value = "检验报告")
    private String inspectionReport;

}
