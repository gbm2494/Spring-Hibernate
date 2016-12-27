package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.entity.Customer;

@Repository
//annotation just for DAO implementations
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	//same name as the XML config for the bean sessionFactory
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		//return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save or update customer in database 
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int id) {
		
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//find customer by id
		Customer cust = currentSession.get(Customer.class, id);
		
		return cust;
	}

	@Override
	public void deleteCustomer(int id) {
	
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		/*//find customer by id
		Customer cust = currentSession.get(Customer.class, id);
		
		//delete customer
		currentSession.delete(cust);
		*/
		
		//Another way to do it
		 
		 
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		
		// do the work
		theQuery.executeUpdate();
		
	}

}
