package com.uhcl.amazonsellers.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ProductForecast implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;

    private Integer leadTime;

    private Integer ooStock;

    private Integer reorder;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Product product;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
    }

    public Integer getOoStock() {
        return ooStock;
    }

    public void setOoStock(Integer ooStock) {
        this.ooStock = ooStock;
    }

    public Integer getReorder() {
        return reorder;
    }

    public void setReorder(Integer reorder) {
        this.reorder = reorder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
