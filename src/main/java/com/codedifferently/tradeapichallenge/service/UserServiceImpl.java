package com.codedifferently.tradeapichallenge.service;

import com.codedifferently.tradeapichallenge.exception.UserCreationException;
import com.codedifferently.tradeapichallenge.exception.UserNotFoundException;
import com.codedifferently.tradeapichallenge.models.User;
import com.codedifferently.tradeapichallenge.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepo personRepo;

    @Autowired
    public UserServiceImpl(UserRepo personRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getById(Integer id) throws UserCreationException {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isEmpty()) {
            logger.error("User with id {} does not exist", id);
            throw new UserCreationException("User not found");
        }
        return userOptional.get();
    }

    UserRepo userRepo;
    @Override
    public List getAll() {
        return userRepo.findAll();
    }

    @Override
    public User getAllTradesbyUserNames(String name) {
        return UserRepo.findUserByName(String name);
    }

    @Override
    public User updatePerson(Integer id, User person) throws UserNotFoundException {
        UserRepo userRepo = null;
        Optional<User> personOptional =  userRepo.findUserByName();
        if (personOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        User savedUser = userOptional.get();
        String newFirstName =user.getFirstName();
        savedUser.setFirstName(newFirstName);

        return personRepo.save(savedUser);
    }

    @Override
    public Boolean deleteTrade(Integer id) throws UserNotFoundException {
        Optional<User> personOptional = userRepo.findById(id);
        if (personOptional.isEmpty()) {
            throw new UserNotFoundException();
        }
        User userToDelete = userOptional.get();
        userRepo.delete(userToDelete);
        return true;
    }

    @Override
    public User createTrade(User user) throws UserCreationException {
        Long id = user.getId();
        Optional<User> userOptional = UserRepo.findById(id);
        if (userOptional.isPresent()) {
            logger.error("User could not be created because id{} already exists", id);
            throw new UserCreationException("User Exists");
        }
        user = UserRepo.save(user);
        logger.info("Created User with id{} and name{}", user.getId(), user.getName());
        return user;
    }

    @Override
    public List<User> getTrade(String type, User user, String symbol, Integer shares, Double price) {
        return null;
    }

    @Override
    public Boolean updateTrade(Integer id, User user) throws UserNotFoundException {
            Optional<User> userOptional = userRepo.findById(id);
            if (userOptional.isEmpty()) {
                throw new UserNotFoundException();
            }
            User savedUser = userOptional.get();
            String newFirstName =user.getFirstName();
            savedUser.setFirstName(newFirstName);

            return userRepo.save(savedUser);
        }
        
    @Override
    public User getAllTradesbyUserNames(String name) throws UserCreationException {
        return null;
    }
}
