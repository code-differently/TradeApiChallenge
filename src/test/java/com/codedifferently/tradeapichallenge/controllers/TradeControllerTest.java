package com.codedifferently.tradeapichallenge.controllers;

import com.codedifferently.tradeapichallenge.BaseControllerTest;
import com.codedifferently.tradeapichallenge.models.Trade;
import com.codedifferently.tradeapichallenge.models.User;
import com.codedifferently.tradeapichallenge.services.TradeService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class TradeControllerTest extends BaseControllerTest {

    @MockBean
    private TradeService mockTradeService;

    @Autowired
    private MockMvc mockMvc;

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
    @DisplayName("Trade Get All: /trades ")
    public void getAllTradesRequestTest() throws Exception {

        List<Trade> tradesList = new ArrayList<>();
        tradesList.add(new Trade("buy", inputUser, "DD", 9, 180.95));
        tradesList.add(new Trade("buy", inputUser, "AB", 12, 209.95));

        BDDMockito.doReturn(tradesList).when(mockTradeService).getAllTrades();

        mockMvc.perform(MockMvcRequestBuilders.get("/trades"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Trade Get By UserName: /trades/{userName} ")
    public void getTradeByUserNameRequestTest() throws Exception {

        BDDMockito.doReturn(mockResponseTrade2).when(mockTradeService).getTradeByUserName(inputUser.getName());

        mockMvc.perform(MockMvcRequestBuilders.get("/trades/{userName}"))
                .andExpect(status().isOk());
    }


    @Test
    @DisplayName("Trade POST: /trades/create ")
    public void createTradeRequestTest() throws Exception {

        BDDMockito.doReturn(mockResponseTrade1).when(mockTradeService).create(any());

        mockMvc.perform(MockMvcRequestBuilders.post("/trades/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(inputTrade)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.type", is("buy")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user", is(inputUser)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.symbol", is("AA")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.shares", is(11)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", is(174.82)));
    }

    @Test
    @DisplayName("Trade PUT: /trades/update/{id}")
    public void updateTradeRequestTrade() throws Exception{

        BDDMockito.doReturn(mockResponseTrade2).when(mockTradeService).updateTrade(any(), any());

        mockMvc.perform(put("/trades/update/{id}", 2)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(mockResponseTrade2)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.type", is("buy")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user", is(inputUser)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.symbol", is("CC")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.shares", is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", is(150.95)));
    }

    @Test
    @DisplayName("Trade DELETE: /trades/delete/{id}")
    public void deleteTradeRequestTest() throws Exception{

        BDDMockito.doReturn(true).when(mockTradeService).deleteTrade(any());

        mockMvc.perform(delete("/trades/delete/{id}", 1))
                .andExpect(status().isOk());
    }

}
