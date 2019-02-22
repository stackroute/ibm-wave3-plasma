package com.stackroute.searchservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stackroute.searchservice.domain.SearchInput;
import com.stackroute.searchservice.domain.SearchOutput;
import com.stackroute.searchservice.service.ApiService;
//import com.stackroute.searchservice.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SearchController {


    ResponseEntity responseEntity;
    List<String[]> tempList;
    @Autowired
    ApiService apiService;

//    @Autowired
//    RabbitMQSender rabbitMQSender;


    @PostMapping(value = "/search")
    public ResponseEntity<?> getPostApi(@RequestBody SearchInput searchInput) throws JsonProcessingException {
        SearchOutput[] searchOutput = new SearchOutput[searchInput.getConcepts().length];

        tempList = new ArrayList<>();
        int j = 0;
        int k = 0;
        System.out.println("hello");

        for(int i=0;i<searchInput.getConcepts().length;i++) {
            searchOutput[k] = new SearchOutput();
            String[] singleConceptResult;

            searchOutput[k].setDomain(searchInput.getDomain());
            searchOutput[k].setConcept(searchInput.getConcepts()[j]);
            searchOutput[k].setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
            singleConceptResult = apiService.getConceptsUrl(searchInput.getDomain() + searchInput.getConcepts()[j++],1,10);
            tempList.add(singleConceptResult);
            searchOutput[k].setUrls(singleConceptResult);


            //responseEntity = new ResponseEntity<List<String[]>>(tempList,HttpStatus.CREATED);
            //responseEntity = new ResponseEntity(searchOutput[k],HttpStatus.CREATED);
            k = k+1;
        }

        responseEntity = new ResponseEntity(searchOutput,HttpStatus.CREATED);
       // rabbitMQSender.send(searchOutput);

        return responseEntity;
    }

}
