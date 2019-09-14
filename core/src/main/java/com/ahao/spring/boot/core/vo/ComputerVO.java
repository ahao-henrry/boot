package com.ahao.spring.boot.core.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author ahao
 * @since 2019/7/15 21:31
 **/
public class ComputerVO {
    private Integer id;
    private String brand;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date productionDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String toString() {
        return "ComputerVO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", productionDate=" + productionDate +
                '}';
    }
}
