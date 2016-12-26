package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try{
			int studentID = 1;
			
			//retrieve data
			session = factory.getCurrentSession();		
			session.beginTransaction();
			System.out.println("Getting student with id: " + studentID);
			
			Student st = session.get(Student.class , studentID );
			
			System.out.println("Updating student");
			
			st.setFirstName("Sonia");
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Update done!");
			
			/*---------------UPDATE EMAIL FOR ALL STUDENTS-----------------------*/
			session = factory.getCurrentSession();		
			session.beginTransaction();
			
			System.out.println("\nUPDATE EMAIL FOR ALL STUDENTS");
			
			session.createQuery("Update Student set email='foo@gmail.com'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally{
			session.close();
		}
	}
}
