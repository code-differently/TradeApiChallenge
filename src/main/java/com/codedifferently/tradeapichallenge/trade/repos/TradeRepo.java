package com.codedifferently.tradeapichallenge.trade.repos;

import com.codedifferently.tradeapichallenge.trade.models.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface TradeRepo extends JpaRepository<Trade, Long> {
    Optional<Trade> findTradeByUserName(String userName);
}
