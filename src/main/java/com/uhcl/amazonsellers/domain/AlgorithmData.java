package com.uhcl.amazonsellers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class AlgorithmData {
    @Id
    @Column(name = "id")
    private long id = System.nanoTime();

    @Column(length = 65535, columnDefinition = "text")
    private String text; //keyword
    @Column
    private Double score;
    @Column
    private Long amazonDataId;
    @Column
    private String algorithmType;
    @Column
    private Date dataCreated = new Date();
    @Column
    private String uniqueCrawledId;
    @Column
    private Integer summaryFlag=0; // 1 represent the summary of whole
    @Column
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Long getAmazonDataId() {
        return amazonDataId;
    }

    @Override
    public String toString() {
        return "AlgorithmData{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", score=" + score +
                ", amazonDataId=" + amazonDataId +
                ", algorithmType='" + algorithmType + '\'' +
                ", dataCreated=" + dataCreated +
                ", uniqueCrawledId='" + uniqueCrawledId + '\'' +
                ", type=" + type +
                ", summaryFlag=" + summaryFlag +
                '}';
    }

    public void setAmazonDataId(Long amazonDataId) {
        this.amazonDataId = amazonDataId;
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(String algorithmType) {
        this.algorithmType = algorithmType;
    }

    public Date getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(Date dataCreated) {
        this.dataCreated = dataCreated;
    }

    public String getUniqueCrawledId() {
        return uniqueCrawledId;
    }

    public void setUniqueCrawledId(String uniqueCrawledId) {
        this.uniqueCrawledId = uniqueCrawledId;
    }

    public Integer getSummaryFlag() {
        return summaryFlag;
    }

    public void setSummaryFlag(Integer summaryFlag) {
        this.summaryFlag = summaryFlag;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
