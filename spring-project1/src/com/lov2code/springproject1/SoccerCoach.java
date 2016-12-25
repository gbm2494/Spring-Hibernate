package com.lov2code.springproject1;

public class SoccerCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public SoccerCoach(FortuneService theFortuneService)
	{
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkOut() {
			return "I trained CR7";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	

}
