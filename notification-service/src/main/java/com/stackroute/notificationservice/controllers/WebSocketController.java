package com.stackroute.notificationservice.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class WebSocketController {
    private final SimpMessagingTemplate template;

    @Autowired
    WebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/data")
    public void onReceivedName(String data) throws Exception {
//        System.out.println("JSON format " + user);
        System.out.println("Data coming from particular topic  " + data);
        this.template.convertAndSend("/topic", data );
    }

}