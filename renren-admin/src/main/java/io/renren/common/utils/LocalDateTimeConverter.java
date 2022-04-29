package io.renren.common.utils;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;


import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter implements Converter<LocalDateTime> {


    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";
    @Override
    public Class supportJavaTypeKey() {
        return null;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return null;
    }

    @Override
    public LocalDateTime convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        BigDecimal numberValue = cellData.getNumberValue();
        System.out.println("numberValue:"+numberValue);
        long second = numberValue.multiply(new BigDecimal("86400")).longValue();
        System.out.println("second:"+second);
        Instant instant = Instant.ofEpochSecond(second-2209190400L);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    @Override
    public CellData convertToExcelData(LocalDateTime localDateTime, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }


}
