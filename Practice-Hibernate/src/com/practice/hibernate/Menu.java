package com.practice.hibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.entity.Employee;

public class Menu {

	public static void main(String[] args) {
	
		int opt; 
		
		Scanner a = new Scanner(System.in);
		
		do{
			System.out.println("\nWelcome! Choose the action you want to do in the database");
			System.out.println("1. Insert new employee");
			System.out.println("2. Retrieve an employee according to his id");
			System.out.println("3. Find employees according to their company");
			System.out.println("4. Delete an employee according to his id");
			System.out.println("5. Exit");
			
			opt = a.nextInt();
			
			switch(opt){
				case 1:
				{
					insertEmployee();
				}
				break;
				case 2:
				{
					retrieveEmployeeById();
				}
				break;
				case 3:
				{
					findEmployeeByCompany();
				}
				break;
				case 4:
				{
					deleteEmployeeById();
				}
				break;
				case 5:
				{
					System.out.println("Bye!");
					a.close();
				}
				break;
			};
		}while(opt != 5);
	}
	
	/*Function to insert a new employee in the database*/
	public static void insertEmployee(){
		
		Scanner a = new Scanner(System.in);
	
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			System.out.println("Menu Option 1: Create new employee");
			
			//create employee object
			System.out.println("Insert employee's firstName:");
			String name = a.nextLine();
			
			System.out.println("Insert employee's lastName:");
			String firstName = a.nextLine();
			
			System.out.println("Insert employee's company:");
			String company = a.nextLine();
				
			Employee newEmployee = new Employee(name, firstName, company);
			
			//start a transaction
			session.beginTransaction();
			
			//save the employee object
			session.save(newEmployee);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("New employee: " + newEmployee);
		}
		finally{
			session.close();
		}
	}
	
	/*Function to retrieve an employee by id*/
	public static void retrieveEmployeeById(){
		
		Scanner a = new Scanner(System.in);
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			System.out.println("Menu Option 2: Retrieve employee by id");
			
			//create employee object
			System.out.println("Insert employee's id:");
			int id = a.nextInt();
			
			//retrieve data by id
			session = factory.getCurrentSession();
			
			session.beginTransaction();
						
			Employee emp = session.get(Employee.class, id);
			
			if(emp != null){
				System.out.println("Employee with id: " + id + " is " + emp);
			}
			else{
				System.out.println("There is no employee with id " + id + " in the database");
			}
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally{
			session.close();
		}
	}
	
	/*Function to find employees according to their company*/
	public static void findEmployeeByCompany(){
		
		Scanner a = new Scanner(System.in);
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			System.out.println("Menu Option 3: Find employees according to their company");
			
			//create employee object
			System.out.println("Insert company:");
			String company = a.nextLine();
			
			//retrieve data by company
			session = factory.getCurrentSession();
			
			session.beginTransaction();
						
			List<Employee> listEmployees = session.createQuery("from Employee where company='" + company + "'").getResultList();
			
			//display list of employees
			System.out.println("\nEmployees in company " + company);
			
			for(Employee temp : listEmployees){
				System.out.println(temp);
			}
			
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally{
			session.close();
		}
	}
	
	/*Function to delete an employee according to it's id*/
	public static void deleteEmployeeById(){
		
		Scanner a = new Scanner(System.in);
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			
			System.out.println("Menu Option 4: Delete an employee according to his id");
			
			//create employee object
			System.out.println("Insert employee's id:");
			int id = a.nextInt();
			
			//retrieve data by id
			session = factory.getCurrentSession();
			
			session.beginTransaction();
						
			Employee emp = session.get(Employee.class, id);
			
			if(emp != null){
				System.out.println("Employee was deleted: " + emp);
				session.delete(emp);
			}
			else{
				System.out.println("There is no employee with id " + id + " in the database");
			}
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally{
			session.close();
		}
	}
	
	

}
