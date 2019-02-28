package com.stackroute.plasma.service;

import com.stackroute.plasma.model.UserQuery;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    //UserQuery userQuery = new UserQuery();

    @RabbitListener(queues = "${javainuse4.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void consume(UserQuery userQuery){
        System.out.println("Recieved Message From RabbitMQ: " + userQuery.toString());
    }

}
