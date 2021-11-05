package com.codedifferently.tradeapichallenge.controllers;

import com.codedifferently.tradeapichallenge.exceptions.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.models.Trade;
import com.codedifferently.tradeapichallenge.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class TradeController {

    private TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService){
        this.tradeService = tradeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Trade>> getAllTrades(){
        List<Trade> tradesList = tradeService.getAllTrades();

        ResponseEntity<List<Trade>> response = new ResponseEntity<>(tradesList, HttpStatus.OK);

        return response;
    }

    @GetMapping("/{userName}")
    public ResponseEntity<Trade> getTradeByUserName(@PathVariable String userName){

        try {
            Trade trades = tradeService.getTradeByUserName(userName);
            ResponseEntity<Trade> response = new ResponseEntity<>(trades, HttpStatus.OK);
            return response;
        } catch (TradeNotFoundException tradeNotFoundException) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

    }

    @PostMapping("/create")
    public ResponseEntity<Trade> createTrade(@RequestBody Trade trade){

        Trade savedTrade = tradeService.create(trade);

        ResponseEntity response = new ResponseEntity(savedTrade, HttpStatus.CREATED);

        return response;

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Trade> updateTrade(@PathVariable Long id, @RequestBody Trade trade){

        try{
            Trade updatedTrade = tradeService.updateTrade(id, trade);

            ResponseEntity response = new ResponseEntity(updatedTrade,HttpStatus.OK);

            return response;
        } catch (TradeNotFoundException tradeNotFoundException) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTrade (@PathVariable Long id){

        try{
            tradeService.deleteTrade(id);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        } catch (TradeNotFoundException tradeNotFoundException) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

}
