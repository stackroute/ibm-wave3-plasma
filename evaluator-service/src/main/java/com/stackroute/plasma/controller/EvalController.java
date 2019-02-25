package com.stackroute.plasma.controller;

import com.stackroute.plasma.domain.Evaluator;
//import com.stackroute.plasma.service.EvalService;
import com.stackroute.plasma.service.RabbitMQListner;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping(value="api/v1")
public class  EvalController {

   // EvalService evalService;
    //private Evaluator eval;
    @Autowired
    RabbitMQListner rmq;

    @Autowired
      public EvalController(RabbitMQListner rabbitMQListner) {
        this.rmq = rabbitMQListner;
    }

    @GetMapping("/score")
    public ResponseEntity<?> getScore() throws IOException, ParseException {
        return new ResponseEntity<>(rmq.getScore(), HttpStatus.OK);
    }
}
