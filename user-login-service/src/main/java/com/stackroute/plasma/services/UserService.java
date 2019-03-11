package com.stackroute.plasma.services;

import com.stackroute.plasma.model.UserAuth;

import java.util.List;

public interface UserService {



    public UserAuth saveUsers(UserAuth userAuth);
    public UserAuth getUser(String userId);       // gives list of users
    public UserAuth findByUserIdAndPassword(String userId, String password); //finds the userAuth by UserId and Password
}

