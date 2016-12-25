package com.luv2code.springproject2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//same process than with xml configuration, the difference is in the xml and java annotations
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/*if spring is using a default id is tennisCoach (classname in lower case), 
		 * if it is using a custom 
		id is the chosen id on java annotations*/
		Coach objeto = context.getBean("tennisCoach", Coach.class);
		
		System.out.println(objeto.getDailyWorkOut());
		
		System.out.println(objeto.getDailyFortune());
		
		//Coach objeto2 = context.getBean("soccerCoach", Coach.class);
		
		//System.out.println(objeto2.getDailyWorkOut());
		
		context.close();

	}

}
