package com.stackroute.plasma.controller;

import com.stackroute.plasma.model.Evaluator;
import com.stackroute.plasma.service.RabbitMQListener;
import com.stackroute.plasma.service.RelationshipService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@Api(description="Creates relationship between the description node and concept node of domain ontology")
public class RelationshipController {

    @Autowired
    RelationshipService relationshipService;

    @Autowired
    RabbitMQListener rabbitMQListener;

    @GetMapping("/get")
    public void create(){
        Evaluator evaluator=rabbitMQListener.getEvaluator();
        relationshipService.create(evaluator.getConcept(),evaluator.getConfidenceScore(),evaluator.getLevel());
    }
}
