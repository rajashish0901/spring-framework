package com.example.springframework.initandlifecycle;

import com.example.springframework.common.Coach;
import com.example.springframework.common.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringBeanInitApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanInit-applicationContext.xml");

		// retrieve bean from spring container
		//Prototype scope hence separate instance at each initialization.
		Coach theCricCoach = context.getBean("cricCoach", CricketCoach.class);
		Coach tempCricCoachInstance = context.getBean("cricCoach", CricketCoach.class);

		// call methods on the bean
		System.out.println(theCricCoach.getDailyWorkout() + "--" +
				theCricCoach.supportsStatelevelCoaching() + "--" +
				theCricCoach.getDailyFortune());

		//Injecting literal value
		System.out.println(
				((CricketCoach) theCricCoach).getEmailAddress() +
						" ~~ " +
						((CricketCoach) theCricCoach).getTeam());

		System.out.println("Are the theCricCoach and tempCricCoachInstance singleton instances " +
				(theCricCoach == tempCricCoachInstance));

		System.out.println("++ Closing the context ++");
        // close the context
		context.close();
	}
}