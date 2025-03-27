package com.jspider.servlet_simple_project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class CustomerConnection {
	public static Connection getCustomerConnection() {
		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();    //can also use fully qualified name
			DriverManager.registerDriver(driver);
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-e4", "root", "26110911");
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
