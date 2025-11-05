package com.project.user_service.services;

import com.project.user_service.models.User;
import com.project.user_service.producers.UserCreatedProducer;
import com.project.user_service.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserCreatedProducer producer;


    public UserService(UserRepository userRepository, UserCreatedProducer producer) {
        this.userRepository = userRepository;
        this.producer = producer;
    }

    public User createUser(User user) {
        User created = userRepository.save(user);
        producer.sendMessage(created);
        System.out.println("User created with ID: " + created.getId());
        return created;
    }
}
