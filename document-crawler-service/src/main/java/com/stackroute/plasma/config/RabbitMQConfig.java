package com.stackroute.plasma.config;

import com.stackroute.plasma.domain.SearchOutput;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {


    @Value("${javainuse.rabbitmq.queue}")
    String queueName;

    @Value("${javainuse.rabbitmq.exchange}")
    String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;

    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

     @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    //for receiver
    @Bean
    public Jackson2JsonMessageConverter consumerJsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory jsaFactory(ConnectionFactory connectionFactory,
                                                           SimpleRabbitListenerContainerFactoryConfigurer configurer) {
        SimpleRabbitListenerContainerFactory factory =
                new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setMessageConverter(consumerJsonMessageConverter());
        return factory;
    }
}


//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }

//    @Bean
//    public MessageConverter jsonMessageConverter()
//    {
//        Jackson2JsonMessageConverter jsonMessageConverter = new Jackson2JsonMessageConverter();
//        //jsonMessageConverter.setClassMapper(classMapper());
//        return jsonMessageConverter;
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory)
//    {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(jsonMessageConverter());
//        return rabbitTemplate;
//    }

//    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(jsonMessageConverter());
//        return rabbitTemplate;
//    }

//    @Bean
//    public DefaultClassMapper classMapper()
//    {
//        DefaultClassMapper classMapper = new DefaultClassMapper();
//        Map<String, Class<?>> idClassMapping = new HashMap<>();
//        //idClassMapping.put("com.stackroute.searchservice.domain.SearchOutput", SearchOutput.class);
//        classMapper.setIdClassMapping(idClassMapping);
//        return classMapper;
//    }

//    @Bean
//    public SimpleRabbitListenerContainerFactory jsaFactory(ConnectionFactory connectionFactory,
//                                                           SimpleRabbitListenerContainerFactoryConfigurer configurer) {
//        SimpleRabbitListenerContainerFactory factory =
//                new SimpleRabbitListenerContainerFactory();
//        configurer.configure(factory, connectionFactory);
//        factory.setMessageConverter(jsonMessageConverter());
//        return factory;



