package com.codedifferently.tradeapichallenge.service;

import com.codedifferently.tradeapichallenge.exception.UserCreationException;
import com.codedifferently.tradeapichallenge.exception.UserNotFoundException;
import com.codedifferently.tradeapichallenge.models.User;

import java.util.List;

public interface UserService {

        User createTrade(User user) throws UserCreationException;
        List<User> getTrade(String type, User user, String symbol, Integer shares, Double price);
        User getById(Integer id) throws UserCreationException;
        User getAllTradesbyUserNames(String name) throws UserCreationException;
        Boolean updateTrade(Integer id, User user) throws UserNotFoundException;
        Boolean deleteTrade(Integer id) throws UserNotFoundException;
    }
}

