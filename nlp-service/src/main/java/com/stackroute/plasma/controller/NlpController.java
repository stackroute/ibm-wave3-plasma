package com.stackroute.plasma.controller;


import com.stackroute.plasma.model.NlpModel;
import com.stackroute.plasma.model.UserQuery;
import com.stackroute.plasma.service.NlpService;
import com.stackroute.plasma.service.RabbitMQSender;
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

    @Autowired
    NlpService nlpService;
    @Autowired
    RabbitMQSender rabbitMQSender;

    NlpModel nlpModel = new NlpModel();
    List<String> temp;
    UserQuery userQuery ;
    int i=0;
@PostMapping("/query")
public ResponseEntity<?> extractedQuery(@RequestBody final String query) {
    temp = new ArrayList<>();
    userQuery = new UserQuery();
    userQuery.setUser_id(i++);
    userQuery.setUser_query(query);
    System.out.println(userQuery.getUser_query());

    nlpService.save(userQuery);
    temp = nlpService.queryConverter(query);
    nlpModel.setTokenized_lematized(temp);
    System.out.println("controller output" + temp);
    rabbitMQSender.sender(nlpModel);
    return new ResponseEntity<>(temp.stream().map(String::toString).collect(Collectors.toList()), HttpStatus.CREATED);


  }
}

