package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.User;
import com.stackroute.plasma.exceptions.UpdateException;
import com.stackroute.plasma.exceptions.UserAlreadyExistException;
import java.util.List;

public interface UserService {

    public User saveUser(User user) throws  UserAlreadyExistException;
    public List<User> getAllUsers();

    public User updateUser(User user) throws UpdateException;
    public List<User> getUpdateUser() throws UpdateException;

    public boolean deleteUser(String id);

}
