package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.User;
<<<<<<< HEAD

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQSender {

    @Autowired
=======
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

>>>>>>> f82a88f43470e0b6480196ffed9b1a9118671d66
    private RabbitTemplate rabbitTemplate;
    //ObjectMapper objectMapper = new ObjectMapper();
    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse3.rabbitmq.routingkey}")
    private String routingkey3;

<<<<<<< HEAD
    // String kafkaTopic = "java_in_use_topic";

    public void sender(User user) {

        rabbitTemplate.convertAndSend(exchange, routingkey3,user);
        System.out.println("Send msg = " + user);
    }
}
=======

    public void sender(User user) {

        rabbitTemplate.convertAndSend(exchange,routingkey3,user);
        System.out.println("Send msg = " + user);
    }
}

>>>>>>> f82a88f43470e0b6480196ffed9b1a9118671d66
