package com.luv2code.springproject2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*Java Annotation for spring, if I only write @Component Spring produces 
a default ID (name class with first letter in lower case unless the first
two letters are upper case. If you want to
choose a custom id you use @Component("name")*/
@Component
//Change scope of the class, singleton by default
//@Scope("prototype")
public class TennisCoach implements Coach {

	/*You can use field injection*/
	@Autowired
	//Always change first letter for lower case, unless the first two letter are upper case
	//you use qualifier when you have more than one implementation of the interface
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach(){
		
	}
	
	//How to declare custom methods for init and destroy with annotations
	@PostConstruct
	public void initMethod()
	{
		System.out.println("Soy el método initMethod() de la clase TennisCoach");
	}
	
	//this method doesn't execute with scope prototype (also in XML approach)
	@PreDestroy
	public void destroyMethod()
	{
		System.out.println("Soy el método destroyMethod() de la clase TennisCoach");
	}
	
	
	//Constructor doesn't work because it needs the Qualifier annotation, the qualifier annotation
	//goes inside the parameters like this: 
	/*public TennisCoach(@Qualifier("randomFortuneService")FortuneService theFortuneService)
	{
		this.fortuneService = theFortuneService;
	}
	 * */
	
	/*Allows to associate reference classes, equals to XML config*/
	/*@Autowired
	public TennisCoach(FortuneService theFortuneService)
	{
		this.fortuneService = theFortuneService;
	}*/
	
	@Override
	public String getDailyWorkOut() {

		return "Practice more!!";
	}
	
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}

	//Both (setter and custom method) doesn't work because they need the Qualifier annotation
	/*@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	
	//You can use DI in any custom method, not just constructors and setters
	/*@Autowired
	public void changeValue(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	
	
}
