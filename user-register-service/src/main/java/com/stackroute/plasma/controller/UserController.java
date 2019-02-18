package com.stackroute.plasma.controller;

import com.stackroute.plasma.domain.User;

import com.stackroute.plasma.exceptions.UpdateException;
import com.stackroute.plasma.exceptions.UserAlreadyExistException;
import com.stackroute.plasma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistException {
        ResponseEntity responseEntity;
        userService.saveUser(user);
        responseEntity=new ResponseEntity<String>( "Created", HttpStatus.CREATED);
        return responseEntity;
    }


    @GetMapping("/user")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }


    @PutMapping("/user")
    public ResponseEntity<?> UpdateUser(@RequestBody User user) throws UpdateException, UserAlreadyExistException {
        ResponseEntity responseEntity;
        userService.saveUser(user);
        responseEntity=new ResponseEntity<String>( "updated", HttpStatus.CREATED);
        return responseEntity;

    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> getDeleteUser( @PathVariable("id") String id){
        ResponseEntity responseEntity;
        userService.deleteUser(id);
        responseEntity = new ResponseEntity<String>("delete", HttpStatus.CREATED);
        return responseEntity;

    }
}

