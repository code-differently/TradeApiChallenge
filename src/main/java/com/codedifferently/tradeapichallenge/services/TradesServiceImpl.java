package com.codedifferently.tradeapichallenge.services;

import com.codedifferently.tradeapichallenge.exceptions.TradeNotFoundExcetion;
import com.codedifferently.tradeapichallenge.exceptions.UserNotFoundException;
import com.codedifferently.tradeapichallenge.models.Trades;
import com.codedifferently.tradeapichallenge.models.User;
import com.codedifferently.tradeapichallenge.repos.TradesRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradesServiceImpl implements TradesService{
    private static Logger logger = LoggerFactory.getLogger(TradesServiceImpl.class);

    private TradesRepo tradesRepo;

    @Autowired
    public TradesServiceImpl(TradesRepo tradesRepo){
        this.tradesRepo = tradesRepo;
    }

    @Override
    public Trades createTrade(Trades trade) {
        Trades savedTrade = tradesRepo.save(trade);
        return savedTrade;
    }

    @Override
    public List<Trades> getAllTrades() {

        return (List) tradesRepo.findAll();
    }

    @Override
    public List<Trades> getAllTradesByUserName(User name) throws UserNotFoundException {
        return (List) tradesRepo.findAll();
    }

    @Override
    public Trades updateTrade(Integer id, Trades trade) throws TradeNotFoundExcetion {
        Optional<Trades> tradesOptional = tradesRepo.findTradesByID(id);
        if(tradesOptional.isEmpty()){
            throw new TradeNotFoundExcetion();
        }
        Trades savedTrade = tradesOptional.get();
        savedTrade.setUser(trade.getUser());
        savedTrade.setSymbol(trade.getSymbol());
        savedTrade.setShares(trade.getShares());
        savedTrade.setType(trade.getType());
       return tradesRepo.save(savedTrade);
    }

    @Override
    public Boolean deleteTrade(Integer id, Trades trades) throws TradeNotFoundExcetion {
       Optional<Trades> optionalTrades = tradesRepo.findTradesByID(id);
       if(optionalTrades.isEmpty()){
           throw new TradeNotFoundExcetion();
       }
       Trades tradeToDelete = optionalTrades.get();
       tradesRepo.delete(tradeToDelete);

        return true;

    }
}
