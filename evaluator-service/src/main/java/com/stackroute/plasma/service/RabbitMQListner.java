package com.stackroute.plasma.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.plasma.domain.Url;

@Service
public class RabbitMQListner{

    @Autowired
    EvaluatorService evaluatorService;

    @RabbitListener(queues = "${javainuse.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(Url urlx){
        System.out.println("Recieved Message From RabbitMQ: " + urlx.getUrl());
        evaluatorService.getConsumedUrl(urlx);
    }

}