package com.stackroute.searchservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stackroute.searchservice.domain.SearchInput;
import com.stackroute.searchservice.domain.SearchOutput;
import com.stackroute.searchservice.domain.SearchStorage;
import com.stackroute.searchservice.service.ApiService;
import com.stackroute.searchservice.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/v1")
public class SearchController {


    ResponseEntity responseEntity;
    List<String[]> tempList;
    @Autowired
    ApiService apiService;

    @Autowired
    RabbitMQSender rabbitMQSender;

    @PostMapping(value = "/search")
    public ResponseEntity<?> getPostApi(@RequestBody SearchInput searchInput) throws JsonProcessingException {
        SearchOutput[] searchOutput = new SearchOutput[searchInput.getConcepts().length];
        tempList = new ArrayList<>();
        int j = 0;
        int k = 0;
        System.out.println("hello");

        for(int i=0;i<searchInput.getConcepts().length;i++) {
            SearchStorage searchStorage = new SearchStorage();
            searchOutput[k] = new SearchOutput();
            String[] singleConceptResult;
            searchOutput[k].setDomain(searchInput.getDomain());
            searchOutput[k].setConcept(searchInput.getConcepts()[j]);
            searchOutput[k].setTimestamp(Timestamp.valueOf(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())).toString()));

            searchStorage.setDomain(searchInput.getDomain());
            searchStorage.setConcept(searchInput.getConcepts()[j]);
            searchOutput[k].setTimestamp(Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.now())));
            singleConceptResult = apiService.getConceptsUrl(searchInput.getDomain() + searchInput.getConcepts()[j++],1,10);
            tempList.add(singleConceptResult);
            searchStorage.setUrls(singleConceptResult);
            apiService.save(searchStorage);
            searchOutput[k].setUrls(singleConceptResult);
            rabbitMQSender.sender(searchOutput[k]);
            k = k+1;

        }

        rabbitMQSender.inform();
        responseEntity = new ResponseEntity(searchOutput,HttpStatus.CREATED);
        return responseEntity;
    }
}
