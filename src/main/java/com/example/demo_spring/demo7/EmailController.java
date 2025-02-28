package com.example.demo_spring.demo7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send-email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestParam("recipient") String recipient,
                                            @RequestParam("message") String message) {
        emailService.sendEmail(recipient, message);
        return ResponseEntity.ok("Email request accepted.");
    }
}
