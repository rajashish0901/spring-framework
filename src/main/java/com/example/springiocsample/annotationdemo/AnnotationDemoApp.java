package com.example.springiocsample.annotationdemo;

import com.example.springiocsample.common.Coach;
import com.example.springiocsample.common.TennisCoach2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("annotation-applicationContext.xml");
		System.out.println("++ Creating bean instance ++");

		// get the bean from spring container
        //#1 implicit default beanid = classname
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println("~~ Is the theCoach singleton instances " +
                (context.getBean("tennisCoach", Coach.class) == context.getBean("tennisCoach", Coach.class)));

    //#2 explicit beanid defined as the annotation.
        Coach theCoach2 = context.getBean("tenniscoach2", com.example.springiocsample.common.TennisCoach2.class);


        // call a method on the bean
		System.out.println("theCoach:: " + theCoach.getDailyWorkout());
        System.out.println("theCoach:: " +theCoach.getDailyFortune());

        // call a method on the bean
        System.out.println("theCoach2:: " + theCoach2.getDailyWorkout());
        System.out.println("theCoach2:: " + theCoach2.getDailyFortune());
        System.out.println("theCoach2:: " + ((TennisCoach2) theCoach2).getEmail());


        System.out.println("~~ Is the theCoach2 singleton instances " +
                (context.getBean("tenniscoach2", com.example.springiocsample.common.TennisCoach2.class) ==
                        context.getBean("tenniscoach2", com.example.springiocsample.common.TennisCoach2.class)));

		System.out.println("++ Closing the context ++");
		// close the context
		context.close();
		
	}

}


