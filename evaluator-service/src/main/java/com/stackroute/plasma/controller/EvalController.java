package com.stackroute.plasma.controller;

import com.stackroute.plasma.service.RabbitMQListner;
import com.stackroute.plasma.service.RabbitMQSender;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

//import com.stackroute.plasma.service.EvalService;


@RestController
@RequestMapping(value="api/v1")
public class  EvalController {

   // EvalService evalService;
    //private Evaluator eval;
    @Autowired
    RabbitMQListner rmq;

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Autowired
      public EvalController(RabbitMQListner rabbitMQListner) {
        this.rmq = rabbitMQListner;
    }

    @GetMapping(value = "/score")
    public ResponseEntity<?> getScore() throws IOException, ParseException {
       rabbitMQSender.send(rmq.getScore());
        return new ResponseEntity<>(rmq.getScore(), HttpStatus.OK);
    }


}
