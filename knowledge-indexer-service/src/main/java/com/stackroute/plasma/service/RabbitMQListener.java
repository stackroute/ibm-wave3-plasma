package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Document;
import com.stackroute.plasma.model.Evaluator;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    DocumentService documentService;

    @Autowired
    RelationshipService relationshipService;

    //Evaluator evaluator = new Evaluator();

    @RabbitListener(queues = "${javainuse1.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void consume(Evaluator evaluator){
        System.out.println("Recieved Message From RabbitMQ: " + evaluator.toString());

        /*this.evaluator.setTimestamp(evaluator.getTimestamp());
        this.evaluator.setDomain(evaluator.getDomain());
        this.evaluator.setConcept(evaluator.getConcept());
        this.evaluator.setTitle(evaluator.getTitle());
        this.evaluator.setDescription(evaluator.getDescription());
        this.evaluator.setKeywords(evaluator.getKeywords());
        this.evaluator.setUrl(evaluator.getUrl());
        this.evaluator.setLevel(evaluator.getLevel());
        this.evaluator.setConfidenceScore(evaluator.getConfidenceScore());
        this.evaluator.setConfidenceScore(evaluator.getConfidenceScore());
        this.evaluator.setLevel(evaluator.getLevel());*/


        /*creates description node*/
        Document description = new Document();
        description.setTimestamp(evaluator.getTimestamp().toString());
        description.setDomain(evaluator.getDomain());
        description.setConcept(evaluator.getConcept());
        description.setUrl(evaluator.getUrl());
        description.setDescription(evaluator.getDescription());
        description.setKeywords(evaluator.getKeywords());
        description.setTitle(evaluator.getTitle());
        description.setConfidenceScore(evaluator.getConfidenceScore());
        description.setLevel(evaluator.getLevel());
        documentService.create(description);

        /*creates the relationship*/
        relationshipService.create(description.getConcept(),description.getConfidenceScore(),description.getLevel(),description.getUrl());
    }


}
