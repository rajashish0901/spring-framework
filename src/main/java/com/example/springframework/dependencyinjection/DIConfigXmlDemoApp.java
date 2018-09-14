package com.example.springframework.dependencyinjection;

import com.example.springframework.common.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIConfigXmlDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("diconfig-applicationContext.xml");
				
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout() + "--" +
                theCoach.supportsStatelevelCoaching() + "--" +
                theCoach.getDailyFortune());

        // retrieve bean from spring container
        //Singleton instances
        Coach theCoach1 = context.getBean("myCoach1", Coach.class);
        Coach tempCoachInstance = context.getBean("myCoach1", Coach.class);;

        // call methods on the bean
        System.out.println(theCoach1.getDailyWorkout() + "--" +
                theCoach1.supportsStatelevelCoaching() + "--" +
                theCoach1.getDailyFortune());

        // close the context
		context.close();
	}
}