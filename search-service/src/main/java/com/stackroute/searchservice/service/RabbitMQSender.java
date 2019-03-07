package com.stackroute.searchservice.service;

import com.stackroute.searchservice.domain.SearchOutput;
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

    @Value("${javainuse2.rabbitmq.routingkey}")
    private String routingkey2;



    public void sender(SearchOutput searchOutput) {

        rabbitTemplate.convertAndSend(exchange, routingkey2,searchOutput);
        System.out.println("Send msg = " + searchOutput);
    }
}