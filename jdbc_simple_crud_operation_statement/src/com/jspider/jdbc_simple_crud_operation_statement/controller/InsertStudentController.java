package com.jspider.jdbc_simple_crud_operation_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudentController {
	public static void main(String[] args)
	{
		Connection connection=null;
		try 
		{
			//step-1: Load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2: Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-e4";
			String user="root";
			String password="26110911";
			connection=DriverManager.getConnection(url,user,password);
			System.out.println(connection);
			
			//step-3: Create Statement
			Statement statement=connection.createStatement();
			System.out.println(statement);
			
			//step-4: Execute Query
			String insertStudentQuery="insert into student values(6,'Shubham',8869110787,'shubh@gmail.com','2000-06-17','Prayagraj, Uttar Pradesh','M')";
			boolean status=statement.execute(insertStudentQuery);
			if(status)
				System.out.println("Recored Inserted");
			else
				System.out.println("Error Occurred while Inserting the Record");
			
			System.out.println("Program Terminated");
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//step-5: Close Connection
			try
			{
				connection.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
