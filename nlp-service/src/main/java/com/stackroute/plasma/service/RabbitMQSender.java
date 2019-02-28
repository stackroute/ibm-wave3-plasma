package com.stackroute.plasma.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.plasma.model.NlpModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class RabbitMQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    //ObjectMapper objectMapper = new ObjectMapper();
    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse3.rabbitmq.routingkey}")
    private String routingkey3;

    // String kafkaTopic = "java_in_use_topic";

    public void sender(NlpModel nlpModel) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(nlpModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        rabbitTemplate.convertAndSend(exchange, routingkey3,json);
        System.out.println("Send msg = " + json);
    }
}

