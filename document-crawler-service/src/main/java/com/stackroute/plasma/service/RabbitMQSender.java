package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.Url;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQSender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;
       public void send(Url url) {
        rabbitTemplate.convertAndSend(exchange, routingkey, url);
        System.out.println("Send msg = " +url);
    }
}