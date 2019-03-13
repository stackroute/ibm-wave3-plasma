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

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Override
    public User saveUser(User user) throws UserAlreadyExistException {


        if (userRepository.existsById(user.getEmailId())) {
            throw new UserAlreadyExistException("user already exists");
        }

        User savedUser = userRepository.save(user);
        System.out.println("saved user++++++++++++++++"+savedUser);
       rabbitMQSender.sender(savedUser);
        System.out.println("after rabbit mq===========");


//         User saveUser = userRepository.save(user);


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
        if (userRepository.existsById(user.getEmailId())){
            throw new UpdateException("user already exists");
        }
        User savedUser = userRepository.save(user);
        if (savedUser == null) {
            throw new UpdateException("User already exists");
        }
        return savedUser;


    }

    @Override
    public List<User> getUpdateUser() throws UpdateException {

        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(String emailId) {
        boolean status = false;
        if (userRepository.existsById(emailId)) {
            userRepository.deleteById(emailId);
            status = true;

        }
        return status;
    }
}