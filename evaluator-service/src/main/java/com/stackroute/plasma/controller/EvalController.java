package com.stackroute.plasma.controller;

import com.stackroute.plasma.domain.Evaluator;
import com.stackroute.plasma.service.EvalService;
import com.stackroute.plasma.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping(value="api/v1")
public class  EvalController {

    EvalService evalService;
    private Evaluator eval;


    @Autowired
    public EvalController(EvalService evalService) {
        this.evalService = evalService;
    }

    @Autowired
    RabbitMQSender rabbitMQSender;


    @GetMapping("/score")
    public ResponseEntity<?> getScore() throws IOException {

        rabbitMQSender.send(evalService.getScore());
        return new ResponseEntity<>(evalService.getScore(), HttpStatus.OK);
    }
}
