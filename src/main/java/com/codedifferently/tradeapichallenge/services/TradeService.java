package com.codedifferently.tradeapichallenge.services;

import com.codedifferently.tradeapichallenge.exceptions.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.models.Trade;

import java.util.List;

public interface TradeService {
    Trade create(Trade trade);
    Trade getTradeByUserName(String userName) throws TradeNotFoundException;
    List<Trade> getAllTrades();
    Trade updateTrade(Integer id, Trade trade) throws TradeNotFoundException;
    Boolean deleteTrade(Integer id) throws TradeNotFoundException;
}
