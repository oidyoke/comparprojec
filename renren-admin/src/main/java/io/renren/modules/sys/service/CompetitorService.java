package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.*;
import io.renren.modules.sys.excel.CompetitorExcel;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-01-17 09:32:49
 */
public interface CompetitorService extends IService<CompetitorEntity> {

    PageUtils queryPage(Map<String, Object> params);
    void saveList(List<CompetitorExcel> list);
    void save(List<CompetitorExcel> list);
    List<CompetitorExcel> getAll();

    //表表分析Ⅰ
    /**每个月的证书数量*/
    List<MonthEntity> getMonthCount(String yearId);

    /**ajax获取对应的名称*/
    List<CompanyEntity> getCompanyName();

    List<CompanyEntity> getPowerUpplyName();

    List<CompanyEntity> getGasTypeName();

    List<CompanyEntity> getRangeyName();

    List<CompanyEntity> getAlarmName();

    List<CompanyEntity> getInspectionorganizationName();

    /**各类气体探测器的数量*/
    List<ProductEntity> getProduct(String company);

    /**证书数量前十的公司*/
    List<TopTenEntity> getTopTen();
    /**动态排行榜 根据探测器类型*/
    List<TopTenEntity> getSelectRank(String product);

    /**各探测器产品数量折线图*/
    List<MonthEntity> getProductMonthNum(String year);
    List<MonthEntity> getProductMonthNum1(String year);
    List<MonthEntity> getProductMonthNum2(String year);

    //报表分析Ⅱ
    /**证书数量及公司数量*/
    List<ProductEntity> getTotalCompany();
    /**（驰骋）本公司信息*/
    List<CompanyEntity> getNumChiCheng(String year);
    /**报表分析Ⅱ动态查询*/
    List<ProductEntity> getSelectMore(String product, String value, String company);

    /**家报分Ⅰ所有数据*/
    List<GasRankingEntity> getGasRanking(String product);
    List<ProductEntity> getMethaneRange(String product);
    List<ProductEntity> getMethaneAlarmPoint(String product);
    List<ProductEntity> getPropaneRange(String product);
    List<ProductEntity> getPropaneAlarmPoint(String product);
    List<ProductEntity> getCarbonMonoxideRange(String product);
    List<ProductEntity> getCarbonMonoxideAlarmPoint(String product);


    /**家报分析Ⅱ甲烷、丙烷、一氧化碳信息表*/
    List<PropaneSensorEntity> getMethaneSensor(String product,String gasType);
    List<PropaneSensorEntity> getPropaneSensor(String product);
    List<PropaneSensorEntity> getCarbonMonoxideSensor(String product);


    List<OtherGasEntity> getOtherGas(String product);

    List<ProductEntity> getModel(String product, String model, String keymodels);

    List<CompanyEntity> getKeyModels();
}

