package com.jspider.jdbc_prepared_statement_crud_project_architecture.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.jspider.jdbc_prepared_statement_crud_project_architecture.connection.CustomerConnection;
import com.jspider.jdbc_prepared_statement_crud_project_architecture.dto.Customer;

public class CustomerDao {
	Connection connection=CustomerConnection.getCustomerConnection();
	
	final String INSERT_CUSTOMER_QUERY="insert into customer values(?,?,?,?)";
	final String DISPLAY_CUSTOMER_BY_ID_QUERY="select * from customer where id=?";
	final String DISPLAY_ALL_CUSTOMER_QUERY="select * from customer";
	final String UPDATE_NAME_BY_ID_QUERY="update customer set name=? where id=?";
	
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
	
	public List<Customer> displayAllCustomerDao()
	{
		List<Customer> customers=new ArrayList<Customer>();
		try {
			PreparedStatement ps=connection.prepareStatement(DISPLAY_ALL_CUSTOMER_QUERY);
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				int id=set.getInt("id");
				String name=set.getString("name");
				String email=set.getString("email");
				long phone=set.getLong("phone");
				Customer customer=new Customer();
				customer.setId(id);
				customer.setName(name);
				customer.setEmail(email);
				customer.setPhone(phone);
				customers.add(customer);
			}
			return customers;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return customers;
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
	
	public int deleteCustomerByIdDao(int id)
	{
		try {
			CallableStatement call=connection.prepareCall("call deleteCustomerById(?)");
			call.setInt(1, id);
			return call.executeUpdate();
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

	public int updateCustomerNameByIdDao(String name,int id)
	{
		try {
			PreparedStatement ps=connection.prepareStatement(UPDATE_NAME_BY_ID_QUERY);
			ps.setString(1, name);
			ps.setInt(2, id);
			return ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		finally
		{
			try {
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
