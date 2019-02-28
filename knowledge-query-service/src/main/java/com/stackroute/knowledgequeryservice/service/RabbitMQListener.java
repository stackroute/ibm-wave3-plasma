/*
package com.stackroute.knowledgequeryservice.service;

import com.stackroute.knowledgequeryservice.model.Tag;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    DescriptionService descriptionService;

    Tag tag = new Tag();

    @RabbitListener(queues = "${javainuse5.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void consume(Tag tag){
        System.out.println("Recieved Message From RabbitMQ: " + tag.toString());
    }

}
*/
