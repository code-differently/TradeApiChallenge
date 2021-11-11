package com.codedifferently.tradeapichallenge.trade.controllers;

import com.codedifferently.tradeapichallenge.trade.exceptions.TradeNotFoundException;
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

    @GetMapping("/getTrade/{userName}")
    public ResponseEntity<?> getTradeByName(@RequestBody String userName) {
        try {
            Trade trade = tradeService.getTradeByUser(userName);
            ResponseEntity<?> response = new ResponseEntity<>(trade, HttpStatus.OK);
            return response;
        } catch (TradeNotFoundException t) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateProfile(@PathVariable String username, @RequestBody Trade trade) {
        try {
            Trade updatedTrade = tradeService.updateTrade(username, trade);
            ResponseEntity response = new ResponseEntity(updatedTrade, HttpStatus.OK);
            return response;
        } catch (TradeNotFoundException t) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable String userName) {
        try {
            tradeService.deleteTrade(userName);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
        catch (TradeNotFoundException t){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

    }

}
