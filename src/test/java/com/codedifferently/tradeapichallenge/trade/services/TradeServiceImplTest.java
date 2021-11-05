package com.codedifferently.tradeapichallenge.trade.services;

import com.codedifferently.tradeapichallenge.trade.models.Trade;
import com.codedifferently.tradeapichallenge.trade.repos.TradeRepo;
import com.codedifferently.tradeapichallenge.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class TradeServiceImplTest {

    @MockBean
    private TradeRepo mockTradeRepo;

    @Autowired
    private TradeService tradeService;

    private Trade inputTrade;
    private Trade mockTrade;
    private Trade mockTrade2;

    @BeforeEach
    public void setUp(){
        List<User> tron = new ArrayList<>();
        tron.add(new User(1L,"Donkey Kong"));
        tron.add(new User(2L,"Diddy Kong"));

        inputTrade = new Trade("sell",tron, "QQQ", 44, 102.50);


        mockTrade = new Trade("buy",tron, "SPY", 5, 459.72);
        mockTrade.setId(3L);

        mockTrade2 = new Trade("sell",tron, "AMZN", 200, 854.54);
        mockTrade2.setId(4L);
    }

    @Test
    @DisplayName("Trade Service: create---Success")
    void create() {
        BDDMockito.doReturn(mockTrade).when(mockTradeRepo).save(ArgumentMatchers.any());
        Trade foundTrade = tradeService.create(inputTrade);
        Assertions.assertNotNull(foundTrade, "Trade should not be null");
        Assertions.assertEquals(mockTrade.getId(),3L);

    }

    @Test
    @DisplayName("Trade Service: get all ---Success")
    void getAllTrade() {

    }

    @Test
    @DisplayName("Trade Service: get by user name---Success")
    void getTradeByUser() {

    }

    @Test
    @DisplayName("Trade Service: update trade by ID---Success")
    void updateTrade() {

    }

    @Test
    @DisplayName("Trade Service: delete trade by ID---Success")
    void deleteTrade() {

    }
}