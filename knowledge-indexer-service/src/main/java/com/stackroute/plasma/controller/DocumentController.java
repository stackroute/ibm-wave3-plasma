/*
package com.stackroute.plasma.controller;

import com.stackroute.plasma.model.Document;
import com.stackroute.plasma.model.Evaluator;
import com.stackroute.plasma.service.DocumentService;
import com.stackroute.plasma.service.RabbitMQListener;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1")
@Api(description="CUD operations for description node")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @Autowired
    RabbitMQListener rabbitMQListener;

    @GetMapping("/a")
    public void check(){
        Evaluator evaluator=rabbitMQListener.getEvaluator();
        System.out.println(evaluator);
    }


    @GetMapping("/descr")
    public Document create(){
        Evaluator evaluator=rabbitMQListener.getEvaluator();
        Document description = new Document();
        description.setTimestamp(evaluator.getTimestamp().toString());
        description.setDomain(evaluator.getDomain());
        description.setConcept(evaluator.getConcept());
        description.setUrl(evaluator.getUrl());
        description.setDescription(evaluator.getDescription());
        description.setKeywords(evaluator.getKeywords());
        description.setTitle(evaluator.getTitle());
        return documentService.create(description);
    }

    @PutMapping("/update")
    public Document update(@RequestBody Document description)
    {
        return documentService.update(description);
    }

    @DeleteMapping("/delete/id/{id}")
    public Document delete(@PathVariable("id") long id) { return documentService.delete(id); }

    @DeleteMapping("/delete/time/{timestamp}")
    public Document delete(@PathVariable("timestamp") String timestamp) { return documentService.delete(timestamp);}



}
*/
