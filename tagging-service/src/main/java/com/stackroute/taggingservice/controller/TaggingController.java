package com.stackroute.taggingservice.controller;

import com.stackroute.taggingservice.domain.TagInput;
import com.stackroute.taggingservice.service.RabbitMQListener;
import com.stackroute.taggingservice.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1")
public class TaggingController {

    @Autowired
    TagService tagService;

    @Autowired
    RabbitMQListener rabbitMQListener;
    //List<>
    List<String> temp;


    public TaggingController() {
    }

//    @PostMapping("/tag")
//    public ResponseEntity<?> tagger(@RequestBody  String nlpOutput) {
//        return new ResponseEntity<>(tagService.tagger(tagInput.getTokenizedQuery().toString()), HttpStatus.CREATED);
//       // return new ResponseEntity<>(temp.stream().map(String::toString).collect(Collectors.toList()), HttpStatus.CREATED);
//    }


    @GetMapping("/tag")
    public  ResponseEntity<?> tagger() {
        return new ResponseEntity<>(tagService.tagger(rabbitMQListener.getTagInputt().toString()),HttpStatus.OK);
    }
}
