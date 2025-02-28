package com.example.demo_spring.demo8;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TaskListener {
    @RabbitListener(queues = "taskQueue")
    public void handleTask(String task) {
        System.out.println("Processing task: " + task);
    }
}
