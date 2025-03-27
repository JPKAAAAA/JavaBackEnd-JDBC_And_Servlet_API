package com.jspider.servlet_simple_project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.servlet_simple_project.connection.CustomerConnection;
import com.jspider.servlet_simple_project.dto.Customer;

public class CustomerDao {
	Connection connection=CustomerConnection.getCustomerConnection();
	
	final String INSERT_CUSTOMER_QUERY="insert into customer(id,name,email,phone,password) values(?,?,?,?,?)";
	final String DISPLAY_CUSTOMER_BY_ID_QUERY="Select * from customer where id=?";
	final String DISPLAY_ALL_CUSTOMER_QUERY="Select * from customer";
	final String DISPLAY_EMAIL_PASSWORD_BY_EMAIL_QUERY="select email,password from customer where email=?";
	final String UPDATE_CUSTOMER_DETAILS_BY_ID_QUERY="update customer set name=?, email=?, phone=?, password=? where id=?";
	
	public int saveCustomerDao(Customer customer) {
		try {
			PreparedStatement ps=connection.prepareStatement(INSERT_CUSTOMER_QUERY);
			ps.setInt(1, customer.getId());
			ps.setString(2,customer.getName());
			ps.setString(3, customer.getEmail());
			ps.setLong(4, customer.getPhone());
			ps.setString(5, customer.getPassword());
			return ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		finally {
			try {
				connection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public Customer getCustomerByIdDao(int id) {
		try {
			PreparedStatement ps=connection.prepareStatement(DISPLAY_CUSTOMER_BY_ID_QUERY);
			ps.setInt(1, id);
			ResultSet set=ps.executeQuery();
			if(set.next())
			{
				int id1=set.getInt("id");
				String name=set.getString("name");
				String email=set.getString("email");
				long phone=set.getLong("phone");
				
				Customer customer=new Customer();
				customer.setId(id1);
				customer.setName(name);
				customer.setEmail(email);
				customer.setPhone(phone);
				return customer;
			}
			else
			{
				System.out.println("Given ID Not Found");
				return null;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				connection.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public Customer getCustomerByEmailDao(String email) {
		try {
			PreparedStatement ps=connection.prepareStatement(DISPLAY_EMAIL_PASSWORD_BY_EMAIL_QUERY);
			ps.setString(1,email);
			ResultSet set=ps.executeQuery();
			if(set.next()) {
				String email1=set.getString("email");
				String password=set.getString("password");
				
				Customer customer=new Customer();
				customer.setEmail(email1);
				customer.setPassword(password);
				return customer;
			}
			else
			{
				System.out.println("Given Email Not Found");
				return null;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				connection.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public int updateCustomerByIdDao(Customer customer) {
		try {
			PreparedStatement ps=connection.prepareStatement(UPDATE_CUSTOMER_DETAILS_BY_ID_QUERY);
			
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setLong(3, customer.getPhone());
			ps.setString(4, customer.getPassword());
			ps.setInt(5, customer.getId());
			
			return ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
		finally {
			try {
				connection.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public int deleteCustomerByIdDao(int id) {
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
	}
	public List<Customer> displayAllCustomerDao() {
		try {
			PreparedStatement ps=connection.prepareStatement(DISPLAY_ALL_CUSTOMER_QUERY);
			ResultSet set=ps.executeQuery();
			List<Customer> customers=new ArrayList<Customer>();
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
			return null;
		}
		finally {
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
