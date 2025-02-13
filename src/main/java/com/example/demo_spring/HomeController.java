package com.example.demo_spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "index"; // Trả về trang index.html
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
}
