package com.example.springframework.configuration.annotation;

import com.example.springframework.common.Coach;
import com.example.springframework.configuration.service.GreetingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;


public class SpringBootConfigurationDemoApp {

    public static void main(String ... arg){

        System.out.println("@@ Initializing the SpringBootConfigurationDemoApp context() @@");

        //If we want spring to build the container using @Configuration annotation then we will use
        // AnnotationConfigApplicationContext.
        //System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "international");
        ApplicationContext config_ctx = new AnnotationConfigApplicationContext(CoachConfiguration.class);

        //initializing the bean context
        System.out.println("@@ Initializing/getting the Bean @@");
        Coach trackCoach = config_ctx.getBean(Coach.class);
        System.out.println(" -- " + trackCoach.getDailyFortune() + " -- ");

        System.out.println("@@ Exiting the app @@");
    }
}