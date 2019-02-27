package com.stackroute.plasma.service;

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
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(searchOutput);
//        System.out.println(json);
        rabbitTemplate.convertAndSend(exchange, routingkey3,nlpModel);
        System.out.println("Send msg = " + nlpModel);
    }
}

