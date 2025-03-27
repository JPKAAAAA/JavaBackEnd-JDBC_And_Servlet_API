package com.jspider.servlet_simple_project.controller;

import java.io.IOException;

import com.jspider.servlet_simple_project.dao.CustomerDao;
import com.jspider.servlet_simple_project.dto.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(value="/updateCustomer")
public class CustomerUpdateController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
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
		
		int a=customerDao.updateCustomerByIdDao(customer);
		
		if(a!=0)
		{
			res.sendRedirect("customer-display.jsp");
		}
		else
		{
			System.out.println("Check Your Code");
		}
	}
}
