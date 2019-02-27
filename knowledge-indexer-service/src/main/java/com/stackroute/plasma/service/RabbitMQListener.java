package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Evaluator;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RabbitMQListener {

    Evaluator evaluator = new Evaluator();

    @RabbitListener(queues = "${javainuse1.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void consume(Evaluator evaluator){
        System.out.println("Recieved Message From RabbitMQ: " + evaluator.toString());
        this.evaluator.setTimestamp(evaluator.getTimestamp());
        this.evaluator.setDomain(evaluator.getDomain());
        this.evaluator.setConcept(evaluator.getConcept());
        this.evaluator.setTitle(evaluator.getTitle());
        this.evaluator.setDescription(evaluator.getDescription());
        this.evaluator.setKeywords(evaluator.getKeywords());
        this.evaluator.setUrl(evaluator.getUrl());
        this.evaluator.setLevel(evaluator.getLevel());
        this.evaluator.setConfidenceScore(evaluator.getConfidenceScore());
        //return this.evaluator;
    }

    public Evaluator getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }


}
