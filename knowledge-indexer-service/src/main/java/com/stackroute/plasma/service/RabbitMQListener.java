package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Document;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    DocumentService documentService;

    @RabbitListener(queues = "${javainuse1.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void consume(Document document){
        System.out.println("Recieved Message From RabbitMQ: " + document.toString());
        documentService.create(document);
    }
}
