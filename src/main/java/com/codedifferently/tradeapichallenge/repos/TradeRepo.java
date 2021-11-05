package com.codedifferently.tradeapichallenge.repos;

import com.codedifferently.tradeapichallenge.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TradeRepo extends JpaRepository<Trade,Long> {
    Optional<Trade> findByName(String name);


}
