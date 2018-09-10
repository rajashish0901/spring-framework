package com.example.springframework.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

    /*When using autowiring, what if there are multiple FortuneService implementations?
    * Spring has special support to handle this case. Use the @Qualifier annotation.*/
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("++ TennisCoach:constructor() ++");
	}

	/* Autowired annotation shall be used to inject dependency @var, @constructor and @method level.

    If there are more than 1 class of the fortune service then you need add the @qualifier along with @autowire to
    help the spring to identify the class.

    As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no longer necessary if the target
    bean only defines one constructor to begin with. However, if several constructors are available, at least one must
    be annotated to teach the container which one to use.*/
    //@Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
        System.out.println("++ TennisCoach:constructor(FortuneService) ++");
    }

	@Override
	public boolean supportsStatelevelCoaching() {
		return false;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("++ TennisCoach:setFortuneService(FortuneService) ++");
        this.fortuneService = fortuneService;
    }

    @Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Autowired
    public void doSomeThing(){
        System.out.println("++ doSomeThing() invoked implicitly via annotation ++ ");
    }

    // add an init method. Code will be excuted aftr the constructor and dependencies have been injected.
    @PostConstruct ////equivalent to  init-method
    public void doMyStartupStuffXXX() {
        System.out.println("++" + getClass().toString() + " inside method doMyStartupStuffXXX");
    }

    // add a destroy method.Code is executed before bean is destroyed.
    @PreDestroy  //equivalent to destroy-method
    public void doMyCleanupStuffYYY() {
        System.out.println("++" + getClass().toString() + " inside method doMyCleanupStuffYYY");
    }
}
