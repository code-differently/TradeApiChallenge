package com.codedifferently.tradeapichallenge.services;

import com.codedifferently.tradeapichallenge.exceptions.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.models.Trade;
import com.codedifferently.tradeapichallenge.models.User;
import com.codedifferently.tradeapichallenge.repositories.TradeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeServiceImpl{

    private static Logger logger = LoggerFactory.getLogger(TradeServiceImpl.class);


    private TradeRepo tradeRepo;


    @Autowired
    public TradeServiceImpl(TradeRepo tradeRepo){this.tradeRepo = tradeRepo;}

    public Trade create(Trade trade){
        Trade savedPerson = tradeRepo.save(trade);
        return savedPerson;
    }

    public Trade update(Integer id, Trade trade) throws TradeNotFoundException {
        Optional<Trade> tradeOptional = tradeRepo.findById(id);
        if (tradeOptional.isEmpty()){
        throw new TradeNotFoundException("Trade request not found");
        }
        Trade savedTrade = tradeOptional.get();

        //might need to add methods
        return tradeRepo.save(savedTrade);
    }

    public Boolean deleteTrade(Integer id) throws TradeNotFoundException{
        Optional<Trade> tradeOptional = tradeRepo.findById(id);
        if (tradeOptional.isEmpty()){
            throw new TradeNotFoundException("Cannot delete, trade doesn't exist");
        }
        Trade tradeToDelete = tradeOptional.get();
        tradeRepo.delete(tradeToDelete);
        return true;
    }

    public List<Trade> getAllTrades(){
        return tradeRepo.findAll();
    }

    public Trade getTradeByUserName(User user)throws TradeNotFoundException{
        Trade tradeList = tradeRepo.findByUserName(user.getName());
        return tradeList;
    }
}
