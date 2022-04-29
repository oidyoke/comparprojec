package io.renren.modules.sys.controller;

import com.alibaba.excel.EasyExcel;
import io.renren.common.utils.DownExcel;
import io.renren.common.utils.ExcelListener;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sys.entity.*;
import io.renren.modules.sys.excel.CompetitorExcel;
import io.renren.modules.sys.service.CompetitorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-01-17 09:32:49
 */
@RestController
@RequestMapping("sys/competitor")
public class CompetitorController {
    @Autowired
    private CompetitorService competitorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:competitor:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = competitorService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:competitor:info")
    public R info(@PathVariable("id") Long id){
        CompetitorEntity competitor = competitorService.getById(id);
        return R.ok().put("competitor", competitor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:competitor:save")
    public R save(@RequestBody CompetitorEntity competitor){
        competitorService.save(competitor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:competitor:update")
    public R update(@RequestBody CompetitorEntity competitor){
        ValidatorUtils.validateEntity(competitor);
        competitorService.updateById(competitor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:competitor:delete")
    public R delete(@RequestBody Long[] ids){
        competitorService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }




    @PostMapping("/import")
    @RequiresPermissions("sys:competitor:importExcel")
    public R importExcel(@RequestParam("upfile") MultipartFile file) throws Exception {
      EasyExcel.read(file.getInputStream(), CompetitorExcel.class, new ExcelListener(competitorService)).sheet().doRead();
        return R.ok();

    }

    @RequestMapping("/downloadExcel")
    @RequiresPermissions("sys:competitor:downloadExcel")
    public void downloadExcel(HttpServletResponse response) throws IllegalAccessException, IOException, InstantiationException {
        List<CompetitorExcel> list = competitorService.getAll();
        DownExcel.download(response, CompetitorExcel.class, list);
    }

    @PostMapping("/upload")
    public R upload (@RequestParam("file") MultipartFile file) throws Exception {
            // 文件名
            String fileName = file.getOriginalFilename();
            String extension = fileName.substring(fileName.indexOf("."));
            String uploadFolder = "D:\\picture\\";
            fileName = UUID.randomUUID() + extension;
            File dest = new File(uploadFolder + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }

            try {
                file.transferTo(dest);
                return new R().ok("/upload/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
                return new R().ok("上传失败");
            }
        }


    /**证书量前十的公司*/
    @RequestMapping("/selectTopTen")
    public R selectTopTen(){
        List<TopTenEntity> list= competitorService.getTopTen();
        return  R.ok().put("data",list);
    }

    /**查询每月的证书数量*/
    @RequestMapping("/selectMonth")
    public R selectMonth(String yearId){
        List<MonthEntity> list= competitorService.getMonthCount(yearId);
        return  R.ok().put("month",list);
    }

    /**ajax获取表中公司名称*/
    @RequestMapping("/selectCompanyName")
    public R selectCompanyName(){
        List<CompanyEntity> list=competitorService.getCompanyName();
        return  R.ok().put("company",list);
    }
    /**ajax获取筛选信息*/
    @RequestMapping("/selectMoreName")
    public R selectMoreName(){
        List<CompanyEntity> list=competitorService.getPowerUpplyName();
        List<CompanyEntity> list1=competitorService.getGasTypeName();
        List<CompanyEntity> list2=competitorService.getRangeyName();
        List<CompanyEntity> list3=competitorService.getAlarmName();
        List<CompanyEntity> list4=competitorService.getInspectionorganizationName();
        return  R.ok().put("data",list).put("data1",list1).put("data2",list2).put("data3",list3).put("data4",list4);
    }
    /**查询对应公司各类探测器数量*/
    @RequestMapping("/selectProduct")
    public R selectProduct(String company){
        List<ProductEntity> list=competitorService.getProduct(company);
        return R.ok().put("product",list);
    }
    /**折线图显示任意月份总数量与各类探测器数量*/
    @RequestMapping("/selectProductMonthNum")
    public R selectProductMonthNum(String year){
        List<MonthEntity> list= competitorService.getMonthCount(year);
        List<MonthEntity> list1=competitorService.getProductMonthNum(year);
        List<MonthEntity> list2=competitorService.getProductMonthNum1(year);
        List<MonthEntity> list3=competitorService.getProductMonthNum2(year);
        return R.ok().put("total",list).put("homeUse",list1).put("portable",list2).put("point",list3);
    }

    /**动态排行榜*/
    @RequestMapping("/selectRank")
    public R selectRank(String product){
        List<TopTenEntity> list = competitorService.getSelectRank(product);
        return R.ok().put("data",list);
    }

    /**多条件查询*/
    @RequestMapping("/selectMore")
    public R selectMore(String product,String value,String company ){
        List<ProductEntity> list = competitorService.getSelectMore(product,value,company);
        return R.ok().put("data",list);
    }


    /**公司总数量*/
    @RequestMapping("/selectTotalCompany")
    public R selectTotalCompany(){
        List<ProductEntity> list = competitorService.getTotalCompany();
        return R.ok().put("data",list);
    }

    /**本公司的证书数量*/
    @RequestMapping("/selectNumChiCheng")
    public R selectNumChiCheng(String year){
        List<CompanyEntity> list = competitorService.getNumChiCheng(year);
        return R.ok().put("data",list);
    }


    /**证书总数量*/
    @RequestMapping("/selectGasRanking")
    public R selectGasRanking(String product){
        List<GasRankingEntity> list = competitorService.getGasRanking(product);
        return R.ok().put("data",list);
    }
    /**证书细表Ⅱ*/
    @RequestMapping("/selectOtherGas")
    public R selectOtherGas(String product){
        List<OtherGasEntity> list = competitorService.getOtherGas(product);
        return R.ok().put("data",list);
    }

    /**证书使用情况*/
    @RequestMapping("/selectMethaneSensor")
    public R selectMethaneSensor(String product,String gasType){
        List<PropaneSensorEntity> list = competitorService.getMethaneSensor(product,gasType);
        return R.ok().put("data",list);
    }
    /**型号和传感器*/
    @RequestMapping("/selectModel")
    public R selectModel(String product,String value,String company){
        List<ProductEntity> list = competitorService.getModel(product,value,company);
        return R.ok().put("data",list);
    }

    /**ajax获取表中传感器名称*/
    @RequestMapping("/selectGetKeyModels")
    public R selectGetKeyModels(){
        List<CompanyEntity> list=competitorService.getKeyModels();
        return  R.ok().put("company",list);
    }



    /**家报分析Ⅰ表图和各类饼状图*/
    @RequestMapping("/selectMethaneRange")
    public R selectMethaneRange(String product){
        List<ProductEntity> list = competitorService.getMethaneRange(product);
        List<ProductEntity> list1 = competitorService.getMethaneAlarmPoint(product);
        List<ProductEntity> list2 = competitorService.getPropaneRange(product);
        List<ProductEntity> list3 = competitorService.getPropaneAlarmPoint(product);
        List<ProductEntity> list4 = competitorService.getCarbonMonoxideRange(product);
        List<ProductEntity> list5 = competitorService.getCarbonMonoxideAlarmPoint(product);
        return R.ok().put("data",list).put("data1",list1).put("data2",list2).put("data3",list3).put("data4",list4).put("data5",list5);
    }

}