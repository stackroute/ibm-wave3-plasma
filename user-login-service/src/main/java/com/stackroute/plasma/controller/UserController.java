package com.stackroute.plasma.controller;


import com.stackroute.plasma.model.UserAuth;
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

@CrossOrigin(value = "*")
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

    @PostMapping("userAuth")
    public ResponseEntity<?> login(@RequestBody UserAuth loginDetails) {
        try {

            String userId = loginDetails.getUserId();
            String password = loginDetails.getPassword();
            System.out.println("details"+userId+"\n"+password);

            if (userId == null || password == null) {
                System.out.println("in  method1");
                throw new UserNameOrPasswordEmptyException("Userid and Password cannot be empty");
            }

            UserAuth userAuth = userService.findByUserIdAndPassword(userId, password);
            System.out.println(userAuth);
           if (userAuth == null) {
               System.out.println("in  method2");
               throw new UserNotFoundException("UserAuth with given Id does not exists");
           }

            String fetchedPassword = userAuth.getPassword();
            if (!password.equals(fetchedPassword)) {
                System.out.println("in  method3");
                throw new UserIdAndPasswordMismatchException("Invalid login credential, Please check username and password ");
            }

            // generating token
            SecurityTokenGenerator securityTokenGenerator = (UserAuth userDetails) -> {

                String jwtToken = "";
                jwtToken = Jwts.builder().setId(userAuth.getUserId()).setSubject(userAuth.getRole()).setIssuedAt(new Date())
                        .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

                Map<String, String> map1 = new HashMap<>();
                map1.put("token", jwtToken);
                map1.put("message", "UserAuth successfully logged in");
                System.out.println("token value"+jwtToken);
                System.out.println("in  method4");
                return map1;
            };

            Map<String, String> map = securityTokenGenerator.generateToken(userAuth);

            return new ResponseEntity<>(map, HttpStatus.OK);

        } catch (UserNameOrPasswordEmptyException | UserNotFoundException | UserIdAndPasswordMismatchException exception) {
            System.out.println("in  catch");
            return new ResponseEntity<>("{ \"message\": \"" + exception.getMessage() + "\"}", HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping("user/{id}")
    public ResponseEntity<?> getAllUsers(@PathVariable("id") String userId)
    {
        return new ResponseEntity<UserAuth>(userService.getUser(userId), HttpStatus.OK);
    }

    @ApiOperation(value="Accept userAuth into repository")
    @PostMapping("users")
    public ResponseEntity<?> saveUser(@RequestBody UserAuth userAuth) throws UserNotFoundException
    {
        userService.saveUsers(userAuth);
        responseEntity = new ResponseEntity<UserAuth>(userAuth, HttpStatus.OK);

        return responseEntity;
    }
}
