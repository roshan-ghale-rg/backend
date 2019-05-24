package com.uhcl.amazonsellers.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class SellerCashflow {
    @Id
    @Column
    private long id = System.nanoTime();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }
    @Column
    private int sellerId;
    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Column
    private int sales;

    public void setSales(int sales) {
        this.sales = sales;
    }


    @Column
    private int profit;


    public int getProfit() {
        return profit;
    }



    public int getSales() {
        return sales;
    }

    @Column
    private Date date;

    @Override
    public String toString() {
        return "TurnOver{" +
                "Id=" + id +
                ", sellerId='" + sellerId + '\'' +
                ", sales='" + sales + '\'' +
                ", profit='" + profit + '\'' +
                '}';
    }



    public void setProfit(int profit) {
        this.profit = profit;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
