package com.codedifferently.tradeapichallenge.trade;

import com.codedifferently.tradeapichallenge.user.User;

public class Trade {
    private Long id;
    private String type;
    private User user;
    private String symbol;
    private Integer shares;
    private Double price;

    public Trade(){}

    public Trade(String type, User user, String symbol, Integer shares, Double price){
        this.type = type;
        this.user = user;
        this.symbol = symbol;
        this.shares = shares;
        this.price = price;
    }
    public Trade(Long id, String type, User user, String symbol, Integer shares, Double price){
        this.id = id;
        this.type = type;
        this.user = user;
        this.symbol = symbol;
        this.shares = shares;
        this.price = price;
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

    @Override
    public String toString() {
        return "Trade{" +
                "type='" + type + '\'' +
                ", user=" + user +
                ", symbol='" + symbol + '\'' +
                ", shares=" + shares +
                ", price=" + price +
                '}';
    }
}
