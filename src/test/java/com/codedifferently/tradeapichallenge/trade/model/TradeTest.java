package com.codedifferently.tradeapichallenge.trade;

import com.codedifferently.tradeapichallenge.trade.models.Trade;
import com.codedifferently.tradeapichallenge.user.User;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class TradeTest {


    @Test
    @DisplayName("get Id test---Success")
    void getIdTest001() {
        User ninja = new User(1L,"Naruto Uzi");
        User ninja2 = new User(2L,"Chris Farley");

        List<User> tron = new ArrayList<>();
        tron.add(ninja);
        tron.add(ninja2);

        Trade spy = new Trade(1L, "buy", tron, "AAPL", 50, 440.13);

        Long expected = 1L;
        Long actual = spy.getId();

        Assertions.assertEquals(expected,actual);


    }

    @Test
    @DisplayName("set Id test---Success")
    void setIdTest001() {
        User ninja = new User(1L,"Naruto Uzi");
        User ninja2 = new User(2L,"Chris Farley");

        List<User> tron = new ArrayList<>();
        tron.add(ninja);
        tron.add(ninja2);

        User userTest = new User(1L, "Naruto Uzi");
        Trade spy = new Trade(1L, "buy", tron, "AAPL", 50, 440.13);

        spy.setId(99L);

        Long expected = 99L;
        Long actual = spy.getId();

        Assertions.assertEquals(expected,actual);

    }

    @Test
    @DisplayName("get type test---Success")
    void getTypeTest() {
        User ninja = new User(1L,"Naruto Uzi");
        User ninja2 = new User(2L,"Chris Farley");

        List<User> tron = new ArrayList<>();
        tron.add(ninja);
        tron.add(ninja2);

        User userTest = new User(1L, "Naruto Uzi");
        Trade spy = new Trade("buy", tron, "AAPL", 50, 440.13);

        String expected = "buy";
        String actual = spy.getType();

        Assertions.assertEquals(expected,actual);

    }

    @Test
    @DisplayName("set type test---Success")
    void setTypeTest() {
        User ninja = new User(1L,"Naruto Uzi");
        User ninja2 = new User(2L,"Chris Farley");

        List<User> tron = new ArrayList<>();
        tron.add(ninja);
        tron.add(ninja2);

        User userTest = new User(1L, "Naruto Uzi");
        Trade spy = new Trade("buy", tron, "AAPL", 50, 440.13);

        spy.setType("sell");

        String expected = "sell";
        String actual = spy.getType();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("get type test---Success")
    void getUser() {
        User ninja = new User(1L,"Naruto Uzi");
        User ninja2 = new User(2L,"Chris Farley");

        List<User> tron = new ArrayList<>();
        tron.add(ninja);
        tron.add(ninja2);
        User userTest = new User(1L, "Naruto Uzi");
        Trade spy = new Trade("buy", tron, "AAPL", 50, 440.13);

        List<User> expected = tron;
        List<User> actual = spy.getUser();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("set User test---Success")
    void setUser() {
        User ninja = new User(1L,"Naruto Uzi");
        User ninja2 = new User(2L,"Chris Farley");

        List<User> tron = new ArrayList<>();
        tron.add(ninja);
        tron.add(ninja2);

        List<User> Quorra = new ArrayList<>();

        Trade spy = new Trade(1L, "buy", tron, "AAPL", 50, 440.13);

        List <User> expected = Quorra;
        List <User> auctal = spy.getUser();

    }

    @Test
    @DisplayName("get Symbol test---Success")
    void getSymbol() {
        User ninja = new User(1L,"Naruto Uzi");
        User ninja2 = new User(2L,"Chris Farley");

        List<User> tron = new ArrayList<>();
        tron.add(ninja);
        tron.add(ninja2);

        Trade spy = new Trade(1L, "buy", tron, "AAPL", 50, 440.13);

        String expected ="AAPL";
        String actual = spy.getSymbol();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("set symbol test---Success")
    void setSymbol() {
        User ninja = new User(1L,"Naruto Uzi");
        User ninja2 = new User(2L,"Chris Farley");

        List<User> tron = new ArrayList<>();
        tron.add(ninja);
        tron.add(ninja2);

        Trade spy = new Trade(1L, "buy", tron, "AAPL", 50, 440.13);
        spy.setSymbol("TSLA");
        String expected ="TSLA";
        String actual = spy.getSymbol();

        Assertions.assertEquals(expected,actual);

    }

    @Test
    @DisplayName("get shares test---Success")
    void getShares() {
        User ninja = new User(1L,"Naruto Uzi");
        User ninja2 = new User(2L,"Chris Farley");

        List<User> tron = new ArrayList<>();
        tron.add(ninja);
        tron.add(ninja2);

        Trade spy = new Trade(1L, "buy", tron, "AAPL", 50, 440.13);

        Integer expected =50;
        Integer actual = spy.getShares();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("set shares test---Success")
    void setShares() {
        User ninja = new User(1L,"Naruto Uzi");
        User ninja2 = new User(2L,"Chris Farley");

        List<User> tron = new ArrayList<>();
        tron.add(ninja);
        tron.add(ninja2);

        Trade spy = new Trade(1L, "buy", tron, "AAPL", 50, 440.13);
        spy.setShares(429);

        Integer expected =429;
        Integer actual = spy.getShares();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("get prices test---Success")
    void getPrice() {
        User ninja = new User(1L,"Naruto Uzi");
        User ninja2 = new User(2L,"Chris Farley");

        List<User> tron = new ArrayList<>();
        tron.add(ninja);
        tron.add(ninja2);

        Trade spy = new Trade(1L, "buy", tron, "AAPL", 50, 440.13);

        Double expected =440.13;
        Double actual = spy.getPrice();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("set prices test---Success")
    void setPrice() {
        User ninja = new User(1L,"Naruto Uzi");
        User ninja2 = new User(2L,"Chris Farley");

        List<User> tron = new ArrayList<>();
        tron.add(ninja);
        tron.add(ninja2);

        Trade spy = new Trade(1L, "buy", tron, "AAPL", 50, 440.13);
        spy.setPrice(22000.13);

        Double expected = 22000.13;
        Double actual = spy.getPrice();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("set type test---Success")
    void testToString() {
    }
}
