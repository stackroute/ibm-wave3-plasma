package com.stackroute.plasma.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    // String kafkaTopic = "java_in_use_topic";
    //ObjectMapper objectMapper = new ObjectMapper();
    public void send(Url url) {
        rabbitTemplate.convertAndSend(exchange, routingkey, url);
       logger.info("Send msg = " +url);
    }
}