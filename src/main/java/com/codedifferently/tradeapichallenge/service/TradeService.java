package com.codedifferently.tradeapichallenge.service;

import com.codedifferently.tradeapichallenge.exception.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.model.Trade;

import java.util.List;

public interface TradeService {
    public List<Trade> getAllTrades();

    public Trade getTradeByUserName(String name) throws TradeNotFoundException;

    public Trade create(Trade trade);

    public Trade updateTrade(String name, Trade trade) throws TradeNotFoundException;

    public Boolean deleteTrade(String name) throws TradeNotFoundException;
}
