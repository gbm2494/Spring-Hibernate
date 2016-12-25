package com.luv2code.springproject2;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
	
	public String getFortune(){
		return "It's your lucky day";
	}
}
