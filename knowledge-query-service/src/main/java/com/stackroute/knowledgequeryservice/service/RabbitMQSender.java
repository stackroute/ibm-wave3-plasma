package com.stackroute.knowledgequeryservice.service;

import com.stackroute.knowledgequeryservice.model.Descriptions;
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

    @Value("${javainuse6.rabbitmq.routingkey}")
    private String routingkey6;

    public void sender(Descriptions descriptions) {
        rabbitTemplate.convertAndSend(exchange, routingkey6,descriptions);
        System.out.println("Send msg = " + descriptions.getDescriptions());
    }
}
