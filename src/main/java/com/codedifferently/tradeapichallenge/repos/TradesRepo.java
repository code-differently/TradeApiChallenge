package com.codedifferently.tradeapichallenge.repos;

import com.codedifferently.tradeapichallenge.models.Trades;
import com.codedifferently.tradeapichallenge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface TradesRepo extends JpaRepository<Trades, Integer> {
    Optional<Trades> findTradesByID(Integer id);
    Optional<Trades> findTradesByUser(User name);
    Optional<Trades> findBySymbol(String symbol);


}
