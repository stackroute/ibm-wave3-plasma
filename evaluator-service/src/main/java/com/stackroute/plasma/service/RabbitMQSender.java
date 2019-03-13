package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.Evaluator;
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

    @Value("${javainuse1.rabbitmq.routingkey}")
    private String routingkey1;

    @Value("${javainuse9.rabbitmq.routingkey}")
    private String routingkey2;


    public void send(Evaluator evaluator)
    {
        rabbitTemplate.convertAndSend(exchange, routingkey1,evaluator);
    }

    public void inform() {
        boolean inform=true;
        //rabbitTemplate.convertAndSend(exchange, routingkey, url);
        rabbitTemplate.convertAndSend(exchange,routingkey2,inform);
        //System.out.println("Send msg = " +url);
    }
}