package io.renren.modules.sys.entity;

public class PropaneSensorEntity {

    /**丙烷传感器名称*/
    private String value;

    /**生产厂家*/
    private String manufacturer;

    /**使用厂家数量*/
    private Integer usefacturernumber;

    /**占总数比例*/
    private String totalproportion;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getUsefacturernumber() {
        return usefacturernumber;
    }

    public void setUsefacturernumber(Integer usefacturernumber) {
        this.usefacturernumber = usefacturernumber;
    }

    public String getTotalproportion() {
        return totalproportion;
    }

    public void setTotalproportion(String totalproportion) {
        this.totalproportion = totalproportion;
    }
}
