package com.stackroute.taggingservice.service;

import com.stackroute.taggingservice.domain.TagInput;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    TagService tagService;

    TagInput tagInput = new TagInput();

    @RabbitListener(queues = "${javainuse4.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void consume(TagInput tagInput){
        this.tagInput = tagInput;
        System.out.println("Recieved Message From RabbitMQ: " + tagInput);
    }

    public TagInput getTagInput() {
        return tagInput;
    }

    public void setTagInput(TagInput tagInput) {
        this.tagInput = tagInput;
    }
}
