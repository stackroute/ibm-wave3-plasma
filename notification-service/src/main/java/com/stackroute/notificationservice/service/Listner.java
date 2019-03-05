/*
package com.stackroute.notificationservice.service;

import com.stackroute.notificationservice.domain.Data;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@Service
public class Listner {

    private final SimpMessagingTemplate send;
    @Autowired
    Listner(SimpMessagingTemplate send) {
        this.send = send;
    }
    @RabbitListener(queues="${jsa.rabbitmq.queue}",containerFactory = "jsaFactory")
    public void recievedMessage(Data data) {
    System.out.println("Recieved Message: " + data);
    data.setSessionId(data.getSessionId());
    data.setDescription(data.getDescription());
    data.setTitle(data.getTitle());
    data.setKeywords(data.getKeywords());
    data.setUrl(data.getUrl());
    this.send.convertAndSend("/topic", data);
}
}
*/
