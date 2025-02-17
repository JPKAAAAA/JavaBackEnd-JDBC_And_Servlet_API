package com.jspider.jdbc_simple_crud_prepared_statement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ProductConnection {
	public static Connection getProductConnection()
	{
		try
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-e4","root","26110911");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
