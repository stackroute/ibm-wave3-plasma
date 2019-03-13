package com.stackroute.plasma.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;



    @Value("${javainuse10.rabbitmq.routingkey}")
    private String routingkey1;


    public void inform() {

        boolean inform=true;
        //rabbitTemplate.convertAndSend(exchange, routingkey2,searchOutput);
        rabbitTemplate.convertAndSend(exchange,routingkey1,inform);
        //System.out.println("Send msg = " + searchOutput);
    }
}
