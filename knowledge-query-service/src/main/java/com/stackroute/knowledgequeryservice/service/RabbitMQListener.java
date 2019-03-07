package com.stackroute.knowledgequeryservice.service;

import com.stackroute.knowledgequeryservice.model.Tag;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    DocumentService documentService;

    Tag tag = new Tag();

    @RabbitListener(queues = "${javainuse5.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void consume(Tag tag){
        this.tag = tag;
        System.out.println("Recieved Message From RabbitMQ: " + tag.toString());
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
