package com.codedifferently.tradeapichallenge.trade.controllers;

import com.codedifferently.tradeapichallenge.trade.models.Trade;
import com.codedifferently.tradeapichallenge.trade.services.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class TradeController {
    private final Logger logger = LoggerFactory.getLogger(TradeController.class);
    private TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService){
        this.tradeService = tradeService;
    }

    @PostMapping("/createTrade")
    public ResponseEntity<Trade> createTradeRequest(@RequestBody Trade trade){
        Trade savedTrade = tradeService.create(trade);
        ResponseEntity response = new ResponseEntity(savedTrade, HttpStatus.CREATED);

        return response;
}
    @GetMapping("/getAllTrades")
    public ResponseEntity<List<Trade>> getAllTrades(){
        List<Trade> trades = tradeService.getAllTrade();
        ResponseEntity<List<Trade>> response = new ResponseEntity<>(trades, HttpStatus.OK);
        return response;
    }





//        ResponseEntity<List<Trade>> response = new ResponseEntity<>(trades, HttpStatus.OK);
//
//        return  response;
//    }















}
