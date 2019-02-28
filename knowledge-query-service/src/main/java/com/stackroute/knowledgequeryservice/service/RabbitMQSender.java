package com.stackroute.knowledgequeryservice.service;

import com.stackroute.knowledgequeryservice.model.Descriptions;
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

    @Value("${javainuse6.rabbitmq.routingkey}")
    private String routingkey6;

    // String kafkaTopic = "java_in_use_topic";

    public void sender(Descriptions descriptions) {
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(searchOutput);
//        System.out.println(json);
        rabbitTemplate.convertAndSend(exchange, routingkey6,descriptions);
        System.out.println("Send msg = " + descriptions.getDescriptions());
    }
}
