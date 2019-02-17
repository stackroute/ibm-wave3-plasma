package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.User;

import com.stackroute.plasma.exceptions.UpdateException;
import com.stackroute.plasma.exceptions.UserAlreadyExistException;
import com.stackroute.plasma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistException {
        if (userRepository.existsById(user.getId())) {
            throw new UserAlreadyExistException("user already exists");
        }
        User savedUser = userRepository.save(user);
        if (savedUser == null) {
            throw new UserAlreadyExistException("User already exists");
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) throws UpdateException {
        if (userRepository.existsById(user.getId())) {
            throw new UpdateException("user already exists");
        }
        User savedUser = userRepository.save(user);
        if (savedUser == null) {
            throw new UpdateException("User already exists");
        }
        return savedUser;


    }
    //just writing

    @Override
    public List<User> getUpdateUser() throws UpdateException {

        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(String id) {
        boolean status = false;
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            status = true;

        }
        return status;
    }
}

