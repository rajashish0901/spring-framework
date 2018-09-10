package com.example.springiocsample.common;

import com.example.springiocsample.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


 /*In contrast to the other scopes, Spring does not manage the complete lifecycle of a
    prototype bean: the container instantiates, configures, and otherwise assembles a
    prototype object, and hands it to the client, with no further record of that prototype
    instance.
    Thus, although initialization lifecycle callback methods are called on all objects regardless of scope, in the
    case of prototypes, configured destruction lifecycle callbacks are not called. The client code must clean up
    prototype-scoped objects and release expensive resources that the prototype bean(s) are holding.

    To get the Spring container to release resources held by prototype-scoped beans, try using a custom bean
    post-processor, which holds a reference to beans that need to be cleaned up.*/


@Component("tenniscoach2")
@Scope("prototype")
public class TennisCoach2 implements Coach {

    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    public TennisCoach2() {
		System.out.println("++ TennisCoach2:constructor() ++");
	}

	//@Qualifier is mandatory here as there are more than 1 FortuneService.
    @Autowired
    public TennisCoach2(@Qualifier("happyFortuneService")
                                    FortuneService fortuneService) {
	    this.fortuneService = fortuneService;
        System.out.println("++ TennisCoach2:constructor(fortuneService) ++");
    }

	@Override
	public boolean supportsStatelevelCoaching() {
		return false;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your forehand volley";
	}

    public String getEmail() {
        return email;
    }

    // add an init method. Code will be executed after the constructor and dependencies have been injected.

    @PostConstruct
    public void doMyStartupStuffXXX() {
        System.out.println("++" + getClass().toString() + " inside method doMyStartupStuffXXX");
    }

    // add a destroy method.Code is executed before bean is destroyed.
    @PreDestroy
    public void doMyCleanupStuffYYY() {
        System.out.println("++" + getClass().toString() + " inside method doMyCleanupStuffYYY");
    }

    @Autowired
    public void doSomeThing(){
        System.out.println("++" + getClass().toString() + " doSomeThing() invoked implicitly via annotation ++ ");
    }
}
