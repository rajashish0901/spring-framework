package com.example.springframework.configuration.annotation;

import com.example.springframework.common.Coach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;


public class SpringBootConfigurationDemoApp {

    public static void main(String ... arg){

        System.out.println("@@ Initializing the app context() @@");

        //If we want spring to build the container using @Configuration annotation then we will use
        // AnnotationConfigApplicationContext.
        //System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "international");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(CoachConfiguration.class);

        //initializing the bean context
        System.out.println("@@ Initializing/getting the Bean @@");
        Coach trackCoach = ctx.getBean(Coach.class);
        System.out.println(" -- " + trackCoach.getDailyFortune() + " -- ");

        System.out.println("@@ Exiting the app @@");
    }
}