package com.stackroute.notificationservice.service;

import com.stackroute.notificationservice.domain.Data;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@Service
public class Listner {
    private final SimpMessagingTemplate template;
    @Autowired
    Listner(SimpMessagingTemplate template) {
        this.template = template;
    }
    @RabbitListener(queues="${jsa.rabbitmq.queue}",containerFactory = "jsaFactory")
     public void recievedMessage(Data data) {
    System.out.println("Recieved Message: " + data);
    data.setSessionId(data.getSessionId());
    data.setDescription(data.getDescription());
    data.setTitle(data.getTitle());
    data.setKeywords(data.getKeywords());
    data.setUrl(data.getUrl());
        this.template.convertAndSend("/topic", data);
}
}
