package com.example.demo_spring.demo7;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Async
    public void sendEmail(String recipient, String message) {
        // Simulate email sending logic
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Email sent to " + recipient + ", with message: " + message);
    }
}
