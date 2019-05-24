package com.uhcl.amazonsellers.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class AmazonData {
    @Id
    @Column(name = "id")
    private long id = System.nanoTime();
    @Column
    private Double originalPrice;
    @Column
    private Double salePrice;
    @Column
    private Double upperBoundPrice;
    @Column
    private String productTitle;
    @Column
    private Integer availability;
    @Column
    private Integer prime;
    @Column
    private String sellerName; //
    @Column
    private String productReviews;
    @Column
    private Integer pictureAvailable; //1 is for prime 0 is non prime.

    @Column
    private String asin;
    @Column
    private String url;
    @Column
    private Integer primeShipping;
    @Column
    private Integer isAmazonFullfilled;
    @CreatedDate
    private Date createdDate = new Date();
    @LastModifiedDate
    private Date lastModifiedDate =new Date();
    @Column
    private Integer rank;
    @Column
    private String sellerId; //
    @Column
    private String country;

    @Column(length = 65535, columnDefinition = "text")
    private String productDescription;

    @Column
    private String keywords;


    @Column
    private boolean isProcessed = false;
    @Column
    private String category; //
    @Column
    private Long queryId;
    @Column
    private Integer isAmazonChoice;
    @Column
    private String uniqueCrawledId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getUpperBoundPrice() {
        return upperBoundPrice;
    }

    public void setUpperBoundPrice(Double upperBoundPrice) {
        this.upperBoundPrice = upperBoundPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Integer getPrime() {
        return prime;
    }

    public void setPrime(Integer prime) {
        this.prime = prime;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getProductReviews() {
        return productReviews;
    }

    public void setProductReviews(String productReviews) {
        this.productReviews = productReviews;
    }

    public Integer getPictureAvailable() {
        return pictureAvailable;
    }

    public void setPictureAvailable(Integer pictureAvailable) {
        this.pictureAvailable = pictureAvailable;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPrimeShipping() {
        return primeShipping;
    }

    public void setPrimeShipping(Integer primeShipping) {
        this.primeShipping = primeShipping;
    }

    public Integer getIsAmazonFullfilled() {
        return isAmazonFullfilled;
    }

    public void setIsAmazonFullfilled(Integer isAmazonFullfilled) {
        this.isAmazonFullfilled = isAmazonFullfilled;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getRank() {
        return rank;
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

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }

    public Integer getIsAmazonChoice() {
        return isAmazonChoice;
    }

    public void setIsAmazonChoice(Integer isAmazonChoice) {
        this.isAmazonChoice = isAmazonChoice;
    }

    public String getUniqueCrawledId() {
        return uniqueCrawledId;
    }

    public void setUniqueCrawledId(String uniqueCrawledId) {
        this.uniqueCrawledId = uniqueCrawledId;
    }
}
