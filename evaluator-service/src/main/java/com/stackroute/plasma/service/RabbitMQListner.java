package com.stackroute.plasma.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.plasma.domain.Url;

@Service
public class RabbitMQListner{
    //Logger logger = (Logger) LoggerFactory.getLogger(RabbitMQListner.class.getName());

    @Autowired
    EvaluatorService evaluatorService;
   //public static int  counter;
    //int count=0;

    @RabbitListener(queues = "${javainuse.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(Url urlx){
        System.out.println("Recieved Message From RabbitMQ: " + urlx.getUrl());
        //counter++;
        //System.out.println(counter);
        evaluatorService.getConsumedUrl(urlx);
        //counter=count;
    }

}