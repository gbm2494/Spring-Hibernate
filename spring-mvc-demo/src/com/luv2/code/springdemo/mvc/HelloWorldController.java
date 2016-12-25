package com.luv2.code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//you use request mapping for the entire control if you want to avoid conflicts between
//methods from different controllers with the same name. 
@RequestMapping("helloWorld")
public class HelloWorldController {
	
	//this request mapping is relative to the request mapping from the controller
	//in this moment is /helloWorld/showForm
	//is the request mapping from the class is commented is only /showForm
	@RequestMapping("/showForm")
	public String showForm(){
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(){
		return "helloworld";
	}
	
	@RequestMapping("/processFormv2")
	//HttpServletRequest: is used to hold html form data
	//Model: container for your data
	public String paramUpperCase(HttpServletRequest request, Model model){
		
		//use the html name (studentName)
		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		String result = "Yo " + name;
		//model.addAttribute(name of the new attibute, value of the new attibute)
		//you can access to this attibute on the view
		model.addAttribute("message", result);
		return "helloworld"; //return name of the view page to display
	}
	
	@RequestMapping("/processFormv3")
	//@RequestParam("nameHTML"): is used to bind data directly from the form data, 
	//is equals to String name = request.getParameter("studentName") but spring direcly bind it
	//Model: container for your data
	public String paramUpperCasev2(@RequestParam("studentName") String name, Model model){
		
		name = name.toUpperCase();
		String result = "Nice to meet you " + name;
		//model.addAttribute(name of the new attibute, value of the new attibute)
		//you can access to this attibute on the view
		model.addAttribute("message", result);
		return "helloworld"; //return name of the view page to display
	}
}
