package com.jspider.jdbc_simple_crud_operation_statement.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.jspider.jdbc_simple_crud_operation_statement.connection.StudentConnection;

public class DisplayStudentController {
	public static void main(String args[]) {
		Connection connection=null;
		try
		{
			connection=StudentConnection.getStudentConnection();
			
			//step-3: Create Statement
			Statement statement=connection.createStatement();
			
			//step-4: Execute Query
			String displayStudentQuery="Select * from student";
			ResultSet set=statement.executeQuery(displayStudentQuery);
			while(set.next()) 
			{
				int id=set.getInt("id");
				String name=set.getString("name");
				String email=set.getString("e-mail");
				long phone=set.getLong("phone");
				LocalDate dob=set.getDate("dob").toLocalDate();
				String address=set.getString("adderss");
				String gender=set.getString("gender");
				System.out.println("id: "+id);
				System.out.println("name: "+name);
				System.out.println("phone: "+phone);
				System.out.println("e-mail: "+email);
				System.out.println("dob: "+dob);
				System.out.println("address: "+address);
				System.out.println("gender: "+gender);
				System.out.println();
			}
			
			displayStudentQuery="Select * from student where id>1";
			set=statement.executeQuery(displayStudentQuery);
			while(set.next())
			{
				int id=set.getInt("id");
				String name=set.getString("name");
				String email=set.getString("e-mail");
				long phone=set.getLong("phone");
				LocalDate dob=set.getDate("dob").toLocalDate();
				String address=set.getString("adderss");
				String gender=set.getString("gender");
				System.out.println("id: "+id);
				System.out.println("name: "+name);
				System.out.println("phone: "+phone);
				System.out.println("e-mail: "+email);
				System.out.println("dob: "+dob);
				System.out.println("address: "+address);
				System.out.println("gender: "+gender);
				System.out.println();
				System.out.println();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				//step-5: Close Connection
				connection.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
