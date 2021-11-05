package com.codedifferently.tradeapichallenge.services;

import com.codedifferently.tradeapichallenge.exceptions.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.models.Trade;
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

    private TradeRepo tradeRepo;

    @Autowired
    public TradeServiceImpl(TradeRepo tradeRepo){
        this.tradeRepo = tradeRepo;
    }

    @Override
    public Trade create(Trade trade) {
        Trade savedTrade = tradeRepo.save(trade);
        return savedTrade;
    }

    @Override
    public Trade getTradeByUserName(String userName) throws TradeNotFoundException {
        Optional<Trade> tradeOptional = tradeRepo.findTradeByUserName(userName);
        if(tradeOptional.isEmpty()){
            logger.error("Trade with id {} does not exist", userName);
            throw new TradeNotFoundException("Trade not found");
        }
        return tradeOptional.get();
    }

    @Override
    public List<Trade> getAllTrades() {
        return tradeRepo.findAll();
    }

    @Override
    public Trade updateTrade(Integer id, Trade trade) throws TradeNotFoundException {
        Optional<Trade> tradeOptional = tradeRepo.findById(id);
        if(tradeOptional.isEmpty()){
            logger.error("Trade with id {} does not exist", id);
            throw new TradeNotFoundException("Trade not found");
        }
        Trade savedTrade = tradeOptional.get();
        savedTrade.setUser(trade.getUser());
        savedTrade.setPrice(trade.getPrice());
        savedTrade.setShares(trade.getShares());
        savedTrade.setType(trade.getType());
        savedTrade.setSymbol(trade.getSymbol());
//        savedTrade.setTimestamp(trade.getTimestamp());
        return tradeRepo.save(savedTrade);
    }

    @Override
    public Boolean deleteTrade(Integer id) throws TradeNotFoundException {
        Optional<Trade> tradeOptional = tradeRepo.findById(id);
        if(tradeOptional.isEmpty()){
            logger.error("Trade with id {} does not exist", id);
            throw new TradeNotFoundException("Trade not found");
        }
        Trade tradeToDelete =tradeOptional.get();
        tradeRepo.delete(tradeToDelete);
        return true;
    }
}
