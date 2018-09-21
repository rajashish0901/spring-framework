package com.example.springframework.configuration.annotation;

import com.example.springframework.configuration.service.GreetingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication// Thi only scan files and packes from this level and below. For any custom package you need to add
//Component Scan.
@ComponentScan({"com.example.springframework.configuration.service","com.example.springframework.configuration.annotation"})
public class SpringBootCompScanDemo {

    public static void main(String ... args) {
        System.out.println("@@ Initializing the SpringBootCompScanDemo context() @@");

        ApplicationContext ctx = SpringApplication.run(SpringBootCompScanDemo.class, args);

        System.out.println(ctx.getBean(GreetingService.class).greet());

        //initializing the bean context
        System.out.println("@@ Initializing/getting the Bean @@");

        System.out.println("@@ Exiting the app @@");
    }
}
