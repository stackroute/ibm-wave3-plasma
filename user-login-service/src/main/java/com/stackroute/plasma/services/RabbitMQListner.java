package com.stackroute.plasma.services;

import com.stackroute.plasma.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class RabbitMQListner {

    @RabbitListener(queues = "${javainuse3.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(User user) throws IOException {

    }
}
