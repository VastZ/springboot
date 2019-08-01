package com.boot.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "DIRECT_QUEUE")
public class DirectConsumer {

    @RabbitHandler
    public void handlerDirect(String msg){
        System.out.println("direct exchange recived msg :" + msg);
    }


}
