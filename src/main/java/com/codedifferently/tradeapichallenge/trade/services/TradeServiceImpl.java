package com.codedifferently.tradeapichallenge.trade.services;

import com.codedifferently.tradeapichallenge.trade.exceptions.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.trade.models.Trade;
import com.codedifferently.tradeapichallenge.trade.repos.TradeRepo;
import org.hibernate.hql.internal.ast.ParseErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class TradeServiceImpl {
    private TradeRepo tradeRepo;

    private static Logger logger = LoggerFactory.getLogger(TradeServiceImpl.class);

    @Autowired
    public TradeServiceImpl(TradeRepo tradeRepo){
        this.tradeRepo = tradeRepo;
    }

    public Trade create(Trade trade){
        Trade tradeSaved = tradeRepo.save(trade);
        return tradeSaved;
    }

    public List<Trade> getAllTrade(){
        List<Trade> response = tradeRepo.findAll();
        return response;
    }


    public Trade getTradeByUser(String userName) throws TradeNotFoundException{
        Optional<Trade> tradeOptional = tradeRepo.findTradeByUserName(userName);
        if (tradeOptional.isEmpty()){
            logger.error("Trade with name{} does not exist", userName);
        }
        return tradeOptional.get();
    }


    public Trade updateTrade(String name, Trade trade) throws TradeNotFoundException{
        Optional<Trade> tradeOptional = tradeRepo.findTradeByUserName(name);
        if (tradeOptional.isEmpty()){
                throw new TradeNotFoundException("Trade does not exist, can not update");
            }
            Trade savedTrade = tradeOptional.get();
            savedTrade.setUser(trade.getUser());
                    return tradeRepo.save(savedTrade);
            }


   public Boolean deleteTrade(String userName) throws TradeNotFoundException{
        Optional<Trade> tradeOptional = tradeRepo.findTradeByUserName(userName);
        if (tradeOptional.isEmpty()){
            throw new TradeNotFoundException("Trade does not exist, can not delete");
        }
        Trade deleteTrade = tradeOptional.get();
        tradeRepo.delete(deleteTrade);

        return true;
    }

}
