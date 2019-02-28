package com.stackroute.plasma.config;

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

    @Value("${javainuse1.rabbitmq.queue}")
    String queueName1;

    @Value("${javainuse.rabbitmq.exchange}")
    String exchange;

    @Value("${javainuse1.rabbitmq.routingkey}")
    private String routingkey1;

    //Receiving message rabbitMQ
    @Bean
    public MessageConverter consumerJsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
<<<<<<< HEAD

    //Receiving message rabbitMQ
    @Bean
    public MessageConverter consumerJsonMessageConverter(){
    return new Jackson2JsonMessageConverter();
}

=======
>>>>>>> 2351f1840d2fd9f68e9b742335e8bd6616b7d23a

    @Bean
    public SimpleRabbitListenerContainerFactory jsaFactory(ConnectionFactory connectionFactory,
                                                           SimpleRabbitListenerContainerFactoryConfigurer configurer) {
        SimpleRabbitListenerContainerFactory factory =
                new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setMessageConverter(consumerJsonMessageConverter());
        return factory;
    }

<<<<<<< HEAD

     //Sending message to rabbitMQ

=======
>>>>>>> 2351f1840d2fd9f68e9b742335e8bd6616b7d23a
    //Sending message to rabbitMQ

<<<<<<< HEAD
    @Value("${javainuse1.rabbitmq.routingkey}")
    private String routingkey1;



=======
>>>>>>> 2351f1840d2fd9f68e9b742335e8bd6616b7d23a
    @Bean
    Queue queue() {
        return new Queue(queueName1, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey1);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }


}
