package com.codedifferently.tradeapichallenge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TradeTest {

    private Trade trade1;
    private Trade trade2;

    private Trade emptyTrade1;
    private  Trade emptyTrade2;

    @BeforeEach
    void setUp() {
        emptyTrade1 = new Trade();
        emptyTrade2 = new Trade();

        List<User> users = new ArrayList<>();
        users.add(new User("Mike"));
        users.add(new User("John"));

        trade1 = new Trade("Buy","CC",7,50.23,users,"2018-12-28 13:18:48");
        trade1.setId(1L);

        trade2 = new Trade("Buy","BB",6,43.23,users,"2018-1-28 15:18:48");
        trade2.setId(2L);
    }

    @Test
    public void testEmptyEquals() throws Exception {

        assertTrue(
                emptyTrade1.equals(emptyTrade2),
                "Both empty Trade instances should be equal");
    }

    @Test
    public void testContentEquals() throws Exception {

        assertTrue(
                trade1.equals(trade2),
                "Both non-empty Trades instances should be equal");
    }

    @Test
    public void testNotEquals() throws Exception {

        assertFalse(
                emptyTrade1.equals(trade2),
                "The Trade instances should not be equal");
    }

    @Test
    public void testEmptyToString() throws Exception {

        assertEquals(
                emptyTrade1.toString(),
                emptyTrade2.toString(),
                "Both empty Trade instances should have the same toString");
    }

    @Test
    public void testContentToString() throws Exception {

        assertEquals(
                trade1.toString(),
                trade2.toString(),
                "Both non-empty Trade instances should have the same toString");
    }

    @Test
    public void testNotToString() throws Exception {

        assertNotEquals(
                emptyTrade1.toString(),
                trade2.toString(),
                "The Widget instances should not have the same toString");
    }
    }
