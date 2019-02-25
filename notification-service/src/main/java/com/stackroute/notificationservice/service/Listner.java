package com.stackroute.notificationservice.service;

import com.stackroute.notificationservice.domain.Data;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Listner {

    @RabbitListener(queues="${jsa.rabbitmq.queue}",containerFactory = "jsaFactory")
public void recievedMessage(Data data) {
    System.out.println("Recieved Message: " + data);
    data.setSessionId(data.getSessionId());
    data.setDescription(data.getDescription());
    data.setTitle(data.getTitle());
    data.setKeywords(data.getKeywords());
    data.setUrl(data.getUrl());
}
}
