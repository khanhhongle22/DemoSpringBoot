package com.example.demo_spring.demo3;

import com.example.demo_spring.demo1.Outfit;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Naked implements Outfit {
    @Override
    public void wear() {
        System.out.println("Dang khong mac gi");
    }
}
