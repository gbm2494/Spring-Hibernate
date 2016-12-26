package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?UseSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try{
			System.out.println("Connecting to database: " + jdbcUrl);
			
			//choose second import option on Connection (java.sql.Connection)
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass); 
			
			System.out.println("Connection successful!!");
		}
		catch (Exception e){
			
		}

	}

}
