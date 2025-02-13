package com.example.demo_spring.demo1;

import org.springframework.stereotype.Component;

@Component
public class Bikini implements Outfit{
    @Override
    public void wear() {
        System.out.println("Mac bikini");
    }
}
