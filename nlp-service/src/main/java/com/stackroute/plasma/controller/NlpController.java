package com.stackroute.plasma.controller;


import com.stackroute.plasma.model.InputQuery;
import com.stackroute.plasma.model.NlpModel;
import com.stackroute.plasma.model.UserQuery;
import com.stackroute.plasma.service.NlpService;
import com.stackroute.plasma.service.RabbitMQSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class NlpController {
    //Logger logger = LoggerFactory.getLogger(NlpController.class.getName());

    @Autowired
    NlpService nlpService;
    @Autowired
    RabbitMQSender rabbitMQSender;

    NlpModel nlpModel = new NlpModel();
    List<String> temp;
    UserQuery userQuery ;
    int i=0;
   /* @PostMapping("/query")
    public ResponseEntity<?> extractedQuery(@RequestBody InputQuery inputQuery) {
        temp = new ArrayList<>();
        userQuery = new UserQuery();
        userQuery.setEmailId(inputQuery.getEmailId());
        userQuery.setUserQuery(inputQuery.getUserQuery());
        userQuery.setJwt(inputQuery.getJwt());
        userQuery.setRole(inputQuery.getRole());
        System.out.println(userQuery.getUserQuery());

        nlpService.save(userQuery);
        temp = nlpService.queryConverter(inputQuery.getUserQuery());
        nlpModel.setTokenized_lematized(temp);
        nlpModel.setUserId(inputQuery.getEmailId());
        nlpModel.setJwt(inputQuery.getJwt());
        nlpModel.setRole(inputQuery.getRole());
        System.out.println("controller output" + nlpModel);
        rabbitMQSender.sender(nlpModel);
        return new ResponseEntity<>(temp.stream().map(String::toString).collect(Collectors.toList()), HttpStatus.CREATED);

  }*/

    @PostMapping("/query")
    public ResponseEntity<?> extractedQuery(@RequestBody InputQuery inputQuery) {
        temp = new ArrayList<>();
        userQuery = new UserQuery();
        userQuery.setUserId(inputQuery.getUserId());
        userQuery.setUserQuery(inputQuery.getUserQuery());
        userQuery.setJwt(inputQuery.getJwt());
        userQuery.setRole(inputQuery.getRole());
        //not required to save sessionId
        userQuery.setSessionId(inputQuery.getSessionId());
        System.out.println("user query"+userQuery);
        nlpService.save(userQuery);


        temp = nlpService.queryConverter(inputQuery.getUserQuery());
        nlpModel.setTokenized_lematized(temp);
        nlpModel.setUserId(inputQuery.getUserId());
        nlpModel.setJwt(inputQuery.getJwt());
        nlpModel.setRole(inputQuery.getRole());
        nlpModel.setSessionId(inputQuery.getSessionId());
        System.out.println("controller output" + nlpModel);
        rabbitMQSender.sender(nlpModel);
        //return nlpModel;
        return new ResponseEntity<>(nlpModel,HttpStatus.CREATED);

    }


//    @GetMapping("/query")
//    public ResponseEntity<?> extractedQuery() {
//        InputQuery inputQuery = new InputQuery();
//        temp = new ArrayList<>();
//        userQuery = new UserQuery();
//        userQuery.setUser_id(inputQuery.getUser_id());
//        userQuery.setUser_query(inputQuery.getUser_query());
//        userQuery.setJwt(inputQuery.getJwt());
//        userQuery.setRole(inputQuery.getRole());
//        logger.info(userQuery.getUser_query());
//
//        nlpService.save(userQuery);
//        temp = nlpService.queryConverter(inputQuery.getUser_query());
//        nlpModel.setTokenized_lematized(temp);
//        logger.info("controller output" + temp);
//        //rabbitMQSender.sender(nlpModel);
//        return new ResponseEntity<>(temp.stream().map(String::toString).collect(Collectors.toList()), HttpStatus.CREATED);
//    }
}
