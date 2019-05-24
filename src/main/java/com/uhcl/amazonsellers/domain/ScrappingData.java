package com.uhcl.amazonsellers.domain;

import java.util.Date;
import javax.persistence.*;

@Entity
public class ScrappingData {
    @Id
    @Column(name = "id")
    private long id = System.nanoTime();

    @Column
    private String asin;

    @Column
    private Date recordedTime = new Date();

    @Column
    private Integer rank;
    @Column
    private Integer pageFlag;

    @Column
    private String sellerId;
    @Column
    private String country;

    @Column
    private Long queryId;

    @Column
    private String category;

    @Column
    private String bestSellerUrl;

    public long getId() {
        return id;
    }


    public String getBestSellerUrl() {
        return bestSellerUrl;
    }

    public void setBestSellerUrl(String bestSellerUrls) {
        this.bestSellerUrl = bestSellerUrls;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }


    public Date getRecordedTime() {
        return recordedTime;
    }

    public void setRecordedTime(Date recordedTime) {
        this.recordedTime = recordedTime;
    }



    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "ScrappingData{" +
                "id=" + id +
                ", asin='" + asin + '\'' +
                ", recordedTime=" + recordedTime +
                ", country=" + country+
                ", bestSellerUrl=" + bestSellerUrl+
                ", category=" + category+
                ", rank=" + rank +
                ", queryId=" + queryId+
                ", sellerId='" + sellerId +
                '}';
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getCountry() {
        return country;
    }

    public void setCurrency(String currency) {
        this.country = currency;
    }


}
