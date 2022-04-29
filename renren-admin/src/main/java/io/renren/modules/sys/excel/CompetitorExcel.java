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
public class CompetitorExcel extends BaseRowModel {



    @ExcelIgnore
    private Long id;
    @ExcelProperty(value = "公司名称", index = 0)
    private String company;
    @ExcelProperty(value = "产品类别", index = 1)
    private String categor;
    @ExcelProperty(value = "产品名称", index = 2)
    private String product;
    @ExcelProperty(value = "产品型号", index = 3)
    private String model;
    @ExcelProperty(value = "公司曾用名", index = 4)
    private String usedname;
    @ExcelProperty(value = "生产者", index = 5)
    private String producer;
    @ExcelProperty(value = "生产企业", index = 6)
    private String manufacturer;
    @ExcelProperty(value = "证书编号", index = 7)
    private String fertificate;
    @ExcelProperty(value = "首次发证日期", index = 8)
    private String firstissuedate;
    @ExcelProperty(value = "发（换）证日期", index = 9)
    private String renewaldate;
    @ExcelProperty(value = "有效期", index = 10)
    private String termvalidity;
    @ExcelProperty(value = "实施规则", index = 11)
    private String implementationrule;
    @ExcelProperty(value = "认证模式", index = 12)
    private String certification;
    @ExcelProperty(value = "标准号", index = 13)
    private String standardnumber;
    @ExcelProperty(value = "检验报告编号", index = 14)
    private String inspectionnumber;
    @ExcelProperty(value = "报告签发日期", index = 15)
    private String report;
    @ExcelProperty(value = "检验类别", index = 16)
    private String inspectioncategory;
    @ExcelProperty(value = "检验项目", index = 17)
    private String inspectionitems;
    @ExcelProperty(value = "关键器件", index = 18)
    private String device;
    @ExcelProperty(value = "关键件型号", index = 19)
    private String keymodels;
    @ExcelProperty(value = "关键器件生产厂家", index = 20)
    private String keymanufacturers;
    @ExcelProperty(value = "供电方式", index = 21)
    private String powerupply;
    @ExcelProperty(value = "气体种类", index = 22)
    private String gastype;
    @ExcelProperty(value = "量程", index = 23)
    private String rangey;
    @ExcelProperty(value = "报警设定值", index = 24)
    private String alarm;
    @ExcelProperty(value = "使用环境", index = 25)
    private String useenvironment;
    @ExcelProperty(value = "防爆标志", index = 26)
    private String explosionproof;
    @ExcelProperty(value = "警告用语", index = 27)
    private String wording;
    @ExcelProperty(value = "外壳材质", index = 28)
    private String material;
    @ExcelProperty(value = "工作方式", index = 29)
    private String workingmode;
    @ExcelProperty(value = "采样方式", index = 30)
    private String samplingmode;
    @ExcelProperty(value = "使用工作条件", index = 31)
    private String usecondition;
    @ExcelProperty(value = "显示功能", index = 32)
    private String displayfunction;
    @ExcelProperty(value = "显示器件", index = 33)
    private String displaydevice;
    @ExcelProperty(value = "分型与主型差异", index = 34)
    private String difference;
    @ExcelProperty(value = "与以下产品配接工作", index = 35)
    private String patch;
    @ExcelProperty(value = "输出节量点数", index = 36)
    private String outputnode;
    @ExcelProperty(value = "产品图片", index = 37)
    private String productpicture;
    @ExcelProperty(value = "检验机构", index = 38)
    private String inspectionorganization;
    @ExcelProperty(value = "编制人", index = 39)
    private String organization;
    @ExcelProperty(value = "审核人", index = 40)
    private String examine;
    @ExcelProperty(value = "批准人", index = 41)
    private String approval;
    @ExcelProperty(value = "产品证书", index = 42)
    private String productcertificate;
    @ExcelProperty(value = "检验报告", index = 43)
    private String inspectionreport;
}
