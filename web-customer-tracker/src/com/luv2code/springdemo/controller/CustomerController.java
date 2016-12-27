package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//inject customer DAO
	/*DELETE THIS PART BECAUSE NOW WE HAVE A CUSTOMER SERVICE LAYER
	 * @Autowired
	private CustomerDAO customerDAO;*/
	
	@Autowired
	private CustomerService customerService;
	
	//@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model theModel){
		
		//get customer from the customer service layer
		List<Customer> list = customerService.getCustomers();
		
		//Add customer to the spring MVC model
		theModel.addAttribute("customers", list);
		
		return "list-customers";
	}
}
