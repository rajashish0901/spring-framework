package com.example.springiocsample.initandlifecycle;

import com.example.springiocsample.common.Coach;
import com.example.springiocsample.common.TrackCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*For "prototype" scoped beans, Spring does not call the destroy method.  Gasp!
---
In contrast to the other scopes, Spring does not manage the complete lifecycle of a prototype bean: the container
instantiates, configures, and otherwise assembles a prototype object, and hands it to the client, with no further
record of that prototype instance.

Thus, although initialization lifecycle callback methods are called on all objects regardless of scope, in the case
of prototypes, configured destruction lifecycle callbacks are not called. The client code must clean up prototype-scoped
objects and release expensive resources that the prototype bean(s) are holding.
---
This also applies to both XML configuration and Annotation-based configuration. */
public class HelloSpringLifeCycleApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("lifeCycle-applicationContext.xml");

        System.out.println("++ Creating bean instance ++");

        Coach trackCoach = context.getBean("trackCoach", TrackCoach.class);
        Coach temptrackCoach = context.getBean("trackCoach", TrackCoach.class);

		System.out.println("Are the theTrackCoach and tempTrackCoachInstance singleton instances " +
				(trackCoach == temptrackCoach));

        System.out.println("++ Closing the context ++");

        // close the context
		context.close();
	}
}