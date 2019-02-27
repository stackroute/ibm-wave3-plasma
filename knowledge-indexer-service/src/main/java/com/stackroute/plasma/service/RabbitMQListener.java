package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Evaluator;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RabbitMQListener {

Evaluator evaluator = new Evaluator();
    @RabbitListener(queues = "${javainuse1.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(Evaluator evaluator){
        System.out.println("Recieved Message From RabbitMQ: " + evaluator.toString());
        this.evaluator.setConcept(evaluator.getConcept());
    }

}
