package com.luv2code.springproject2;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

//JAVA CODE APPROACH
/*use to declare java code approach for spring
 * java detects this class is a java configuration class
 * configuration class instead of xml just for the scan statement
*/
@Configuration
//You don't use @ComponentScan when you define each bean individually
//@ComponentScan("com.luv2code.springproject2")
//you use this annotation to use property file to read values
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	@Bean
	public FortuneService fileFortuneService()
	{
		return new FileFortuneService();
	}
	//When you use java code approach you need to define method to expose the bean
	//name of the method is the beanID, return type is the interface type
	@Bean
	public Coach basketCoach(){
		//you can call bean dependencies like XML approach, you inject the dependency
		BasketCoach newCoach = new BasketCoach(fileFortuneService());
		return newCoach;
	}
	
	//use to configure values from the property file
	//add to resolve ${...} properties
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}

	
}
