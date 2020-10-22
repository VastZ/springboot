package com.boot.mq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

//    AMQP.Channel

    // 1.创建Exchange
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("DIRECT_EXCHANGE");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("TOPIC_EXCHANGE");
    }

    // 2. 创建queue
    @Bean
    public Queue directQueue() {
        return new Queue("DIRECT_QUEUE");
    }

    @Bean
    public Queue topicQueue() {
        return new Queue("TOPIC_QUEUE");
    }

    // 3.创建binding

    @Bean
    public Binding directBinding(@Qualifier("directExchange") DirectExchange exchange,
                                 @Qualifier("directQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("direct.test");
    }

    @Bean
    public Binding topicBinding(@Qualifier("topicExchange") TopicExchange exchange,
                                 @Qualifier("topicQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("*.topic");
    }

}
