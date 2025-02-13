package com.example.demo_spring.demo3;

import com.example.demo_spring.demo1.Outfit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Girl3 {
    @Autowired
    public Outfit outfit;
}
