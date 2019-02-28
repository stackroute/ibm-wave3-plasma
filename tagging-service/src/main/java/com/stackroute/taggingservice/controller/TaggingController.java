package com.stackroute.taggingservice.controller;

import com.stackroute.taggingservice.domain.TagInput;
//import com.stackroute.taggingservice.service.RabbitMQListener;
import com.stackroute.taggingservice.service.TagService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1")
public class TaggingController {

    @Autowired
    TagService tagService;

    TagInput tagInputt;
    //@Autowired
    //RabbitMQListener rabbitMQListener;
    //List<>
    List<String> temp;

    @RabbitListener(queues = "${javainuse4.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(TagInput tagInput) throws IOException {
        this.tagInputt = tagInputt;

        //this.searchOutputt = this.objectMapper.readValue(searchOutput,SearchOutput);
//        for (String x:searchOutput.getUrls()
//        ) {
//            System.out.println("-------------"+x);
//        }
//        System.out.println("Recieved Message From RabbitMQ: " + searchOutput.getConcept() +searchOutput.getUrls());
//        System.out.println("check url----------------"+ searchOutputt.getUrls()+"8888888888"+searchOutputt.getConcept());

    }

    public TaggingController() {
    }

//    @PostMapping("/tag")
//    public ResponseEntity<?> tagger(@RequestBody  String nlpOutput) {
//        return new ResponseEntity<>(tagService.tagger(tagInput.getTokenizedQuery().toString()), HttpStatus.CREATED);
//       // return new ResponseEntity<>(temp.stream().map(String::toString).collect(Collectors.toList()), HttpStatus.CREATED);
//    }


    @GetMapping("/tag")
    public  ResponseEntity<?> tagger() {
        return new ResponseEntity<>(tagService.tagger(tagInputt.getTokenizedQuery().toString()),HttpStatus.OK);
    }
}
