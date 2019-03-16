package com.stackroute.taggingservice.service;

import com.stackroute.taggingservice.domain.NlpModel;
import com.stackroute.taggingservice.domain.TagInput;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    TagService tagService;

    NlpModel nlpModel = new NlpModel();

    @RabbitListener(queues = "${javainuse4.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void consume(NlpModel nlpModel){
        this.nlpModel.setTokenized_lematized(nlpModel.getTokenized_lematized());
        this.nlpModel.setUserId(nlpModel.getUserId());
        this.nlpModel.setJwt(nlpModel.getJwt());
        this.nlpModel.setRole(nlpModel.getRole());
        this.nlpModel.setSessionId(nlpModel.getSessionId());
        System.out.println("Recieved Message From RabbitMQ: " + nlpModel.toString());
        tagService.tagger(this.nlpModel.getTokenized_lematized().toString());
    }

    public NlpModel getNlpModel() {
        return nlpModel;
    }

    public void setNlpModel(NlpModel nlpModel) {
        this.nlpModel = nlpModel;
    }

}
