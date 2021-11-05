package com.codedifferently.tradeapichallenge.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserTest {

    private User user1;
    private User user2;

    private User emptyUser1;
    private User emptyUser2;

    @BeforeEach
    public void setUp(){

        emptyUser1 = new User();
        emptyUser2 = new User();

        user1 = new User(1L, "DeShawn");

        user2 = new User(2L, "Lebron");
    }

    @Test
    public void userEmptyEquals() throws Exception{

        assertTrue(
                emptyUser1.equals(emptyUser2),
                "Both empty User instances should be equal");
    }

    @Test
    public void userTestContentEquals() throws Exception{

        assertFalse(
                user1.equals(user2),
                "Both non-empty User instances should be equal");

    }

    @Test
    public void tradeTestNotEqual() throws Exception{

        assertFalse(
                emptyUser1.equals(user1),
                "The Trade instances should not be equal");
    }

    @Test
    public void tradeTestEmptyToString() throws Exception{

        assertEquals(
                emptyUser1.toString(),
                emptyUser2.toString(),
                "Both empty User instances should have the same toString");

    }

    @Test
    public void tradeContentToString() throws Exception{

        assertNotEquals(
                user1.toString(),
                user2.toString(),
                "Both non-empty User instances should have the same toString");
    }

    @Test
    public void tradeTestNotToString() throws Exception{

        assertNotEquals(
                emptyUser1.toString(),
                user2.toString(),
                "The Trade instances should not have the same toString");
    }

}
