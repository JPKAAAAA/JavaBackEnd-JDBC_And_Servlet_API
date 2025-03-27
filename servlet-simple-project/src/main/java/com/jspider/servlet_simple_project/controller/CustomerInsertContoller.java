package com.jspider.servlet_simple_project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.jspider.servlet_simple_project.dao.CustomerDao;
import com.jspider.servlet_simple_project.dto.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class CustomerInsertContoller implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Congratulations, Your Form have been Submitted Successfully!!");
		
		PrintWriter printWriter=res.getWriter();
		res.setContentType("text/html");
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long phone=Long.parseLong(req.getParameter("phone"));
		String password=req.getParameter("password");
		
		CustomerDao customerDao=new CustomerDao();
		
		Customer customer=new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setEmail(email);
		customer.setPhone(phone);
		customer.setPassword(password);
		
		int a=customerDao.saveCustomerDao(customer);
		
		if(a!=0) {
			printWriter.write("<html><body><h5 style='color:green'>Data Registered</h5></body></html>");
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("customer-login.jsp");
			dispatcher.include(req, res);
		}
		else
		{
			printWriter.write("<html><body><h5 style='color:red'>Something Went Wrong</h5></body></html>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("customer-register.jsp");
			dispatcher.include(req, res);
		}
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
