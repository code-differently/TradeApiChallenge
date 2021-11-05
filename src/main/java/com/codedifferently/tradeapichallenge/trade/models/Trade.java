package com.codedifferently.tradeapichallenge.trade.models;

import com.codedifferently.tradeapichallenge.user.User;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    private List<User> user;

    private String symbol;
    private Integer shares;
    private Double price;

    public Trade(){}

    public Trade(String type, List<User> user, String symbol, Integer shares, Double price){
        this.type = type;
        this.user = user;
        this.symbol = symbol;
        this.shares = shares;
        this.price = price;
    }
    public Trade(Long id, String type, List<User> user, String symbol, Integer shares, Double price){
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

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return Objects.equals(id, trade.id) && Objects.equals(user, trade.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
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
