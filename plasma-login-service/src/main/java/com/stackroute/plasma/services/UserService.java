package com.stackroute.plasma.services;

import com.stackroute.plasma.model.User;

import java.util.List;

public interface UserService {



    public User saveUsers(User user);       // throws UserNotFoundException;
    public List<User> getAllUsers();
    public User findByUserIdAndPassword(String userId, String password);
}

