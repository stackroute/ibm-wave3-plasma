package com.stackroute.taggingservice.controller;

import com.stackroute.taggingservice.domain.TagInput;
import com.stackroute.taggingservice.domain.TagOutput;
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
   // @Autowired
   // TagInput tagInput = new TagInput();
//    @PostMapping("/tag")
//    public ResponseEntity<?> tagger(@RequestBody TagInput tagInput) {
//        //temp = tagService.tagger(nlpOutput);
//        System.out.println("check");
//        System.out.println(tagInput.getTokenizedQuery().toString());
//        return new ResponseEntity<>(tagService.tagger(tagInput.getTokenizedQuery().toString()), HttpStatus.CREATED);
//        //return new ResponseEntity<>(temp.stream().map(String::toString).collect(Collectors.toList()), HttpStatus.CREATED);
//
//
//    }

  //@GetMapping("/tag")
//
////    public  ResponseEntity<?> tagger() {
////        System.out.println(tagInputt.getTokenizedQuery().toString());
////        return new ResponseEntity<>(tagService.tagger(tagInputt.getTokenizedQuery().toString()),HttpStatus.OK);
//
//    public ResponseEntity<?> tagger() {
//        System.out.println("controller listener check:  "+rabbitMQListener.getTagInput());
//        System.out.println("controller sender check:   "+tagService.tagger(rabbitMQListener.getTagInput().getTokenized_lematized().toString()));
//        return new ResponseEntity<>(tagService.tagger(rabbitMQListener.getTagInput().getTokenized_lematized().toString()),HttpStatus.OK);
//        //tagService.tagger("how is java executed");
//       //return null;
//    }


//  @GetMapping("/tag")
//
//    public TagOutput tagger() {
//        System.out.println("controller listener check:  "+rabbitMQListener.getNlpModel());
//        //System.out.println("controller sender check:   "+tagService.tagger(rabbitMQListener.getTagInput().getTokenizedQuery().toString()));
//        return tagService.tagger(rabbitMQListener.getNlpModel().getTokenized_lematized().toString());
//
//    }
}
