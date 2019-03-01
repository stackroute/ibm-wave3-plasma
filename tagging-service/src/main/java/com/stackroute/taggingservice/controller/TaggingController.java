package com.stackroute.taggingservice.controller;

import com.stackroute.taggingservice.domain.TagInput;
import com.stackroute.taggingservice.service.RabbitMQListener;
import com.stackroute.taggingservice.service.TagService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class TaggingController {

    @Autowired
    TagService tagService;

   @Autowired
    RabbitMQListener rabbitMQListener;

//    @PostMapping("/tag")
//    public ResponseEntity<?> tagger(@RequestBody  String nlpOutput) {
//        return new ResponseEntity<>(tagService.tagger(tagInput.getTokenizedQuery().toString()), HttpStatus.CREATED);
//       // return new ResponseEntity<>(temp.stream().map(String::toString).collect(Collectors.toList()), HttpStatus.CREATED);
//    }


    @GetMapping("/tag")
    public ResponseEntity<?> tagger() {
        System.out.println(tagService.tagger(rabbitMQListener.getTagInput().getTokenizedQuery().toString()));
        return new ResponseEntity<>(tagService.tagger(rabbitMQListener.getTagInput().getTokenizedQuery().toString()),HttpStatus.OK);
    }
}
