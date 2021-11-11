package com.codedifferently.tradeapichallenge.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    @Test
    @DisplayName("get id test--Success")
    public void getIdTest01() {
        User userTest = new User(1L, "Naruto Uzi");

        Long expected = 1L;
        Long actual = userTest.getId();

        Assertions.assertEquals(expected,actual);


    }

    @Test
    @DisplayName("set id test--Success")
    public void setIdTest01() {

        User userTest = new User(1L, "Naruto Uzi");
        userTest.setId(99L);

        Long expected = 99L;
        Long actual = userTest.getId();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("get name test--Success")
    public void getNameTest01() {
        User userTest = new User(1L, "Naruto Uzi");

        String expected = "Naruto Uzi";
        String actual = userTest.getName();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("set name test--Success")
    public void setNameTest01() {
        User userTest = new User(1L, "Naruto Uzi");
        userTest.setName("Lil Uzi");

        String expected = "Lil Uzi";
        String actual = userTest.getName();

        Assertions.assertEquals(expected,actual);
    }
}