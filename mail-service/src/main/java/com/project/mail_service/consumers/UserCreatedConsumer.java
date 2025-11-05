package com.project.mail_service.consumers;

import com.project.mail_service.models.UserMailDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedConsumer {


    @RabbitListener(queues = "${app.queue.name}")
    public void consumeMessage(@Payload UserMailDto dto) {
       System.out.println("Received message: ");
        System.out.println("User: "+dto.getName());
        System.out.println("Email enviado para: "+dto.getEmail());
    }
}
