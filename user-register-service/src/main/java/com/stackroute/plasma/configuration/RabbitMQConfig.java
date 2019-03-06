package com.stackroute.plasma.configuration;

<<<<<<< HEAD

=======
>>>>>>> f82a88f43470e0b6480196ffed9b1a9118671d66
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

<<<<<<< HEAD
=======

>>>>>>> f82a88f43470e0b6480196ffed9b1a9118671d66
@Configuration
public class RabbitMQConfig {


    @Value("${javainuse3.rabbitmq.queue}")
    String queueName;

<<<<<<< HEAD
    @Value("${javainuse.rabbitmq.exchange}")
    String exchange;

    @Value("${javainuse3.rabbitmq.routingkey}")
    private String routingkey3;

    @Bean
    Queue queue() {
=======
    @Value("${javainuse3.rabbitmq.exchange}")
    String exchange;

    @Value("${javainuse3.rabbitmq.routingkey}")
    private String routingkey2;

    @Bean
    org.springframework.amqp.core.Queue queue() {
>>>>>>> f82a88f43470e0b6480196ffed9b1a9118671d66
        return new Queue(queueName, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

<<<<<<< HEAD
    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey3);
=======

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey2);
>>>>>>> f82a88f43470e0b6480196ffed9b1a9118671d66
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}