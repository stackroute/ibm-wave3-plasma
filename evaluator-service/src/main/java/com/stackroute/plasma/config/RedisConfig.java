
package  com.stackroute.plasma.config;

import com.stackroute.plasma.service.MessageSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;



/*
import com.michaelcgood.queue.MessagePublisher;
import com.michaelcgood.queue.MessagePublisherImpl;
import com.michaelcgood.queue.MessageSubscriber;
*/

@Configuration
@ComponentScan("com.stackroute.plasma")
public class RedisConfig {


    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
            JedisConnectionFactory jedisConFactory
                    = new JedisConnectionFactory();
            jedisConFactory.setHostName("localhost");
            jedisConFactory.setPort(6379);
            jedisConFactory.setClientName("chandu");
            return jedisConFactory;
    }



    @Bean
    @Autowired
    public RedisMessageListenerContainer container(
            final JedisConnectionFactory connectionFactory ) {

        final RedisMessageListenerContainer container =
                new RedisMessageListenerContainer();

        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listener(), new ChannelTopic("test"));

        return container;

    }

    @Bean
    public MessageListener listener() {
        return new MessageSubscriber();
    }
    /*@Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return template;
    }
    @Bean
    MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new MessageSubscriber());
    }*/

/*    @Bean
    RedisMessageListenerContainer redisContainer() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory());
        container.addMessageListener(messageListener(), topic());
        return container;
    }

*//*
    @Bean
    MessagePublisher redisPublisher() {
        return new MessagePublisherImpl(redisTemplate(), topic());
    }
*//*

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("pubsub:queue");
    }*/
}
























/*
package com.stackroute.plasma.plasma.Config;


import com.stackroute.plasma.domain.Cache;
import com.stackroute.plasma.service.MessageSubscriber;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

*/
/*    @Bean
    RedisTemplate<String, Cache> redisTemplate() {
        RedisTemplate<String,Cache> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }*//*


    */
/*
        @Bean
        JedisConnectionFactory jedisConnectionFactory() {
            return new JedisConnectionFactory();
        }*//*

    @Bean
    public RedisTemplate<String, Cache> redisTemplate() {
        final RedisTemplate<String,Cache> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Cache>(Cache.class));
        return template;
    }
    @Bean
    MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new MessageSubscriber());
    }
  */
/*  @Bean
    MessagePublisher redisPublisher() {
        return new MessagePublisherImpl(redisTemplate(), topic());
    }*//*

}


*/
