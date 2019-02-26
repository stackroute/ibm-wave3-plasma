package com.stackroute.plasma.controller;


import com.stackroute.plasma.model.NlpModel;
import com.stackroute.plasma.model.UserQuery;
import com.stackroute.plasma.repository.NlpRepository;
import com.stackroute.plasma.service.NlpService;
import com.stackroute.plasma.viewmodel.QueryPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class NlpController {
   /* @Autowired
    NlpRepository nlpRepository;*/
    @Autowired
    NlpService nlpService;
    NlpModel nlpModel = new NlpModel();
    List<String> temp;
    UserQuery userQuery = new UserQuery();
@PostMapping("/query")
public ResponseEntity<?> extractedQuery(@RequestBody final String query) {
    temp = new ArrayList<>();
    userQuery.setUser_query(query);
    System.out.println(userQuery.getUser_query());
    //nlpRepository.save(userQuery);
    nlpService.save(userQuery);
    temp = nlpService.queryConverter(query);
    nlpModel.setTokenized_lematized(temp);
    return new ResponseEntity<>(temp.stream().map(String::toString).collect(Collectors.toList()), HttpStatus.CREATED);
}
}