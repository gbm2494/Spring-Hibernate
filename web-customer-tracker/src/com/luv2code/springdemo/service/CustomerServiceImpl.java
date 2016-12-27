package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//need to inject the customerDAO
	@Autowired
	private CustomerDAO customer;
	
	@Override
	//use instead of session.begin and commmit
	@Transactional
	public List<Customer> getCustomers() {	
		return customer.getCustomers();
	}

}
