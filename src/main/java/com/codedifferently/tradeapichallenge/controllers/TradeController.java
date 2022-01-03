package com.codedifferently.tradeapichallenge.controllers;

import com.codedifferently.tradeapichallenge.models.Trade;
import com.codedifferently.tradeapichallenge.exceptions.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.services.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class  TradeController {

    private final Logger logger = LoggerFactory.getLogger(TradeController.class);
    private TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService){
        this.tradeService = tradeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Trade>> getAllTrades() {
        List<Trade> trades = tradeService.getAllTrades();
        return new ResponseEntity<List<Trade>>(trades, HttpStatus.OK);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getTradeByUserName(@PathVariable String userName) {
        try {
            Trade tradeById = tradeService.getTradeByUserName(userName);
            return new ResponseEntity<Trade>(tradeById, HttpStatus.OK);
        }
        catch (TradeNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Trade> createTrade(@RequestBody Trade trade) {

        Trade createdTrade = tradeService.create(trade);
        return new ResponseEntity<Trade>(createdTrade, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTrade(@PathVariable Integer id, @RequestBody Trade trade) {
        try {
            Trade createdTrade = tradeService.updateTrade(id, trade);
            return new ResponseEntity(createdTrade, HttpStatus.OK);
        }
        catch (TradeNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrade(@PathVariable Integer id) {
        try{
            tradeService.deleteTrade(id);
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
