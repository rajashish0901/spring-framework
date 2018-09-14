package com.example.springframework.common;

public class TrackCoach implements Coach {
	@Override
	public boolean supportsStatelevelCoaching() {
		return false;
	}

	private FortuneService fortuneService;

	public TrackCoach() {
		System.out.println("++ TrackCoach::Const() ++");
	}
	
	public TrackCoach(FortuneService fortuneService) {
		System.out.println("++ TrackCoach::Const(FortuneService fortuneService) ++");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It: " + fortuneService.getFortune();
	}

	// add an init method
	public void doMyStartupStuffXXX() {
		System.out.println("++ TrackCoach: inside method doMyStartupStuffXXX ++");
	}
	
	// add a destroy method
	public void doMyCleanupStuffYYY() {
		System.out.println("++ TrackCoach: inside method doMyCleanupStuffYYY ++");
	}
}










