package com.uhcl.amazonsellers.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Product implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;

    private String name;

    private String imgUrl;

    private String asin;

    private String description;

    private String sku;

    private Integer currentStock;

    private BigDecimal salesVelocity;

    private String category;

    private Long sellerId;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private ProductForecast productForecast;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public BigDecimal getSalesVelocity() {
        return salesVelocity;
    }

    public void setSalesVelocity(BigDecimal salesVelocity) {
        this.salesVelocity = salesVelocity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ProductForecast getProductForecast() {
        return productForecast;
    }

    public void setProductForecast(ProductForecast productForecast) {
        this.productForecast = productForecast;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
