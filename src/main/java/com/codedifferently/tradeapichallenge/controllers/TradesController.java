package com.codedifferently.tradeapichallenge.controllers;

import com.codedifferently.tradeapichallenge.models.Trades;
import com.codedifferently.tradeapichallenge.services.TradesService;
import com.codedifferently.tradeapichallenge.services.TradesServiceImpl;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trades")
public class TradesController {
    private Logger logger = LoggerFactory.getLogger(TradesController.class);
    private TradesService tradesService;
    
    @Autowired
    public TradesController(TradesService tradesService){
        this.tradesService = tradesService;
    }
    @PostMapping("")
    public ResponseEntity<Trades> createTradeRequest(@RequestBody Trades Trade){
        Object savedTrade = null;
        ResponseEntity response = new ResponseEntity(savedTrade, HttpStatus.OK);
        return response;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}

