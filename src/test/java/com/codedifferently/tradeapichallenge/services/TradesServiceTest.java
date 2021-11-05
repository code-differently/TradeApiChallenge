package com.codedifferently.tradeapichallenge.services;

import com.codedifferently.tradeapichallenge.models.Trades;
import com.codedifferently.tradeapichallenge.models.User;
import com.codedifferently.tradeapichallenge.repos.TradesRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TradesServiceTest {
    private TradesRepo mockTradesRepo;

    @Autowired
    private TradesService tradesService;

    private Trades inputTrade;
    private Trades mockTrades1;
    private Trades mockTrades2;


    @BeforeEach
    public void setUp(){
        List<Trades> trade = new ArrayList<>();

    }

    @Test
    @DisplayName("Trade Service: create trade- success")
    public void createTradeTest(){
        BDDMockito.doReturn(mockTrades1).when(mockTradesRepo).save(ArgumentMatchers.any());
        Trades returnedTrades = tradesService.createTrade(inputTrade);
        Assertions.assertNotNull(returnedTrades, "Trade should not be null");
        Assertions.assertEquals(returnedTrades.getId(),1);
//***IllegalStateException when running this test****

    }
    @Test
    @DisplayName("Should display all trades")
    public void getAlltradesTest(){
        List<Trades> trades = new ArrayList<>();
        trades.add(mockTrades1);
        trades.add(mockTrades2);

        BDDMockito.doReturn(trades).when(mockTradesRepo).findAll();

        List<Trades> responseWidgets = tradesService.getAllTrades();
        Assertions.assertIterableEquals(trades,responseWidgets);
        };

    public void getAllTradesByUserNameTest(User name){
        List<Trades> trades = new ArrayList<>();
        trades.add(mockTrades1);
        trades.add(mockTrades1);

        BDDMockito.doReturn(trades).when(mockTradesRepo).findAll();

        List<Trades> responseWidgets = tradesService.getAllTrades();
        Assertions.assertIterableEquals(trades,responseWidgets);
    };
































}
