package com.lov2code.springproject1;

public class BaseballCoach implements Coach{

	//define a private field for the dependency
	private FortuneService fortuneService;
	
	//define a constructor for the dependency injection
	public BaseballCoach(FortuneService theFortuneService){
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkOut(){
			return "Practicamos tiros";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
