package com.codedifferently.tradeapichallenge.trade.services;

import com.codedifferently.tradeapichallenge.trade.models.Trade;
import com.codedifferently.tradeapichallenge.trade.exceptions.TradeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TradeService {

    Trade create(Trade trade);

    Trade getTradeByUser(String userName) throws TradeNotFoundException;
    List<Trade> getAllTrade();

    Trade updateTrade(String userName, Trade trade) throws TradeNotFoundException;

    Boolean deleteTrade(String userName) throws TradeNotFoundException;


}
