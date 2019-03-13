package com.stackroute.plasma.service;

import com.stackroute.plasma.model.NlpModel;

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

    @Value("${javainuse4.rabbitmq.routingkey}")
    private String routingkey4;

    public void sender(NlpModel nlpModel) {

        System.out.println("Send msg = " + nlpModel);
        rabbitTemplate.convertAndSend(exchange,routingkey4,nlpModel);

    }

}
