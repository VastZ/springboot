package com.boot.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqProducer {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(){
        amqpTemplate.convertAndSend("DIRECT_EXCHANGE","direct.test","直连交换器 就这么自信！");
        amqpTemplate.convertAndSend("TOPIC_EXCHANGE","hahah.topic","主题交换器 就这么优秀！");

    }

}
