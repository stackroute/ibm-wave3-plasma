package com.stackroute.plasma.service;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.plasma.domain.Url;

import java.util.logging.Logger;

@Service
public class RabbitMQListner{
    Logger logger = (Logger) LoggerFactory.getLogger(RabbitMQListner.class.getName());

    @Autowired
    EvaluatorService evaluatorService;

    @RabbitListener(queues = "${javainuse.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(Url urlx){
        logger.info("Recieved Message From RabbitMQ: " + urlx.getUrl());
        evaluatorService.getConsumedUrl(urlx);
    }

}