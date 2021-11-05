package com.codedifferently.tradeapichallenge.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TradeTest {

    private User inputUser;

    private Trade trade1;
    private Trade trade2;

    private Trade emptyTrade1;
    private Trade emptyTrade2;

    @BeforeEach
    public void setUp(){

        inputUser = new User(1L, "DeShawn");

        emptyTrade1 = new Trade();
        emptyTrade2 = new Trade();

        trade1 = new Trade("buy", inputUser, "BB", 12, 189.95);
        trade1.setId(1L);

        trade2 = new Trade("buy", inputUser, "CC", 10, 150.95);
        trade2.setId(2L);
    }

    @Test
    public void tradeEmptyEquals() throws Exception{

        assertTrue(
                emptyTrade1.equals(emptyTrade2),
                "Both empty Trade instances should be equal");
    }

    @Test
    public void tradeTestContentEquals() throws Exception{

        assertFalse(
                trade1.equals(trade2),
                "Both non-empty Trade instances should be equal");

    }

    @Test
    public void tradeTestNotEqual() throws Exception{

        assertFalse(
                emptyTrade1.equals(trade1),
                "The Trade instances should not be equal");
    }

    @Test
    public void tradeTestEmptyToString() throws Exception{

        assertEquals(
                emptyTrade1.toString(),
                emptyTrade2.toString(),
                "Both empty Trade instances should have the same toString");

    }

    @Test
    public void tradeContentToString() throws Exception{

        assertNotEquals(
                trade1.toString(),
                trade2.toString(),
                "Both non-empty Trade instances should have the same toString");
    }

    @Test
    public void tradeTestNotToString() throws Exception{

        assertNotEquals(
                emptyTrade1.toString(),
                trade2.toString(),
                "The Trade instances should not have the same toString");
    }


}
