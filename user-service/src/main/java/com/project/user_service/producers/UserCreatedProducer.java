package com.project.user_service.producers;

import com.project.user_service.models.User;
import com.project.user_service.models.UserMailDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedProducer {
    private final RabbitTemplate rabbitTemplate;
    private final String queueName;

    public UserCreatedProducer(RabbitTemplate rabbitTemplate,
                               @Value("${app.queue.name}")
                               String queueName) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueName = queueName;
    }

    public void sendMessage(User user) {
        UserMailDto dto =  new UserMailDto();
        BeanUtils.copyProperties(user, dto);
        rabbitTemplate.convertAndSend(queueName, dto);
    }

}
