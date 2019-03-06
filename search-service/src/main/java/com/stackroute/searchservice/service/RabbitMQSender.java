package com.stackroute.searchservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.searchservice.domain.SearchOutput;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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