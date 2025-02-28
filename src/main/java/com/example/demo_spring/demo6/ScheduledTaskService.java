package com.example.demo_spring.demo6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {
    @Autowired
    private AsyncService asyncService;

    // Runs a task every 5 seconds, logging the current time to the console.
    @Scheduled(fixedRate = 5000)
    public void performScheduledTask() {
        System.out.println("Scheduled task executed at: " + System.currentTimeMillis());
        asyncService.executeAsyncTask();
    }
}
