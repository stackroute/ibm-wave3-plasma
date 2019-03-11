package com.stackroute.taggingservice.service;

import com.stackroute.taggingservice.domain.NlpModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    TagService tagService;

    NlpModel tagInput = new NlpModel();

    @RabbitListener(queues = "${javainuse4.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void consume(NlpModel tagInput){
        this.tagInput.setTokenized_lematized(tagInput.getTokenized_lematized());
        System.out.println("Recieved Message From RabbitMQ: " + tagInput.toString());
        System.out.println("Recieved Message From RabbitMQ: " + tagInput);
        System.out.println("Recieved Message From RabbitMQ: " + this.tagInput);
        System.out.println("Recieved Message From RabbitMQ: " + this.tagInput.toString());
    }

    public NlpModel getTagInput() {
        return tagInput;
    }

    public void setTagInput(NlpModel tagInput) {
        this.tagInput = tagInput;
    }
}
