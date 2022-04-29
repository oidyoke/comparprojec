package io.renren.modules.sys.entity;

public class GasRankingEntity {

    /**公司名称*/
    private String company;

    /**气体总数*/
    private Integer totalgasnumber;

    /**甲烷*/
    private Integer methane;

    /**丙烷*/
    private Integer propane;

    /**一氧化碳*/
    private Integer carbonmonoxide;

    /**甲烷和一氧化碳*/
    private Integer doubleqi;


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getTotalgasnumber() {
        return totalgasnumber;
    }

    public void setTotalgasnumber(Integer totalgasnumber) {
        this.totalgasnumber = totalgasnumber;
    }

    public Integer getMethane() {
        return methane;
    }

    public void setMethane(Integer methane) {
        this.methane = methane;
    }

    public Integer getPropane() {
        return propane;
    }

    public void setPropane(Integer propane) {
        this.propane = propane;
    }

    public Integer getCarbonmonoxide() {
        return carbonmonoxide;
    }

    public void setCarbonmonoxide(Integer carbonmonoxide) {
        this.carbonmonoxide = carbonmonoxide;
    }

    public Integer getDoubleqi() {
        return doubleqi;
    }

    public void setDoubleqi(Integer doubleqi) {
        this.doubleqi = doubleqi;
    }
}
