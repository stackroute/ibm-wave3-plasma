package com.stackroute.taggingservice.service;

import com.stackroute.taggingservice.domain.NlpModel;
import com.stackroute.taggingservice.domain.TagInput;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    TagService tagService;

    //NlpModel tagInput = new NlpModel();
    TagInput tagInput = new TagInput();

    @RabbitListener(queues = "${javainuse4.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void consume(TagInput tagInput){
        this.tagInput.setTokenizedQuery(tagInput.getTokenizedQuery());
        this.tagInput.setUserId(tagInput.getUserId());
        this.tagInput.setJwt(tagInput.getJwt());
        this.tagInput.setRole(tagInput.getRole());
        System.out.println("Recieved Message From RabbitMQ: " + tagInput.toString());
        System.out.println("Recieved Message From RabbitMQ: " + tagInput);
        System.out.println("Recieved Message From RabbitMQ: " + this.tagInput);
        System.out.println("Recieved Message From RabbitMQ: " + this.tagInput.toString());
    }

    public TagInput getTagInput() {
        return tagInput;
    }

    public void setTagInput(TagInput tagInput) {
        this.tagInput = tagInput;
    }
}
