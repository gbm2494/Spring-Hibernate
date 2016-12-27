package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		//create a new model attribute
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		//save customer using the service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel){
		
		//get the customer from the database
		Customer theCustomer = customerService.getCustomer(id);
		
		//set a customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		//send over to our form
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id){
		
		//delete customer according to id
		customerService.deleteCustomer(id);
		
		//redirect to list
		return "redirect:/customer/list";
		
	}
}
