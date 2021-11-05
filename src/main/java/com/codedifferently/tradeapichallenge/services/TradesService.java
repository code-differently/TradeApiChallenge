package com.codedifferently.tradeapichallenge.services;

import com.codedifferently.tradeapichallenge.exceptions.TradeNotFoundExcetion;
import com.codedifferently.tradeapichallenge.exceptions.UserNotFoundException;
import com.codedifferently.tradeapichallenge.models.Trades;
import com.codedifferently.tradeapichallenge.models.User;

import java.util.List;

public interface TradesService {
    Trades createTrade(Trades trade);
    List<Trades> getAllTrades();
    List<Trades> getAllTradesByUserName(User name) throws UserNotFoundException;
    Trades updateTrade(Integer id, Trades trade) throws TradeNotFoundExcetion;
    Boolean deleteTrade(Integer id, Trades trades) throws TradeNotFoundExcetion;

}
