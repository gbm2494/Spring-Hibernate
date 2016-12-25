package com.luv2code.springproject2;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = {"Hello", "Bye"};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		
		int index = myRandom.nextInt(data.length);
		
		return data[index];
	}

}
