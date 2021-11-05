package com.codedifferently.tradeapichallenge.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public List<Trade> getTrade(String type, User user, String symbol, Integer shares, Double price) {
        return trade;
    }

    public void setTrade(List<Trade> trade) {
        this.trade = trade;
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<Trade> trade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public User(){

    }
}
