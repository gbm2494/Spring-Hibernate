package com.luv2.code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;	
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private LinkedHashMap<String, String> countryOptions;
	private LinkedHashMap<String, String> languageOptions;
	private String[] operatingSystems;
	
	public Student(){
	
		//populate country options
		countryOptions = new LinkedHashMap<>();
		
		//(key, value) is like (value, label) from the form:options in html jsp
		countryOptions.put("CR", "Costa Rica");
		countryOptions.put("ESP", "España");
		countryOptions.put("USA", "Estados Unidos");
		countryOptions.put("BR", "Brasil");
		countryOptions.put("ING", "Inglaterra");
		
		//populate language options
		languageOptions = new LinkedHashMap<>();
		languageOptions.put("C#", "C#");
		languageOptions.put("Java", "Java");
		languageOptions.put("JavaScript", "JavaScript");
		languageOptions.put("Ruby", "Ruby");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
}
