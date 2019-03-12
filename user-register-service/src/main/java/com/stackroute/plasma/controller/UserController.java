package com.stackroute.plasma.controller;

import com.stackroute.plasma.domain.User;

import com.stackroute.plasma.exceptions.UpdateException;
import com.stackroute.plasma.exceptions.UserAlreadyExistException;
import com.stackroute.plasma.service.RabbitMQSender;
import com.stackroute.plasma.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (value = "*")
@RestController
@RequestMapping(value = "/api/v1")
@Api()

public class UserController {
    UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @Autowired
//    RabbitMQSender rabbitMQSender;

    @ApiOperation(value ="Accepts user into the repository")
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistException {

        ResponseEntity responseEntity;
        User user1=userService.saveUser(user);
        System.out.println("user value is"+ user1);

//        rabbitMQSender.sender(user1);

        responseEntity=new ResponseEntity<String>( "Created", HttpStatus.CREATED);
        return responseEntity;

    }

    @ApiOperation(value ="Accepts user into the repository")
    @GetMapping("/user")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @ApiOperation(value ="Accepts user into the repository")
    @PutMapping("/user")
    public ResponseEntity<?> UpdateUser(@RequestBody User user) throws UpdateException, UserAlreadyExistException {
        ResponseEntity responseEntity;
        userService.saveUser(user);
        responseEntity=new ResponseEntity<String>( "updated", HttpStatus.CREATED);
        return responseEntity;

    }

    @ApiOperation(value ="Accepts user into the repository")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> getDeleteUser( @PathVariable("emailId") String emailId){
        ResponseEntity responseEntity;
        userService.deleteUser(emailId);
        responseEntity = new ResponseEntity<String>("delete", HttpStatus.CREATED);
        return responseEntity;

    }
}