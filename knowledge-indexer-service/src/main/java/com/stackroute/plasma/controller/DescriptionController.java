package com.stackroute.plasma.controller;

import com.stackroute.plasma.model.Description;
import com.stackroute.plasma.model.Evaluator;
import com.stackroute.plasma.service.DescriptionService;
import com.stackroute.plasma.service.RabbitMQListener;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1")
@Api(description="CUD operations for description node")
public class DescriptionController {

    @Autowired
    DescriptionService descriptionService;

    @Autowired
    RabbitMQListener rabbitMQListener;



    @GetMapping("/descr")
    public Description create(){
        Evaluator evaluator=rabbitMQListener.getEvaluator();
        Description description = new Description();
        description.setTimestamp(evaluator.getTimestamp().toString());
        description.setDomain(evaluator.getDomain());
        description.setConcept(evaluator.getConcept());
        description.setUrl(evaluator.getUrl());
        description.setDescription(evaluator.getDescription());
        description.setKeywords(evaluator.getKeywords());
        description.setTitle(evaluator.getTitle());
        return descriptionService.create(description);
    }

}
