package com.luv2code.springproject2;

import org.springframework.beans.factory.annotation.Value;

public class BasketCoach implements Coach {

	private FortuneService fortuneService;
	
	//annotations to use property file values
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public BasketCoach(FortuneService theFortuneService)
	{
		fortuneService = theFortuneService;
	}

	public BasketCoach(){
		
	}

	public String getEmail() {
		return email;
	}


	public String getTeam() {
		return team;
	}	
	
}
