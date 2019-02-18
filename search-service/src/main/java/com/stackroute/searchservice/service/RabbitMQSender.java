package com.stackroute.searchservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.searchservice.domain.SearchOutput;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;
    ObjectMapper objectMapper = new ObjectMapper();
    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse2.rabbitmq.routingkey}")
    private String routingkey2;
    // String kafkaTopic = "java_in_use_topic";

    public void send(SearchOutput[] searchOutput) throws JsonProcessingException {
        amqpTemplate.convertAndSend(exchange, routingkey2, objectMapper.writeValueAsString(searchOutput));
        System.out.println("Send msg = " + searchOutput);

    }
}