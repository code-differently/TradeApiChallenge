package com.codedifferently.tradeapichallenge.services;

import com.codedifferently.tradeapichallenge.exceptions.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.models.Trade;

import java.util.List;

public interface TradeService {

    List<Trade> getAllTrades();
    Trade getTradeByUserName(String name) throws TradeNotFoundException;
    Trade create(Trade trade);
    Trade updateTrade(Long id, Trade trade) throws TradeNotFoundException;
    Boolean deleteTrade(Long id) throws TradeNotFoundException;

}
