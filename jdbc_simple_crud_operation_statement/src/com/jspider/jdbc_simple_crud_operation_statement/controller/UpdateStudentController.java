package com.jspider.jdbc_simple_crud_operation_statement.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jspider.jdbc_simple_crud_operation_statement.connection.StudentConnection;

public class UpdateStudentController {
	public static void main(String[] args)
	{
		Connection connection=null;
		try 
		{
			connection=StudentConnection.getStudentConnection();
			Statement statement=connection.createStatement();
			String updateStudentQuery="update student set adderss='South Delhi, New Delhi' where id=1";
			int status=statement.executeUpdate(updateStudentQuery);
			if(status!=0)
				System.out.println(status+"Record Updated");
			else
				System.out.println("Error Occurred while Updating the Record");
			
			System.out.println("Program Terminated");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
