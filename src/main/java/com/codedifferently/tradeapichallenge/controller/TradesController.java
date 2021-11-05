package com.codedifferently.tradeapichallenge.controller;

import com.codedifferently.tradeapichallenge.exception.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.model.Trade;
import com.codedifferently.tradeapichallenge.service.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {

   // private final Logger logger = LoggerFactory.getLogger(TradesController.class);
    @Autowired
    private TradeService tradeService;


    //Get All trades
    @GetMapping("")
    public ResponseEntity<List<Trade>> getAllTrades(){
    List<Trade> trades = tradeService.getAllTrades();
    ResponseEntity <List<Trade>> response = new ResponseEntity<>(trades, HttpStatus.OK);
    return response;
}

   //Get All Trades by User Name
    @GetMapping("/{name}")
    public ResponseEntity<?> getTradeByUserName(@PathVariable String name) {
        try {
            Trade trade = tradeService.getTradeByUserName(name);
            ResponseEntity<?> response = new ResponseEntity<>(trade, HttpStatus.OK);
            return response;
        } catch (TradeNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

     //Create a trade
     @PostMapping("")
     public ResponseEntity<Trade> createTradeRequest(@RequestBody Trade trade){
         Trade savedTrade = tradeService.create(trade);
         ResponseEntity response = new ResponseEntity(savedTrade, HttpStatus.CREATED);
         return response;
     }

    //Update a trade
    @PutMapping("/{name}")
    public ResponseEntity<?> updateTrade(@PathVariable String name, @RequestBody Trade trade){
        try{
            Trade updatedTrade = tradeService.updateTrade(name, trade);
            ResponseEntity response = new ResponseEntity(updatedTrade,HttpStatus.OK);
            return response;
        } catch (TradeNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

   // Delete a trade
   @DeleteMapping("/{name}")
   public ResponseEntity<?> deleteTrade(@PathVariable String name){
       try{
           tradeService.deleteTrade(name);
           return ResponseEntity
                   .status(HttpStatus.NO_CONTENT)
                   .build();
       } catch (TradeNotFoundException e) {
           return ResponseEntity
                   .status(HttpStatus.NOT_FOUND)
                   .build();
       }
   }
}
