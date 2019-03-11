package com.stackroute.plasma.services;

import com.stackroute.plasma.model.UserAuth;
<<<<<<< HEAD

import java.util.List;

public interface UserService {



=======

public interface UserService {

>>>>>>> 370c25dee7b5df118116b0bff1441cc27c018353
    public UserAuth saveUsers(UserAuth userAuth);
    public UserAuth getUser(String userId);       // gives list of users
    public UserAuth findByUserIdAndPassword(String userId, String password); //finds the userAuth by UserId and Password
}

