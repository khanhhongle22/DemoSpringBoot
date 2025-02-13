package com.example.demo_spring;

import com.example.demo_spring.demo3.Girl3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringApplication.class, args);

//        ApplicationContext context = SpringApplication.run(DemoSpringApplication.class, args);

        // demo1
		// Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
		// dấu @Component.
		/*Outfit outfit = context.getBean(Outfit.class);
        System.out.println("Instance: " + outfit);
        outfit.wear();
        Girl girl = context.getBean(Girl.class);
        System.out.println("Girl instance: " + girl);
        System.out.println("Girl outfit: " + girl.outfit);
        girl.outfit.wear();*/

        // demo2
        /*Girl2 girl2 = context.getBean(Girl2.class);
        System.out.println("Truoc khi IoC Container destroy Girl");
        context.getBeanFactory().destroyBean(girl2);
        System.out.println("IoC Container da destroy Girl");*/

        // demo3
        /*Girl3 girl3 = context.getBean(Girl3.class);
        System.out.println("Girl instance: " + girl3);
        System.out.println("Girl outfit: " + girl3.outfit);
        girl3.outfit.wear();*/
    }

}
