package com.boot.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "TOPIC_QUEUE")
public class TopicConsumer {

    @RabbitHandler
    public void handlerTopic(String msg){
        System.out.println("topic exchange recived msg :" + msg);
    }


}
