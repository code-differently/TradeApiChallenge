package com.codedifferently.tradeapichallenge.services;

import com.codedifferently.tradeapichallenge.exceptions.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.models.Trade;
import com.codedifferently.tradeapichallenge.models.User;
import com.codedifferently.tradeapichallenge.repo.TradeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PersonServiceTest {

    @MockBean
    private TradeRepo tradeRepo;

    @Autowired
    private TradeService tradeService;

    private User inputUser;
    private Trade inputTrade;
    private Trade mockResponseTrade1;
    private Trade mockResponseTrade2;

    @BeforeEach
    public void setUp(){

        inputUser = new User(1L, "DeShawn");

        inputTrade = new Trade("buy", inputUser, "AA", 11, 174.82);

        mockResponseTrade1 = new Trade("buy", inputUser, "BB", 12, 189.95);
        mockResponseTrade1.setId(1L);

        mockResponseTrade2 = new Trade("buy", inputUser, "CC", 10, 150.95);
        mockResponseTrade2.setId(2L);
    }

    @Test
    @DisplayName("Trade Service Get All")
    public void getAllTradesRequestTest() throws Exception {

        List<Trade> tradesList = new ArrayList<>();
        tradesList.add(new Trade("buy", inputUser, "DD", 9, 180.95));
        tradesList.add(new Trade("buy", inputUser, "AB", 12, 209.95));

        BDDMockito.doReturn(tradesList).when(tradeRepo).findAll();

        List<Trade> responseTrade = tradeService.getAllTrades();

        Assertions.assertIterableEquals(tradesList,responseTrade);
    }

    @Test
    @DisplayName("Trade Service Get All By userName")
    public void getAllTradesByUserNameRequestTest() throws Exception {

        List<Trade> tradesList = new ArrayList<>();
        tradesList.add(new Trade("buy", inputUser, "DD", 9, 180.95));
        tradesList.add(new Trade("buy", inputUser, "AB", 12, 209.95));

        BDDMockito.doReturn(tradesList).when(tradeRepo).findTradeByUserName("Rajon");

        List<Trade> responseTrade = tradeService.getTradeByUserName();

        Assertions.assertIterableEquals(tradesList,responseTrade);
    }

    @Test
    @DisplayName("Trade Service Create Trade")
    public void createTradeTestSuccess(){

        BDDMockito.doReturn(mockResponseTrade1).when(tradeRepo).save(ArgumentMatchers.any());

        Trade returnTrade = tradeService.create(mockResponseTrade1);

        Assertions.assertNotNull(returnTrade, "Trade should not be null");
        Assertions.assertEquals(returnTrade.getId(),1 );
    }

    @Test
    @DisplayName("Trade Service Update Trade")
    public void updateTradeTestSuccess() throws TradeNotFoundException {

        Trade expecteTradeUpdate = new Trade("buy", inputUser, "CC", 10, 150.95);

        BDDMockito.doReturn(mockResponseTrade1).when(tradeRepo).findById(1L);
        BDDMockito.doReturn(expecteTradeUpdate).when(tradeRepo).save(ArgumentMatchers.any());

        Trade actualTrade = tradeService.updateTrade(1L, expecteTradeUpdate);
        Assertions.assertEquals(expecteTradeUpdate.toString(), actualTrade.toString());
    }

    @Test
    @DisplayName("Trade Service Delete Trade")
    public void deletePersonTestSuccess() throws TradeNotFoundException {
        BDDMockito.doReturn(Optional.of(mockResponseTrade1)).when(tradeRepo).findById(1L);

        Boolean actualResponse = tradeService.deleteTrade(1L);

        Assertions.assertTrue(actualResponse);
    }

}
