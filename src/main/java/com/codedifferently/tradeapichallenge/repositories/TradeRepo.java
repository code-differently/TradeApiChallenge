package com.codedifferently.tradeapichallenge.repositories;

import com.codedifferently.tradeapichallenge.models.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepo extends JpaRepository<Trade, Integer> {
    Trade findByUserName(String userName);

}
