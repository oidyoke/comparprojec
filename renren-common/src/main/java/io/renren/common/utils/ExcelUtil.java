package io.renren.common.utils;

import com.alibaba.excel.EasyExcel;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

/**
 * Excel工具类
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
public class ExcelUtil {

    /**
     * Excel导出
     *
     * @param response      response
     * @param fileName      文件名
     * @param sheetName     sheetName
     * @param list          数据List
     * @param pojoClass     对象Class
     */
    public static void exportExcel(HttpServletResponse response, String fileName, String sheetName, List<?> list,
                                   Class<?> pojoClass) throws IOException {
        if(StringUtils.isBlank(fileName)){
            //当前日期
            fileName = DateUtils.format(new Date());
        }

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" +  fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), pojoClass).sheet(sheetName).doWrite(list);
    }

    /**
     * Excel导出，先sourceList转换成List<targetClass>，再导出
     *
     * @param response      response
     * @param fileName      文件名
     * @param sheetName     sheetName
     * @param sourceList    原数据List
     * @param targetClass   目标对象Class
     */
    public static void exportExcelToTarget(HttpServletResponse response, String fileName, String sheetName, List<?> sourceList,
                                           Class<?> targetClass) throws Exception {
        List targetList = new ArrayList<>(sourceList.size());
        for(Object source : sourceList){
            Object target = targetClass.newInstance();
            BeanUtils.copyProperties(source, target);
            targetList.add(target);
        }

        exportExcel(response, fileName, sheetName, targetList, targetClass);
    }

}