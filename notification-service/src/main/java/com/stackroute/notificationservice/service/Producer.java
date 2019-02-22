//package com.stackroute.notificationservice.service;
//
//import org.springframework.amqp.core.AmqpTemplate;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.beans.factory.annotation.Value;
//
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//
//@Service
//
//public class Producer {
//
//
//
//    @Autowired
//
//    private AmqpTemplate amqpTemplate;
//
//
//
//    @Value("${jsa.rabbitmq.exchange}")
//
//    private String exchange;
//
//
//
//    @Value("${jsa.rabbitmq.routingkey}")
//
//    private String routingKey;
//
//
//
//    public void produceMsg(String msg){
//        //String msg ="hello RabbitMQ";
//
//        amqpTemplate.convertAndSend(exchange, routingKey, msg);
//
//        System.out.println("Send msg = " + msg);
//
//    }
//
//}
//
//
//
