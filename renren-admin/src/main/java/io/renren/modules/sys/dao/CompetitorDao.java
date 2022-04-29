package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.excel.CompetitorExcel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2022-01-17 09:32:49
 */
@Mapper
public interface CompetitorDao extends BaseMapper<CompetitorEntity> {

    void saveList(List<CompetitorExcel> list);

    void save(List<CompetitorExcel> list);

    List<CompetitorExcel> selectAll();

    List<TopTenEntity> selectTopTen();

    List<MonthEntity> selectMonthCount(String yearId);

    List<MonthEntity> selectProductMonthNum(String yearId);

    List<MonthEntity> selectProductMonthNum1(String yearId);

    List<MonthEntity> selectProductMonthNum2(String yearId);

    List<TopTenEntity> selectAddTopTenRank(String product);

    List<ProductEntity> selectMoreValue(@Param("product") String product,@Param("value") String value,@Param("company") String company );


    List<CompanyEntity> selectCompany();

    List<CompanyEntity> selectPowerUpply();

    List<CompanyEntity> selectGasType();

    List<CompanyEntity> selectRangey();

    List<CompanyEntity> selectAlarm();

    List<CompanyEntity> selectInspectionorganization();

    List<ProductEntity> selectProduct(String company);

    List<ProductEntity> selectTotalCompany();

    List<CompanyEntity> selectNumChiCheng(@Param("year") String year);







    List<PropaneSensorEntity> selectMethaneSensor(@Param("product") String product,@Param("gasType")String gasType);

    List<PropaneSensorEntity> selectPropaneSensor(@Param("product") String product);

    List<PropaneSensorEntity> selectCarbonMonoxideSensor(@Param("product") String product);


    List<GasRankingEntity> selectGasRanking(@Param("product") String product);

    List<ProductEntity> selectMethaneRange(@Param("product") String product);

    List<ProductEntity> selectMethaneAlarmPoint(@Param("product") String product);

    List<ProductEntity> selectPropaneRange(@Param("product") String product);

    List<ProductEntity> selectPropaneAlarmPoint(@Param("product") String product);

    List<ProductEntity> selectCarbonMonoxideRange(@Param("product") String product);

    List<ProductEntity> selectCarbonMonoxideAlarmPoint(@Param("product") String product);

    List<OtherGasEntity> selectOtherGas(@Param("product")String product);

    List<ProductEntity> selectModel(@Param("product") String product, @Param("model") String model, @Param("keymodels") String keymodels);

    List<CompanyEntity> selectKeyModels();
}
