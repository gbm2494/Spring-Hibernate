package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			int studentID = 1;
		
			/*
			//delete one entry in the database
			session = factory.getCurrentSession();		
			session.beginTransaction();
			System.out.println("Getting student with id: " + studentID);
			
			Student st = session.get(Student.class , studentID );
			
			System.out.println("Updating student");
			
			session.delete(st);
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Delete done!");*/
			
			session.beginTransaction();
			
			System.out.println("Delete entry with id=2");
			
			session.createQuery("DELETE from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Delete done!");
			
		}
		finally{
			session.close();
		}
	}
}
