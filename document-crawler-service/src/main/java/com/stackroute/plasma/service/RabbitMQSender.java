package com.stackroute.plasma.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.plasma.domain.Url;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;
    // String kafkaTopic = "java_in_use_topic";
    //ObjectMapper objectMapper = new ObjectMapper();
    public void send(Url url) {
        rabbitTemplate.convertAndSend(exchange, routingkey, url);
        System.out.println("Send msg = " +url);
    }
}