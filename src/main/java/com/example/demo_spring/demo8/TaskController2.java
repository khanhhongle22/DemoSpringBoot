package com.example.demo_spring.demo8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController2 {
    @Autowired
    private TaskSender taskSender;

    @PostMapping("/send-task")
    public ResponseEntity<String> sendTask(@RequestParam("task") String task) {
        taskSender.sendTask(task);
        return ResponseEntity.ok("Task send to queue!");
    }
}
