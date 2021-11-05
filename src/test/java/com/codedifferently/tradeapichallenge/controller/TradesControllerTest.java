package com.codedifferently.tradeapichallenge.controller;

import com.codedifferently.tradeapichallenge.BaseControllerTest;
import com.codedifferently.tradeapichallenge.exception.TradeNotFoundException;
import com.codedifferently.tradeapichallenge.model.Trade;
import com.codedifferently.tradeapichallenge.model.User;
import com.codedifferently.tradeapichallenge.service.TradeService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class TradesControllerTest extends BaseControllerTest {


    @MockBean
    private TradeService mockTradeService;

    @Autowired
    private MockMvc mockMvc;

    private Trade inputTrade;
    private Trade mockResponseTrade1;
    private Trade mockResponseTrade2;

    @BeforeEach
    void setUp() {
        List<User> users = new ArrayList<>();
        users.add(new User("Mike"));
        users.add(new User("John"));
        inputTrade = new Trade("Buy","AA",6,55.23,users,"2018-5-28 1:18:48");


        mockResponseTrade1 = new Trade("Buy","CC",7,50.23,users,"2018-12-28 13:18:48");
        mockResponseTrade1.setId(1L);

        mockResponseTrade2 = new Trade("Buy","BB",6,43.23,users,"2018-1-28 15:18:48");
        mockResponseTrade2.setId(2L);
    }
    @Test
    @DisplayName("Trade Post: /trades - success")
    public void createTradeRequestSuccess() throws Exception {
        BDDMockito.doReturn(mockResponseTrade1).when(mockTradeService).create(any());

        mockMvc.perform(MockMvcRequestBuilders.post("/trades")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(inputTrade)))

                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("Test Trade 01")));
    }

    @Test
    @DisplayName("GET /trades/name - Found")
    public void getTradeByNameTestSuccess() throws Exception{
        BDDMockito.doReturn(mockResponseTrade1).when(mockTradeService).getTradeByUserName("Mike");

        mockMvc.perform(get("/trades/{name}", "Mike"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Test Trade 01")));
    }

    @Test
    @DisplayName("GET /trades/name - Not Found")
    public void getTradeByIdTestFail() throws Exception {
        BDDMockito.doThrow(new TradeNotFoundException("Not Found")).when(mockTradeService).getTradeByUserName("Mike");
        mockMvc.perform(get("/trades/{name}", "Mike"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("PUT /trades/name - Success")
    public void putTradeTestSuccess() throws Exception{
        List<User> users = new ArrayList<>();
        users.add(new User("Mike"));
        users.add(new User("John"));
        Trade expectedTradeUpdate = new Trade("sell","BB",7,43.67,users,"2018-7-28 15:18:48");
        expectedTradeUpdate.setId(1L);
        BDDMockito.doReturn(expectedTradeUpdate).when(mockTradeService).updateTrade(any(), any());
        mockMvc.perform(put("/trades/{name}", "Mike")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(inputTrade)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("After Update Trade")));
    }

}