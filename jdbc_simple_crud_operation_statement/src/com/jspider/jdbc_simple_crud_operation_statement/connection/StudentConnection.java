package com.jspider.jdbc_simple_crud_operation_statement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class StudentConnection {
	public static Connection getStudentConnection() {
		try 
		{
			//step-1: load/register Driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//step-2: Create Connection
			String url="jdbc:mysql://localhost:3306/jdbc-e4";
			String user="root";
			String password="26110911";
			Connection connection=DriverManager.getConnection(url, user, password);
			return connection;
		}
		catch( SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
}
