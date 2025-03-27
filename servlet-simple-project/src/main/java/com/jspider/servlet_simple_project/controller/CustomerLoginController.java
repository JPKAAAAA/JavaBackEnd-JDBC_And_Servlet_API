package com.jspider.servlet_simple_project.controller;

import java.io.IOException;

import com.jspider.servlet_simple_project.dao.CustomerDao;
import com.jspider.servlet_simple_project.dto.Customer;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class CustomerLoginController extends GenericServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Customer customer=new CustomerDao().getCustomerByEmailDao(email);
		
		if(customer!=null) {
			if(password.equals(customer.getPassword())) {
				req.getRequestDispatcher("customer-display.jsp").forward(req, res);
			}
			else {
				req.setAttribute("msg","invalid password");
				req.getRequestDispatcher("customer-login.jsp").forward(req,res);
			}
		}
		else {
			req.setAttribute("msg","invalid email");
			req.getRequestDispatcher("customer-login.jsp").forward(req,res);
		}
	}

}
