package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.User;
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

    @Value("${javainuse3.rabbitmq.routingkey}")
    private String routingkey3;


    public void sender(User user) {

        System.out.println("user value is"+user);

        rabbitTemplate.convertAndSend(exchange, routingkey3,user);
        System.out.println("Send msg = " + user);
    }
}

