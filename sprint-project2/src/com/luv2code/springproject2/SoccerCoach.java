package com.luv2code.springproject2;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

	@Override
	public String getDailyWorkOut() {
		return "ZZ was training today!";
	}
	
	public String getDailyFortune()
	{
		return "";
	}

}
