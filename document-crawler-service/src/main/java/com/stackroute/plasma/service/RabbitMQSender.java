package com.stackroute.plasma.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.plasma.domain.Url;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;
    // String kafkaTopic = "java_in_use_topic";
    ObjectMapper objectMapper = new ObjectMapper();
    public void send(Url url) {
        try {
            amqpTemplate.convertAndSend(exchange, routingkey, objectMapper.writeValueAsString(url));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Send msg = " + url);

    }
}