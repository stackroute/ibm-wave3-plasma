package com.stackroute.plasma.controller;

import com.stackroute.plasma.model.Description;
import com.stackroute.plasma.model.Evaluator;
import com.stackroute.plasma.service.DescriptionService;
import com.stackroute.plasma.service.RabbitMQListener;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;


@RestController
@RequestMapping("api/v1")
@Api(description="CUD operations for description node")
public class DescriptionController {

    @Autowired
    DescriptionService descriptionService;

    @Autowired
    RabbitMQListener rabbitMQListener;

    /*@GetMapping("/a")
    public void check(){
        Evaluator evaluator=rabbitMQListener.getEvaluator();
        System.out.println(evaluator);
    }*/

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

    /*
    @PutMapping("/update")
    public Description update(@RequestBody Description description)
    {
        return descriptionService.update(description);
    }

    @DeleteMapping("/delete/id/{id}")
    public Description delete(@PathVariable("id") long id) { return descriptionService.delete(id); }

    @DeleteMapping("/delete/time/{timestamp}")
    public Description delete(@PathVariable("timestamp") Timestamp timestamp) { return descriptionService.delete(timestamp);}
    */

}
