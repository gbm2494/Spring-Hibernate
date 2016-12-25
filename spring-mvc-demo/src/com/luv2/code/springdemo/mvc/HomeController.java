package com.luv2.code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Annotation to identify controllers in spring MVC
@Controller
public class HomeController {

	@RequestMapping("/")
	public String showPage() {
		/*we don't need to put prefix and suffix in the view page because we 
		configure that on the xml*/
		return "main-menu";
	}

}
