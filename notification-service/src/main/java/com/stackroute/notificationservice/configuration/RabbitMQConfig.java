package com.stackroute.notificationservice.configuration;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitMQConfig {
    //    @Value("${jsa.rabbitmq.routingkey}")
//
//    String queueName;
//
//
//
//    @Value("${jsa.rabbitmq.exchange}")
//
//    String exchange;
//
//
//
//    @Value("${jsa.rabbitmq.routingkey}")
//
//    private String routingkey;
//
//
//
//    @Bean
//
//    Queue queue() {
//
//        return new Queue(queueName, false);
//
//    }
//
//
//
//    @Bean
//
//    DirectExchange exchange() {
//
//        return new DirectExchange(exchange);
//
//    }
//
//
//
//    @Bean
//
//    Binding binding(Queue queue, DirectExchange exchange) {
//
//        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
//
//    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();

    }



//    @Bean
//
//    public MessageConverter  consumerJsonMessageConverter(){
//
//        return new Jackson2JsonMessageConverter();
//
//    }
//
//
//
    @Bean

    public SimpleRabbitListenerContainerFactory jsaFactory(ConnectionFactory connectionFactory,

                                                           SimpleRabbitListenerContainerFactoryConfigurer configurer) {

        SimpleRabbitListenerContainerFactory factory =

                new SimpleRabbitListenerContainerFactory();

        configurer.configure(factory, connectionFactory);

        factory.setMessageConverter(jsonMessageConverter());

        return factory;

    }



}

