//package com.stackroute.taggingservice.service;
//
//import com.stackroute.taggingservice.domain.TagInput;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RabbitMQListener {
//   // @Autowired
//    TagInput tagInputt = new TagInput();
//
//    public TagInput getTagInputt() {
//        return tagInputt;
//    }
//
//    public void setTagInputt(TagInput tagInputt) {
//        this.tagInputt = tagInputt;
//    }
//
//    public RabbitMQListener(TagInput tagInputt) {
//        this.tagInputt = tagInputt;
//    }
//
//    @RabbitListener(queues = "${javainuse4.rabbitmq.queue}", containerFactory = "jsaFactory")
//    public void consume(TagInput tagInput){
//        //tagInputt.setTokenizedQuery(tagInput);
//        System.out.println("Recieved Message From RabbitMQ: " + tagInput.toString());
//        //this.tagInputt=tagInput;
//        //TagInput tagInput1 = new TagInput(tagInput.getTokenizedQuery());
//        RabbitMQListener rabbitMQListener = new RabbitMQListener(tagInput);
//        //this.tagInputt.setTokenizedQuery(tagInput.getTokenizedQuery());
//    }
//
//}
