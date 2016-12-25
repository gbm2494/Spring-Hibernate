package com.lov2code.springproject1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {

	public static void main(String[] args) {

		//load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
	
		//retrieve beans from the containers
		Coach object1 = context.getBean("myCoach", Coach.class);
		
		Coach object2 = context.getBean("myCoach", Coach.class);
		
		//check if they are the same
		boolean result = (object1 == object2);
		
		System.out.println("Pointing to the same object: " + result + "\n");
		
		System.out.println("Memory location of object1:  " + object1 + "\n");
		
		System.out.println("Memory location of object2:  " + object2 + "\n");
		
		context.close();
		
		//To use init and destroy methods
		
		//load spring configuration file
		ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
	
		//retrieve beans from the containers
		Coach object3 = context2.getBean("myTrackCoach", Coach.class);
		
		context2.close();
	}
	}

