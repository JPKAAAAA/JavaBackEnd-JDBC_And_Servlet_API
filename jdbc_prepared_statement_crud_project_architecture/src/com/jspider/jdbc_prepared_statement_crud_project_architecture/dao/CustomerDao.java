package com.jspider.jdbc_prepared_statement_crud_project_architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspider.jdbc_prepared_statement_crud_project_architecture.connection.CustomerConnection;
import com.jspider.jdbc_prepared_statement_crud_project_architecture.dto.Customer;

public class CustomerDao {
	Connection connection=CustomerConnection.getCustomerConnection();
	final String INSERT_CUSTOMER_QUERY="insert into customer values(?,?,?,?)";
	final String DISPLAY_CUSTOMER_BY_ID_QUERY="select * from customer where id=?";
	public int saveCustomerDao(Customer customer)
	{
		try {
			PreparedStatement ps=connection.prepareStatement(INSERT_CUSTOMER_QUERY);
			ps.setInt(1,customer.getId());
			ps.setString(2,customer.getName());
			ps.setString(3, customer.getEmail());
			ps.setLong(4, customer.getPhone());
			
			return ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
		finally
		{
			try {
				connection.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public Customer getCustomerByIdDao(int id)
	{
		try {
			PreparedStatement ps=connection.prepareStatement(DISPLAY_CUSTOMER_BY_ID_QUERY);
			Customer customer=new Customer();
			ps.setInt(1,id);
			ResultSet set=ps.executeQuery();
			if(set.next())
			{
				String name=set.getString("name");
				String email=set.getString("email");
				long phone=set.getLong("phone");
				customer.setId(id);
				customer.setName(name);
				customer.setEmail(email);
				customer.setPhone(phone);
				return customer;
			}
			else
			{
				System.out.println("Given ID not Found");
				return customer;					
			}
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return new Customer();
		}
		finally
		{
			try {
				connection.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
