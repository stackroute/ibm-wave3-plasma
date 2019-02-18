package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.Url;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListner {
    @RabbitListener(queues="${javainuse.rabbitmq.queue}", containerFactory="jsaFactory")
    public void recievedMessage(Url url) {
        System.out.println("Recieved Message From RabbitMQ: " +url.getUrl() );
        System.out.println("Recieved Message From RabbitMQ: " +url.getDoc());
        System.out.println("Recieved Message From RabbitMQ: " +url.getDomain());
        //return url.toString();

    }

}
