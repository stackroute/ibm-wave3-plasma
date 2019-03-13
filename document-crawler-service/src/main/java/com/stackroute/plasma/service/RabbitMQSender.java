package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.Url;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQSender {
    Logger logger = LoggerFactory.getLogger(RabbitMQSender.class.getName());

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;

    @Value("${javainuse8.rabbitmq.routingkey}")
    private String routingkey8;

    public void send(Url url) {
        rabbitTemplate.convertAndSend(exchange, routingkey, url);
       logger.info("Send msg = " +url);
    }

    public void inform() {
        boolean inform=true;
        //rabbitTemplate.convertAndSend(exchange, routingkey, url);
        rabbitTemplate.convertAndSend(exchange,routingkey8,inform);
        //System.out.println("Send msg = " +url);
    }
}