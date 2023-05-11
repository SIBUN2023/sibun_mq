package com.un.sibun_mq.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQPublisher {

    private final RabbitTemplate rabbitTemplate;

    private final String exchangeName = "course-exchange";
    private final String routingKey = "course";

    @Autowired
    public RabbitMQPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishMessage(Object object) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, object);
        System.out.println("Mensaje publicado en la exchange: " + object);
    }
}

