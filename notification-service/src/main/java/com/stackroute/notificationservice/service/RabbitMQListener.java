package com.stackroute.notificationservice.service;

import com.stackroute.notificationservice.domain.Documents;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQListener {

     private final SimpMessagingTemplate send;

    @Autowired
    RabbitMQListener(SimpMessagingTemplate send) {
        this.send = send;
    }


    @RabbitListener(queues = "${javainuse6.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void consume(Documents documents){
        System.out.println("Recieved Message From RabbitMQ: " + documents.toString());

         /*SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor
                 .create(SimpMessageType.MESSAGE);
         headerAccessor.setSessionId(documents.getSessionId());
         headerAccessor.setLeaveMutable(true);*/

         String sessionId = documents.getSessionId();

        this.send.convertAndSendToUser(sessionId, "/queue/reply", documents);
         System.out.println("sessionId " + sessionId);/*
         System.out.println("headerAccessor " + headerAccessor.getMessageHeaders());*/
    }


}
