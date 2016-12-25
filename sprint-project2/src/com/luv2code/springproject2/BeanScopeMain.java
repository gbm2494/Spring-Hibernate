package com.luv2code.springproject2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeMain {

	public static void main(String[] args) {
		
		//Main to prove scopes on java annotations
		
		//load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		//retrieve beans from the containers
		Coach object1 = context.getBean("tennisCoach", Coach.class);
		
		Coach object2 = context.getBean("tennisCoach", Coach.class);
		
		//check if they are the same
		boolean result = (object1 == object2);
		
		System.out.println("Pointing to the same object: " + result + "\n");
		
		System.out.println("Memory location of object1:  " + object1 + "\n");
		
		System.out.println("Memory location of object2:  " + object2 + "\n");
		
		context.close();

	}

}
