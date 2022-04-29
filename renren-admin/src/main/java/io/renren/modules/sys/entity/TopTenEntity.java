package io.renren.modules.sys.entity;

import java.util.Objects;

public class TopTenEntity {
    private String company;
    private Integer num;
    private Integer num1;
    private Integer num2;
    private Integer num3;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getNum3() {
        return num3;
    }

    public void setNum3(Integer num3) {
        this.num3 = num3;
    }


    @Override
    public String toString() {
        return "TopTenEntity{" +
                "company='" + company + '\'' +
                ", num=" + num +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", num3=" + num3 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopTenEntity that = (TopTenEntity) o;
        return Objects.equals(company, that.company) && Objects.equals(num, that.num) && Objects.equals(num1, that.num1) && Objects.equals(num2, that.num2) && Objects.equals(num3, that.num3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompany(), getNum());
    }
}
