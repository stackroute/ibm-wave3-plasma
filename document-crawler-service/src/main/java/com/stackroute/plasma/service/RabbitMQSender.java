package com.stackroute.plasma.service;

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

    public void send(Url url) {
        amqpTemplate.convertAndSend(exchange, routingkey, url);
        System.out.println("Send msg = " + url);

    }
}