package com.stackroute.taggingservice.controller;

import com.stackroute.taggingservice.service.RabbitMQListener;
import com.stackroute.taggingservice.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TaggingController {

    @Autowired
    TagService tagService;

    @Autowired
    RabbitMQListener rabbitMQListener;



  @GetMapping("/tag")

    public ResponseEntity<?> tagger() {
        System.out.println("controller listener check:  "+rabbitMQListener.getTagInput());
        System.out.println("controller sender check:   "+tagService.tagger(rabbitMQListener.getTagInput().getTokenized_lematized().toString()));
        return new ResponseEntity<>(tagService.tagger(rabbitMQListener.getTagInput().getTokenized_lematized().toString()),HttpStatus.OK);

    }
}
