package com.luv2code.springproject2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain {

	public static void main(String[] args) {
		
	/*to prove java configuration approach, it doesn't use spring XML 
	 * the process is the same with java annotations, configuration class
	 * instead of xml just for the scan statement*/
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
	
	/*This code doesn't work because we comment ComponentScan in SportConfig.java, 
	 * because we are practicing with bean definition individually on the class*/
	
	/*Coach objeto = context.getBean("tennisCoach", Coach.class);
	
	System.out.println(objeto.getDailyWorkOut());
	
	System.out.println(objeto.getDailyFortune());*/
	
	//I have to change the type of object from the interface to an implemented class
	//because I am using methods that are not declared on the interface (gets)
	BasketCoach objeto2 = context.getBean("basketCoach", BasketCoach.class);
	
	System.out.println(objeto2.getDailyWorkOut());
	
	System.out.println(objeto2.getDailyFortune());
	
	System.out.println("Email: " + objeto2.getEmail());
	
	System.out.println("Team: " + objeto2.getTeam());
	
	context.close();

	}

}
