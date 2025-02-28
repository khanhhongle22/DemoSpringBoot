package com.example.demo_spring.demo8;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendTask(String task) {
        rabbitTemplate.convertAndSend("taskQueue", task);
    }
}
