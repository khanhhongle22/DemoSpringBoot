package com.example.demo_spring.demo6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private ScheduledTaskService scheduledTaskService;

    @GetMapping("/run")
    public String runBackgroundTask() {
        scheduledTaskService.performScheduledTask();
        return "Background task is running...";
    }
}
