package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			//start a transaction
			session.beginTransaction();
			
			//query elements in db
			//use class name, not table name (if it is different)
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display list of students
			System.out.println("\nAll rows");
			displayStudents(theStudents);
			
			//query students with lastName Blanco
			//use java property name not column name to filter
			theStudents = session.createQuery("from Student s where s.lastName='Blanco'").getResultList();
			
			//display list of students with lastName Blanco
			System.out.println("\nStudents with lastName Blanco");
			displayStudents(theStudents);
			
			//query students with lastName Blanco or firstName Hillary
			//use java property name not column name to filter
			theStudents = session.createQuery("from Student s where s.lastName='Blanco' or s.firstName='Hillary'").getResultList();
			
			//display list of students with lastName Blanco or firstName Hillary
			System.out.println("\nStudents with lastName Blanco or firstName Hillary");
			displayStudents(theStudents);
			
			//query students with email like gmail
			//use java property name not column name to filter
			theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
			
			//display list of students with email like gmail
			System.out.println("\nStudents with email like gmail");
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Query done!");
		}
		finally{
			session.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student temp : theStudents){
			System.out.println(temp);
		}
	}
}
