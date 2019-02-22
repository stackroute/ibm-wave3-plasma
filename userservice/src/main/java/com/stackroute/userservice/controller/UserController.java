package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;


import com.stackroute.userservice.exceptions.UserAlreadyExistException;
import com.stackroute.userservice.exceptions.UserNotFoundException;
import com.stackroute.userservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1")
@Api(description = "shows the user information")

public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ApiOperation(value = "Accepts user into the repository")
    @PostMapping("/user")

    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistException, UserNotFoundException {
        ResponseEntity responseEntity;

        userService.saveUser(user);
        responseEntity=new ResponseEntity<String>( "Created", HttpStatus.CREATED);

        return responseEntity;
    }

    @ApiOperation(value = "Accepts users into the repository")

    @GetMapping("/user")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @ApiOperation(value = "Updates user into the repository")
    @PutMapping("/user")
    public ResponseEntity<?> UpdateUser(@RequestBody User user) throws UserNotFoundException, UserAlreadyExistException {
        ResponseEntity responseEntity;

        userService.saveUser(user);
        responseEntity=new ResponseEntity<String>( "updated", HttpStatus.CREATED);

        return responseEntity;

    }
    @ApiOperation(value = "Removes the user into the repository")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> getDeleteUser( @PathVariable("id") String id){
        ResponseEntity responseEntity;

        userService.deleteUser(id);
        responseEntity = new ResponseEntity<String>("delete", HttpStatus.CREATED);

        return responseEntity;

    }
}

