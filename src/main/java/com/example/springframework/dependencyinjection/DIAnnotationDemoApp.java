package com.example.springframework.dependencyinjection;

import com.example.springframework.common.Coach;
import com.example.springframework.common.TennisCoach2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
This showcase bean creation and bean initialization via the annotation based Dependency injection.
*/
public class DIAnnotationDemoApp {

	public static void main(String[] args) {

        System.out.println("@@ Entering main method @@");

        // Initialize the component scan and other properties in the conext file.
        System.out.println("@@ Initializing diannotation-diconfig-applicationContext.xml @@");
        ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("diannotation-applicationContext.xml");
        //By this point, all the instances mentioned in the xml file has been created.

        System.out.println("@@ Bean instance#1 @@");

		// By this time, Beans are already created during the Spring-Boot app initialization.
        //Bean ids are defined as part of @Component("") tag attached with each bean.

        // getting the bean via the getBean returns the cached object.
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
        System.out.println("~~ Is the theCoach singleton instances " +
                (context.getBean("tennisCoach", Coach.class) == context.getBean("tennisCoach", Coach.class)));

		// call a method on the bean
		System.out.println("theCoach:: " + theCoach.getDailyWorkout());
		System.out.println("theCoach:: " + theCoach.getDailyFortune());

        System.out.println("@@ Bean instance#2 @@");

        //#2 explicit beanid defined as the annotation.
        Coach theCoach2 = context.getBean("tenniscoach2", com.example.springframework.common.TennisCoach2.class);

        // call a method on the bean
        System.out.println("theCoach2:: " + theCoach2.getDailyWorkout());
        System.out.println("theCoach2:: " + theCoach2.getDailyFortune());
        System.out.println("theCoach2:: " + ((TennisCoach2) theCoach2).getEmail());

        System.out.println("~~ Is the theCoach2 singleton instances " +
                (context.getBean("tenniscoach2", com.example.springframework.common.TennisCoach2.class) ==
                        context.getBean("tenniscoach2", com.example.springframework.common.TennisCoach2.class)));

        // Approach#2 Initializing the beans via the application context.
        // Here we have option to initiate the DI (constructor, variable,setter) using the annotations
        System.out.println("@@ Closing the context & exiting main @@");

        // close the context
        context.close();
	}
}