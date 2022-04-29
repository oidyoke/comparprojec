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




public class ShangbiaoExcel {

    @ExcelIgnore
    private Long id;
    @ExcelProperty(value = "申请日期", index = 0)
    private String applicationDate;
    @ExcelProperty(value = "商标名称", index = 1)
    private String trademarkName;
    @ExcelProperty(value = "注册号", index = 2)
    private String registrationNumber;
    @ExcelProperty(value = "国际分类", index = 3)
    private String interClassification;
    @ExcelProperty(value = "商标状态", index = 4)
    private String trademarkState;
    @ExcelProperty(value = "注册公告日期", index = 5)
    private String enrollDate;

}
