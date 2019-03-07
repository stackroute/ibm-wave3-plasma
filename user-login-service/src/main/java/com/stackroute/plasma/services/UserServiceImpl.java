package com.stackroute.plasma.services;

import com.stackroute.plasma.model.UserAuth;
import com.stackroute.plasma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    public UserAuth userAuth;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserAuth saveUsers(UserAuth userAuth) {
        return userRepository.save(userAuth);
    }

    @Override
    public UserAuth getUser(String userId) {
        return userRepository.findById(userId).get();
    }


    @Override
    public UserAuth findByUserIdAndPassword(String userId, String password) {

        return userRepository.findByUserIdAndPassword(userId,password);
    }

}



