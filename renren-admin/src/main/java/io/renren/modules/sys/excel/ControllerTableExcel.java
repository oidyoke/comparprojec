package io.renren.modules.sys.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;


@Data
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(25)
public class ControllerTableExcel extends BaseRowModel {



    @ExcelIgnore
    private Long id;
    /**
     * 公司名称
     */
    @ExcelProperty(value = "公司名称", index = 0)
    private String company;
    /**
     * 产品类别
     */
    @ExcelProperty(value = "产品类别", index = 1)
    private String categor;
    /**
     * 产品名称
     */
    @ExcelProperty(value = "产品名称", index = 2)
    private String product;
    /**
     * 产品型号
     */
    @ExcelProperty(value = "产品型号", index = 3)
    private String model;
    /**
     * 公司曾用名
     */
    @ExcelProperty(value = "公司曾用名", index = 4)
    private String usedname;
    /**
     * 制造商
     */
    @ExcelProperty(value = "制造商", index = 5)
    private String producer;
    /**
     * 生产厂家
     */
    @ExcelProperty(value = "生产厂家", index = 6)
    private String manufacturer;
    /**
     * 证书编号
     */
    @ExcelProperty(value = "证书编号", index = 7)
    private String fertificate;
    /**
     * 首次发证日期
     */
    @ExcelProperty(value = "首次发证日期", index = 8)
    private String firstissuedate;
    /**
     * 换发证日期
     */
    @ExcelProperty(value = "换发证日期", index = 9)
    private String renewaldate;
    /**
     * 有效期
     */
    @ExcelProperty(value = "有效期", index = 10)
    private String termvalidity;
    /**
     * 实施规则
     */
    @ExcelProperty(value = "实施规则", index = 11)
    private String implementationrule;
    /**
     * 认证模式
     */
    @ExcelProperty(value = "认证模式", index = 12)
    private String certification;
    /**
     * 标准号
     */
    @ExcelProperty(value = "标准号", index = 13)
    private String standardnumber;
    /**
     * 检验报告编号
     */
    @ExcelProperty(value = "检验报告编号", index = 14)
    private String inspectionnumber;
    /**
     * 报告签发日期
     */
    @ExcelProperty(value = "报告签发日期", index = 15)
    private String report;
    /**
     * 检验类别
     */
    @ExcelProperty(value = "检验类别", index = 16)
    private String inspectioncategory;
    /**
     * 检验项目
     */
    @ExcelProperty(value = "检验项目", index = 17)
    private String inspectionitems;
    /**
     * 关键器件
     */
    @ExcelProperty(value = "关键器件", index = 18)
    private String device;
    /**
     * 关键器件型号
     */
    @ExcelProperty(value = "关键器件型号", index = 19)
    private String keymodels;
    /**
     * 关键器件生产厂家
     */
    @ExcelProperty(value = "关键器件生产厂家", index = 20)
    private String keymanufacturers;
    /**
     * 供电方式
     */
    @ExcelProperty(value = "供电方式", index = 21)
    private String powerupply;
    /**
     * 外形尺寸
     */
    @ExcelProperty(value = "外形尺寸", index = 22)
    private String overalldimension;
    /**
     * 设备容量
     */
    @ExcelProperty(value = "设备容量", index = 23)
    private String equipmentcapacity;
    /**
     * 电池
     */
    @ExcelProperty(value = "电池", index = 24)
    private String batterysize;
    /**
     * 外壳材质
     */
    @ExcelProperty(value = "外壳材质", index = 25)
    private String material;
    /**
     * 通信方式
     */
    @ExcelProperty(value = "通信方式", index = 26)
    private String communicationmode;
    /**
     * 输出节点组数
     */
    @ExcelProperty(value = "输出节点组数", index = 27)
    private String outputnode;
    /**
     * 记录功能
     */
    @ExcelProperty(value = "记录功能", index = 28)
    private String recordingfunction;
    /**
     * 报警设定值
     */
    @ExcelProperty(value = "报警设定值", index = 29)
    private String alarmpoint;
    /**
     * 额外功能
     */
    @ExcelProperty(value = "额外功能", index = 30)
    private String extrafeatures;
    /**
     * 接线端子标注
     */
    @ExcelProperty(value = "接线端子标注", index = 31)
    private String terminalmarking;
    /**
     * 警告用语
     */
    @ExcelProperty(value = "警告用语", index = 32)
    private String wording;
    /**
     * 有无产品证书和产品编号
     */
    @ExcelProperty(value = "有无产品证书和产品编号", index = 33)
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
