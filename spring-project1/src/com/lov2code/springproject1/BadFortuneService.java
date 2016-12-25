package com.lov2code.springproject1;

public class BadFortuneService implements FortuneService {

	String[] fortunes; 
	
	public BadFortuneService()
	{
		fortunes = new String[3];
		fortunes[0] = "Good luck! Is not your lucky day";
		fortunes[1] = "Don't do anything today! Your luck sucks!";
		fortunes[2] = "Not your day!";
	}
	
	@Override
	public String getFortune() {

		int randomNumber = (int) Math.floor(Math.random()* (fortunes.length));
		return fortunes[randomNumber];
	}

}
