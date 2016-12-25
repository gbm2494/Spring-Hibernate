package com.lov2code.springproject1;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
	}

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
			return "Run for 5 hours";
	}

	@Override
	public String getDailyFortune() {

		return "Just do it! " + fortuneService.getFortune();
	}
	
	//Both have to be public void and no arguments, destroy method is not called when you are using scope prototype
	
	//add init method
	public void initMethod(){
		System.out.println("I am inside the init method");
	}
	
	//add a destroy method
	public void destroyMethod(){
		System.out.println("I am inside the destroy method");
	}

}
