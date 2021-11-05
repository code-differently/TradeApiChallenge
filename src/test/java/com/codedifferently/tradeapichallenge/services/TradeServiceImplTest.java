package com.codedifferently.tradeapichallenge.services;

import com.codedifferently.tradeapichallenge.exceptions.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.models.Trade;
import com.codedifferently.tradeapichallenge.models.User;
import com.codedifferently.tradeapichallenge.repositories.TradeRepo;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TradeServiceImplTest {

    @MockBean
    private TradeRepo mockTradeRepo;

    @Autowired
    private TradeServiceImpl tradeService;

    private Trade inputTrade;
    private Trade mockResponseTrade1;
    private Trade mockResponseTrade2;
    private User mockUser = new User("Adonis");

    @BeforeEach
    public void setUp(){
        User user = new User("Adonis");
        User user2 = new User("Neessam");
        inputTrade = new Trade("Buy", user, "AAA", 20, 69.69, "2019-12-28 13:18:48");

        mockResponseTrade1 = new Trade("buy", user, "ESPN", 27, 69.69, "2019-12-28 13:18:48");
        mockResponseTrade1.setId(1L);
        mockResponseTrade2 = new Trade("sell", user2, "ESPN", 27, 69.69, "2019-12-28 13:18:48");
        mockResponseTrade2.setId(2L);
    }

    @Test
    @DisplayName("Create Trade Success")
    public void createTrade(){
        BDDMockito.doReturn(mockResponseTrade1).when(mockTradeRepo).save(ArgumentMatchers.any());
        Trade returnedTrade = tradeService.create(inputTrade);
        Assertions.assertNotNull(returnedTrade, "Trade shouldnt be null");
        Assertions.assertEquals(returnedTrade.getId(), 1);
    }

    @Test
    @DisplayName("Get Trade by name success")
    public void getTradeByUserName() throws TradeNotFoundException{
        //given
        BDDMockito.doReturn(mockResponseTrade1).when(mockTradeRepo).findByUserName("Adonis");

        //when
        Trade foundTrade = tradeService.getTradeByUserName(mockUser);

        //then
        Assertions.assertEquals(mockResponseTrade1, foundTrade);
    }

    @Test
    @DisplayName("Get all trades success")
    public void getAllTrades(){
        List<Trade> trades = new ArrayList<>();
        trades.add(mockResponseTrade1);
        trades.add(mockResponseTrade2);

        BDDMockito.doReturn(trades).when(mockTradeRepo).findAll();

        List<Trade> responsePerson = tradeService.getAllTrades();
        Assertions.assertIterableEquals(trades, responsePerson);

    }

    @Test
    @DisplayName("update a trade success")
    public void updateTradeTestSuccess() throws TradeNotFoundException{
        User user = new User("Adonis");
        List<Trade> trades = new ArrayList<>();
        trades.add(mockResponseTrade1);
        trades.add(mockResponseTrade2);
        Trade expectedTradeUpdate = new Trade("Buy", user, "AAA", 20, 69.69, "2019-12-28 13:18:48");

        BDDMockito.doReturn(Optional.of(mockResponseTrade1)).when(mockTradeRepo).findById(1);
        BDDMockito.doReturn(expectedTradeUpdate).when(mockTradeRepo).save(ArgumentMatchers.any());

        Trade actualTrade = tradeService.update(1, expectedTradeUpdate);
        Assertions.assertEquals(expectedTradeUpdate, actualTrade);
    }

    @Test
    @DisplayName("Delete trade success")
    public void deletePersonTestSuccess() throws TradeNotFoundException{
        BDDMockito.doReturn(Optional.of(mockResponseTrade1)).when(mockTradeRepo).findById(1);
        Boolean actualResponse = tradeService.deleteTrade(1);
        Assertions.assertTrue(actualResponse);
    }



}