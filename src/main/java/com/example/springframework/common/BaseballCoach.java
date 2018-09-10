package com.example.springframework.common;

public class BaseballCoach implements Coach {

	// define a private field for the dependency
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "++ Spend 30 minutes on batting practice++";
	}

	public BaseballCoach(FortuneService fortuneService) {
		System.out.println("++ In the  constructor BaseballCoach(FortuneService fortuneService ++");
		this.fortuneService = fortuneService;
	}

	public BaseballCoach() {
		System.out.println("++ In the default constructor BaseballCoach() ++");
		this.fortuneService = null;
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get a fortune
		return fortuneService.getFortune();	}

	@Override
	public boolean supportsStatelevelCoaching() {
		return false;
	}
}








