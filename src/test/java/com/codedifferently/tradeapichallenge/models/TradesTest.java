package com.codedifferently.tradeapichallenge.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TradesTest {
    private User user1;
    private User user2;
    private Trades trade1;
    private Trades trade2;


    @BeforeEach
    public void setUp() {
        user1 = new User();
        user2 = new User();
        trade1 = new Trades();
        trade2 = new Trades();

//        List<Trades> trade = new ArrayList<>();
//        trade.add(new Trades(user1, "Buy", "AMZN", 20, 160.62));
//        trade.add(new Trades(user2, "Sell", "DOGE", 100, 141.13));

    }

    @Test
    @DisplayName("Should set the ID to given ID")
    public void setIdTest() throws Exception{
        Long id = 667891L;

        trade1.setId(844482L);

        Long expected = 844482L;
        Long actual = trade1.getId();

        Assertions.assertEquals(expected, actual);

    }
    @Test
    @DisplayName("Should set User to given User name")
    public void setUserTest() throws Exception{
        User user = user1;

        trade1.setUser(user1);

        User expected = user1;
        User actual = trade1.getUser();

        Assertions.assertEquals(expected,actual);
    }


    @Test
    @DisplayName("Should set type to 'Buy' : success")
    public void setTypeTest() throws Exception {

        String type = "Sell";

        trade1.setType("Buy");

        String expected = "Buy";
        String actual = trade1.getType();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Should set the symbol to AAPL")
    public void setSymbolTest() throws Exception{
        String symbol = "AMZN";

        trade2.setSymbol("AAPL");

        String expected = "AAPL";
        String actual = trade2.getSymbol();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Should set shares to 100")
    public void setSharesTest() throws Exception {

        Integer shares = 50;

        //When
        trade1.setShares(100);

        //Then
        Integer expected = 100;
        Integer actual = trade1.getShares();

        Assertions.assertEquals(expected, actual);

    }
    @Test
    @DisplayName("Should set price to price set")
    public void setPriceTest() throws Exception{
        Double price = 143.00;

        trade1.setPrice(166.73);

        Double expected = 166.73;
        Double actual = trade1.getPrice();;

        Assertions.assertEquals(expected, actual);
    }






}
