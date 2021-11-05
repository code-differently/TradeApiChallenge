package com.codedifferently.tradeapichallenge.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User user1;
    private User user2;


    @BeforeEach
    public void setUp() {
         user1 = new User();
         user2 = new User("Jack Frost", 57983L);

    }
    @Test
    @DisplayName("Should the ID to the assigned ID")
    public void setIdTest() throws Exception{
        Long id = 344940L;

        user1.setId(59039L);

        Long expected = 59039L;
        Long actual = user1.getId();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Should set name to given name")
    public void setNameTest()throws Exception{
        String name = "Jack Frost";

        user1.setName("Kevin Hart");

        String expected = "Kevin Hart";
        String actual = user1.getName();

        Assertions.assertEquals(expected, actual);
    }





}