package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;

import com.stackroute.userservice.exceptions.UserAlreadyExistException;
import com.stackroute.userservice.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {

    public User saveUser(User user) throws  UserAlreadyExistException, UserNotFoundException;
    public List<User> getAllUsers();
    public User updateUser(User user) throws UserNotFoundException;
    public boolean deleteUser(String id);

}
