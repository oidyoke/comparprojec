package io.renren.common.utils;

import com.alibaba.excel.EasyExcel;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author zx
 */
public class DownExcel {
    public static void download(HttpServletResponse response, Class t, List list) throws IOException, IllegalAccessException, InstantiationException {
        // 设置文本内省
        response.setContentType("application/vnd.ms-excel");
        // 设置字符编码
        response.setCharacterEncoding("utf-8");
        // 设置响应头
        response.setHeader("Content-Disposition", "attachment;filename=download.xlsx");
        //用io流来写入数据
        EasyExcel.write(response.getOutputStream(), t).sheet("模板").doWrite(list);
    }
}
