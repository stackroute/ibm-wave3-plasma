package com.stackroute.plasma.controller;


import com.stackroute.plasma.model.User;
import com.stackroute.plasma.exception.UserIdAndPasswordMismatchException;
import com.stackroute.plasma.exception.UserNameOrPasswordEmptyException;
import com.stackroute.plasma.exception.UserNotFoundException;
import com.stackroute.plasma.security.SecurityTokenGenerator;
import com.stackroute.plasma.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/")
public class UserController {

    @Autowired
    private UserService userService;
    ResponseEntity responseEntity;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity login(@RequestBody User loginDetails) {
        try {

            String userId = loginDetails.getUserId();
            String password = loginDetails.getPassword();

            if (userId == null || password == null) {
                throw new UserNameOrPasswordEmptyException("Userid and Password cannot be empty");
            }

            User user  = userService.findByUserIdAndPassword(userId, password);

            if (user == null) {
                throw new UserNotFoundException("User with given Id does not exists");
            }

            String fetchedPassword = user.getPassword();
            if (!password.equals(fetchedPassword)) {
                throw new UserIdAndPasswordMismatchException("Invalid login credential, Please check username and password ");
            }

            // generating token
            SecurityTokenGenerator securityTokenGenerator = (User userDetails) -> {

                String jwtToken = "";
                jwtToken = Jwts.builder().setId(user.getUserId()).setIssuedAt(new Date())
                        .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

                Map<String, String> map1 = new HashMap<>();
                map1.put("token", jwtToken);
                map1.put("message", "User successfully logged in");
                System.out.println("token value"+jwtToken);
                return map1;
            };

            Map<String, String> map = securityTokenGenerator.generateToken(user);

            return new ResponseEntity<>(map, HttpStatus.OK);

        } catch (UserNameOrPasswordEmptyException | UserNotFoundException | UserIdAndPasswordMismatchException exception) {

            return new ResponseEntity<>("{ \"message\": \"" + exception.getMessage() + "\"}", HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping("user")
    public ResponseEntity<?> getAllUsers()
    {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }
    @ApiOperation(value="Accept user into repository")
    @PostMapping("users")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserNotFoundException
    {
        userService.saveUsers(user);
        responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);

        return responseEntity;
    }
}
