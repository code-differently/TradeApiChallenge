package com.codedifferently.tradeapichallenge.models;

import javax.persistence.*;

@Entity
@Table(name = "Trades")
public class Trades {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    private Long id;
    @Column
    private User user;
    @Column
    private String type;
    @Column
    private String symbol;
    @Column
    private Integer shares;
    @Column
    private Double price;

    public Trades(){}

    public Trades(User user, String type, String symbol, Integer shares, Double price){
        this.user = user;
        this.type = type;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type)  {
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
}
