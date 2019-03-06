package com.stackroute.plasma.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

public class RabbitMQListner {

    @RabbitListener(queues = "${javainuse2.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void recievedMessage(SearchOutput searchOutput) throws IOException {
        this.searchOutputt = searchOutput;

        //this.searchOutputt = this.objectMapper.readValue(searchOutput,SearchOutput);
        for (String x:searchOutput.getUrls()
        ) {
            System.out.println("-------------"+x);
        }
        System.out.println("Recieved Message From RabbitMQ: " + searchOutput.getConcept() +searchOutput.getUrls());
        System.out.println("check url----------------"+ searchOutputt.getUrls()+"8888888888"+searchOutputt.getConcept());

    }
}
