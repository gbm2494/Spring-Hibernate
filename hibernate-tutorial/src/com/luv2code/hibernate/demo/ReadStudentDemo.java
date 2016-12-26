package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			//create student object
			Student theStudent = new Student("Hillary", "Blanco", "hillary@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			session.save(theStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Save done!");
			System.out.println(theStudent);
			
			/*------------------------------------------------------------*/
			
			//retrieve data
			session = factory.getCurrentSession();		
			session.beginTransaction();
			System.out.println("Getting student with id: " + theStudent.getId());
			
			Student st = session.get(Student.class,theStudent.getId() );
			System.out.println("Get complete: " + st);
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally{
			session.close();
		}
	}
}
