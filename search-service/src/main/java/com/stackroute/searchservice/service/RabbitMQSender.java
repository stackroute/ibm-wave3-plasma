package com.stackroute.searchservice.service;

import com.stackroute.searchservice.domain.SearchOutput;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class RabbitMQSender {
    Logger logger = (Logger) LoggerFactory.getLogger(RabbitMQSender.class.getName());
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse2.rabbitmq.routingkey}")
    private String routingkey2;



    public void sender(SearchOutput searchOutput) {

        rabbitTemplate.convertAndSend(exchange, routingkey2,searchOutput);
        logger.info("Send msg = " + searchOutput);
    }
}