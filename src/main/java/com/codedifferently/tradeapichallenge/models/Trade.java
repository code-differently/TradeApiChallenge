package com.codedifferently.tradeapichallenge.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Trade {

    @Id
    @GeneratedValue
    private Integer id;

    private String type;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String symbol;
    private Integer shares;
    private Double price;

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return id.equals(trade.id) && type.equals(trade.type) && user.equals(trade.user) && symbol.equals(trade.symbol) && shares.equals(trade.shares) && price.equals(trade.price);
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", user=" + user +
                ", symbol='" + symbol + '\'' +
                ", shares=" + shares +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, user, symbol, shares, price);
    }

    public Trade(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
