package com.codedifferently.tradeapichallenge.controllers;

import com.codedifferently.tradeapichallenge.exceptions.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.models.Trade;
import com.codedifferently.tradeapichallenge.models.User;
import com.codedifferently.tradeapichallenge.services.TradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class TradeController {

    private TradeServiceImpl tradeService;

    @Autowired
    public TradeController(TradeServiceImpl tradeService){
        this.tradeService = tradeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Trade>> getAllTrades(){
    List<Trade> trades = tradeService.getAllTrades();
    ResponseEntity<List<Trade>> response = new ResponseEntity<>(trades, HttpStatus.OK);
    return response;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Trade> getTradesByUserNames(@PathVariable User user) throws TradeNotFoundException {
        try{
            Trade tradeByName = tradeService.getTradeByUserName(user);
            ResponseEntity response = new ResponseEntity(tradeByName, HttpStatus.OK);
            return response;
        } catch (TradeNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Trade> createTrade(@RequestBody Trade trade){
        Trade saved = tradeService.create(trade);
        ResponseEntity response = new ResponseEntity(saved, HttpStatus.CREATED);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>updateTrade(@PathVariable Integer id, @RequestBody Trade trade){
        try{
            Trade updatedTrade = tradeService.update(id, trade);
            ResponseEntity response = new ResponseEntity(updatedTrade, HttpStatus.OK);
            return response;
        } catch (TradeNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrade(@PathVariable Integer id){
        try{
            tradeService.deleteTrade(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (TradeNotFoundException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }







}
