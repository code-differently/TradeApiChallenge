package com.codedifferently.tradeapichallenge.repo;

import com.codedifferently.tradeapichallenge.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Integer> {
     static Optional<User> findById(Long id) {
     }

     Optional<User> findUserByName(String name);
}
