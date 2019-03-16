package com.stackroute.knowledgequeryservice.service;

import com.stackroute.knowledgequeryservice.model.Documents;
import com.stackroute.knowledgequeryservice.model.Tag;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    DocumentService documentService;

    @Autowired
    RabbitMQSender rabbitMQSender;

    Tag tag = new Tag();

    @RabbitListener(queues = "${javainuse5.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void consume(Tag tag){
        this.tag = tag;
        System.out.println("Recieved Message From RabbitMQ: " + tag.toString());
        Documents sender = new Documents();
        sender.setDocuments(documentService.concept(tag.getTaggedConcept(),tag.getTaggedLevel()));
        sender.setUserId(tag.getUserId());
        sender.setJwt(tag.getJwt());
        sender.setRole(tag.getRole());
        sender.setSessionId(tag.getSessionId());
        rabbitMQSender.sender(sender);


    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
