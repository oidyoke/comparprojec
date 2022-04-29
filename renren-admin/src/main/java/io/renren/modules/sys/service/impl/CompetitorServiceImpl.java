package io.renren.modules.sys.service.impl;

import io.renren.modules.sys.entity.*;
import io.renren.modules.sys.excel.CompetitorExcel;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.CompetitorDao;
import io.renren.modules.sys.service.CompetitorService;


@Service("competitorService")
public class CompetitorServiceImpl extends ServiceImpl<CompetitorDao, CompetitorEntity> implements CompetitorService {

@Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("company");
        String name1 = (String)params.get("product");
        String name2 = (String)params.get("model");
        String name3 = (String)params.get("fertificate");
        String name4 = (String)params.get("standardnumber");
        String name5 = (String)params.get("keymodels");
        String name6 = (String)params.get("keymanufacturers");
        String name7 = (String)params.get("powerupply");
        String name8 = (String)params.get("gastype");
        String name9 = (String)params.get("rangey");
        String name10 = (String)params.get("alarm");
        String name11 = (String)params.get("material");
        String name12 = (String)params.get("workingmode");
        String name13 = (String)params.get("samplingmode");
        String name14 = (String)params.get("usecondition");
        String name15 = (String)params.get("displayfunction");
        String name16 = (String)params.get("outputnode");
        String name17 = (String)params.get("inspectionorganization");
        IPage<CompetitorEntity> page = this.page(
                new Query<CompetitorEntity>().getPage(params),
                new QueryWrapper<CompetitorEntity>()
                        .orderByDesc("id")
                        .like(StringUtils.isNotBlank(name),"company", name)
                        .like(StringUtils.isNotBlank(name1),"product", name1)
                        .like(StringUtils.isNotBlank(name2),"model", name2)
                        .like(StringUtils.isNotBlank(name3),"fertificate", name3)
                        .like(StringUtils.isNotBlank(name4),"standardnumber", name4)
                        .like(StringUtils.isNotBlank(name5),"keymodels", name5)
                        .like(StringUtils.isNotBlank(name6),"keymanufacturers", name6)
                        .like(StringUtils.isNotBlank(name7),"powerupply", name7)
                        .like(StringUtils.isNotBlank(name8),"gastype", name8)
                        .like(StringUtils.isNotBlank(name9),"rangey", name9)
                        .like(StringUtils.isNotBlank(name10),"alarm", name10)
                        .like(StringUtils.isNotBlank(name11),"material", name11)
                        .like(StringUtils.isNotBlank(name12),"workingmode", name12)
                        .like(StringUtils.isNotBlank(name13),"samplingmode", name13)
                        .like(StringUtils.isNotBlank(name14),"usecondition", name14)
                        .like(StringUtils.isNotBlank(name15),"displayfunction", name15)
                        .like(StringUtils.isNotBlank(name16),"outputnode", name16)
                        .like(StringUtils.isNotBlank(name17),"inspectionorganization", name17)
        );

        return new PageUtils(page);
    }

    @Override
    public void saveList(List<CompetitorExcel> list) {
     baseMapper.saveList(list);
    }

    @Override
    public void save(List<CompetitorExcel> list) {
        baseMapper.save(list);
    }


    @Override
    public List<CompetitorExcel> getAll() {
        return this.baseMapper.selectAll();
    }

    @Override
    public List<TopTenEntity> getTopTen() {
        return this.baseMapper.selectTopTen();
    }

    @Override
    public List<MonthEntity> getMonthCount(String yearId) {
        return this.baseMapper.selectMonthCount(yearId);
    }

    @Override
    public List<CompanyEntity> getCompanyName() {
        return this.baseMapper.selectCompany();
    }

    @Override
    public List<CompanyEntity> getPowerUpplyName() {
        return this.baseMapper.selectPowerUpply();
    }

    @Override
    public List<CompanyEntity> getGasTypeName() {
        return this.baseMapper.selectGasType();
    }

    @Override
    public List<CompanyEntity> getRangeyName() {
        return this.baseMapper.selectRangey();
    }

    @Override
    public List<CompanyEntity> getAlarmName() {
        return this.baseMapper.selectAlarm();
    }

    @Override
    public List<CompanyEntity> getInspectionorganizationName() {
        return this.baseMapper.selectInspectionorganization();
    }

    @Override
    public List<ProductEntity> getProduct(String company) {
        return this.baseMapper.selectProduct(company);
    }

    @Override
    public List<MonthEntity> getProductMonthNum(String year) {
        return this.baseMapper.selectProductMonthNum(year);
    }

    @Override
    public List<MonthEntity> getProductMonthNum1(String year) {
        return this.baseMapper.selectProductMonthNum1(year);
    }

    @Override
    public List<MonthEntity> getProductMonthNum2(String year) {
        return this.baseMapper.selectProductMonthNum2(year);
    }

    @Override
    public List<TopTenEntity> getSelectRank(String product) {
        return this.baseMapper.selectAddTopTenRank(product);
    }
    @Override
    public List<ProductEntity> getSelectMore(String product, String value, String company) {
        return this.baseMapper.selectMoreValue(product,value,company);
    }

    @Override
    public List<ProductEntity> getTotalCompany() {
        return this.baseMapper.selectTotalCompany();
    }

    @Override
    public List<CompanyEntity> getNumChiCheng(String year){
        return  this.baseMapper.selectNumChiCheng(year);
    }






    @Override
    public List<GasRankingEntity> getGasRanking(String product){ return  this.baseMapper.selectGasRanking(product); }
    @Override
    public List<PropaneSensorEntity> getMethaneSensor(String product,String gasType){ return  this.baseMapper.selectMethaneSensor(product,gasType); }
    @Override
    public List<PropaneSensorEntity> getPropaneSensor(String product){ return  this.baseMapper.selectPropaneSensor(product); }
    @Override
    public List<PropaneSensorEntity> getCarbonMonoxideSensor(String product){ return  this.baseMapper.selectCarbonMonoxideSensor(product); }

    @Override
    public List<OtherGasEntity> getOtherGas(String product) {
        return this.baseMapper.selectOtherGas(product);
    }

    @Override
    public List<ProductEntity> getModel(String product, String model, String keymodels) {
        return this.baseMapper.selectModel(product,model,keymodels);
    }

    @Override
    public List<CompanyEntity> getKeyModels() {
        return this.baseMapper.selectKeyModels();
    }


    @Override
    public List<ProductEntity> getMethaneRange(String product){ return  this.baseMapper.selectMethaneRange(product); }
    @Override
    public List<ProductEntity> getMethaneAlarmPoint(String product){ return  this.baseMapper.selectMethaneAlarmPoint(product); }
    @Override
    public List<ProductEntity> getPropaneRange(String product){ return  this.baseMapper.selectPropaneRange(product); }
    @Override
    public List<ProductEntity> getPropaneAlarmPoint(String product){ return  this.baseMapper.selectPropaneAlarmPoint(product); }
    @Override
    public List<ProductEntity> getCarbonMonoxideRange(String product){ return  this.baseMapper.selectCarbonMonoxideRange(product); }
    @Override
    public List<ProductEntity> getCarbonMonoxideAlarmPoint(String product){ return  this.baseMapper.selectCarbonMonoxideAlarmPoint(product); }


}
