package com.codedifferently.tradeapichallenge.services;

import com.codedifferently.tradeapichallenge.trade.Trade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TradeService {
    Trade create(Trade trade);
    Trade getTradetById(Integer id) throws WidgetNotFoundException;
    List<Trade> getAllTrade();
    Trade updateTrade(Integer id, Trade trade) throws WidgetNotFoundException;
    Boolean deleteTradet(Integer id) throws WidgetNotFoundException;


}
