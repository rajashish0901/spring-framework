package com.example.springframework.lifeCycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LifeCycleDemoApp {
    public static void main(String ... args){
        System.out.println("@@ main::SpringApplication.run @@");
        ApplicationContext ctx = SpringApplication.run(LifeCycleDemoApp.class, args);

        System.out.println("@@ main::ctx.getBean::LifeCycleBeanOne @@");
        LifeCycleBeanOne bean1 = ctx.getBean(LifeCycleBeanOne.class);
        bean1.doStuffXXX();

        System.out.println("@@ main::ctx.getBean::LifeCycleBeanTwo @@");
        LifeCycleBeanTwo bean2 = ctx.getBean(LifeCycleBeanTwo.class);
        bean2.doStuffXXX();
    }
}
