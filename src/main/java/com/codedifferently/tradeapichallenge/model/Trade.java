package com.codedifferently.tradeapichallenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;
    private String symbol;
    private Integer shares;
    private Double price;

    @OneToMany(cascade = CascadeType.ALL)
    private List<User> user;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String timestamp;

    public Trade() {
    }

    public Trade(String type, String symbol, Integer shares, Double price, List<User> user, String timestamp) {
        this.type = type;
        this.symbol = symbol;
        this.shares = shares;
        this.price = price;
        this.user = user;
        this.timestamp = timestamp;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", symbol='" + symbol + '\'' +
                ", shares=" + shares +
                ", price=" + price +
                ", user=" + user +
                ", timestamp=" + timestamp +
                '}';
    }
}
