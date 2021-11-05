package com.codedifferently.tradeapichallenge.repos;

import com.codedifferently.tradeapichallenge.models.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TradeRepo extends JpaRepository<Trade, Integer> {
    Optional<Trade> findTradeByUserName(String name);
}
