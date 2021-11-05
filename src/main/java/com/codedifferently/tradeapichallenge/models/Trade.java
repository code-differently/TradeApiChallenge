package com.codedifferently.tradeapichallenge.models;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
public class Trade {

    @Id
    @GeneratedValue
    private Long id;
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    private String symbol;
    private Integer shares;
    private Double price;
    private String timeStamp;

    public Trade(){}

    public Trade(String type, User user, String symbol, Integer shares, Double price, String timeStamp){
        this.type = type;
        this.user = user;
        this.symbol = symbol;
        this.shares = shares;
        this.price = price;
        this.timeStamp = timeStamp;
    }

    public String checkIfTypeIsCorrect(String type){
        String message = "correct type";
        if (!type.contains("buy") || !type.contains("sell")){
            message = "not a valid type";
        }
        return message;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
