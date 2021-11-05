package com.codedifferently.tradeapichallenge.controllers;

import com.codedifferently.tradeapichallenge.BaseControllerTest;
import com.codedifferently.tradeapichallenge.models.Trade;
import com.codedifferently.tradeapichallenge.models.User;
import com.codedifferently.tradeapichallenge.services.TradeServiceImpl;
import com.fasterxml.jackson.databind.ser.Serializers;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class TradeControllerTest extends BaseControllerTest {

    @MockBean
    private TradeServiceImpl mockTradeService;

    @Autowired
    private MockMvc mockMvc;

    private Trade inputTrade;
    private Trade mockResponseTrade1;
    private Trade mockResponseTrade2;
    private User mockUser = new User("Adonis");

    @BeforeEach
    public void setUp() {

        User user = new User("Adonis");
        User user2 = new User("Neessam");
        User user3 = new User("Bob");
        inputTrade = new Trade("buy", user, "AAA", 20, 69.69, "2019-12-28 13:18:48");

        mockResponseTrade1 = new Trade("buy", mockUser, "ESPN", 27, 69.69, "2019-12-28 13:18:48");
        mockResponseTrade1.setId(1L);
        mockResponseTrade2 = new Trade("sell", user, "ESPN", 27, 69.69, "2019-12-28 13:18:48");
        mockResponseTrade2.setId(2L);

    }

    @Test
    @DisplayName("create a trade successfully")
    void createTrade() throws Exception {
        BDDMockito.doReturn(mockResponseTrade1).when(mockTradeService).create(any());

        mockMvc.perform(MockMvcRequestBuilders.post("/trades")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(inputTrade)))

                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.type", Is.is("buy")));
    }

    @Test
    @DisplayName("get a trade by name successfully")
    public void getTradeByNameTestSuccess() throws Exception {
        BDDMockito.doReturn(mockResponseTrade1).when(mockTradeService).getTradeByUserName(mockUser);

        mockMvc.perform(MockMvcRequestBuilders.get("/trades/{name}", "Adonis"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.type", is(null)));
    }
}