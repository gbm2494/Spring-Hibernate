package com.lov2code.springproject1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringClass {

	public static void main(String[] args) {
		
		//load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		Coach object = context.getBean("myTrackCoach", Coach.class);
		
		//call methods on the bean
		System.out.println(object.getDailyWorkOut());
		
		System.out.println(object.getDailyFortune());
		
		//close the context
		context.close();
		
		ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("applicationContext.xml");

		//you choose CricketCoach instead of Coach because you area using methods that are only declared
		//in this implemented class
		CricketCoach object2 = context2.getBean("myCricketCoach", CricketCoach.class);
		
		//call methods on the bean
		System.out.println(object2.getDailyWorkOut());
		
		System.out.println(object2.getDailyFortune());
		
		System.out.println(object2.getEmailAddress());
		
		System.out.println(object2.getTeam());
		
		context2.close();
		
		ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext("applicationContext.xml");

		//you choose CricketCoach instead of Coach because you area using methods that are only declared
		//in this implemented class
		Coach object3 = context3.getBean("mySoccerCoach", Coach.class);
		
		//call methods on the bean
		System.out.println(object3.getDailyWorkOut());
		
		System.out.println(object3.getDailyFortune());
		
		
		context3.close();
	}

}
