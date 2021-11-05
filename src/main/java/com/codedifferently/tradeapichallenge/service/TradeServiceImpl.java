package com.codedifferently.tradeapichallenge.service;

import com.codedifferently.tradeapichallenge.exception.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.model.Trade;
import com.codedifferently.tradeapichallenge.repos.TradeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeServiceImpl implements TradeService {

    private static Logger logger = LoggerFactory.getLogger(TradeServiceImpl.class);

    @Autowired
    private TradeRepo tradeRepo;


    @Override
    public List<Trade> getAllTrades() {

        return (List) tradeRepo.findAll();
    }

    @Override
    public Trade getTradeByUserName(String name) throws TradeNotFoundException {
        Optional<Trade> tradeOptional = tradeRepo.findByName(name);
        if (tradeOptional.isEmpty()) {
            logger.error("Trade with UserName {} does not exist", name);
            throw new TradeNotFoundException("Trade not found");
        }
        return tradeOptional.get();
    }

    @Override
    public Trade create(Trade trade) {
        Trade savedTrade = tradeRepo.save(trade);
        return savedTrade;
    }

    @Override
    public Trade updateTrade(String name, Trade trade) throws TradeNotFoundException {
        Optional<Trade> tradeOptional = tradeRepo.findByName(name);
        if(tradeOptional.isEmpty()){
            throw new TradeNotFoundException("Trade does not exists, can not update");
        }
        Trade savedTrade = tradeOptional.get();
       // savedTrade.setUser(trade.getUser());
        savedTrade.setType(trade.getType());
        savedTrade.setPrice(trade.getPrice());
        savedTrade.setSymbol(trade.getSymbol());
        savedTrade.setShares(trade.getShares());

        return tradeRepo.save(savedTrade);
    }

    @Override
    public Boolean deleteTrade(String name) throws TradeNotFoundException {
        Optional<Trade> tradeOptional = tradeRepo.findByName(name);
        if(tradeOptional.isEmpty()){
            throw new TradeNotFoundException("Trade does not exist, can not delete");
        }
        Trade tradeToDelete = tradeOptional.get();
        tradeRepo.delete(tradeToDelete);
        return true;

    }


}
