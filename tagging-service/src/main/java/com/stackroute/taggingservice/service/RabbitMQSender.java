package com.stackroute.taggingservice.service;

import com.stackroute.taggingservice.domain.TagOutput;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    //ObjectMapper objectMapper = new ObjectMapper();
    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse5.rabbitmq.routingkey}")
    private String routingkey5;

    // String kafkaTopic = "java_in_use_topic";

    public void sender(TagOutput tagOutput) {
//        ObjectMapper mapper = new ObjectMapper();
//        String json = null;
//        try {
//            json = mapper.writeValueAsString(nlpModel);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(json);
        rabbitTemplate.convertAndSend(exchange, routingkey5,tagOutput);
        System.out.println("Send msg = " + tagOutput);
    }

}
