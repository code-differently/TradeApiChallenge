package com.codedifferently.tradeapichallenge.repo;

import com.codedifferently.tradeapichallenge.models.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeRepo extends JpaRepository<Trade, Long > {

    List<Trade> findTradeByUserName(String userName);
}
