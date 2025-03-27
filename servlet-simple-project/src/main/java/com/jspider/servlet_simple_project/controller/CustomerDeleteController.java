package com.jspider.servlet_simple_project.controller;

import java.io.IOException;

import com.jspider.servlet_simple_project.dao.CustomerDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(value="/delete")
public class CustomerDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer id=Integer.parseInt(req.getParameter("id"));
		int a=new CustomerDao().deleteCustomerByIdDao(id);
		
		if(a!=0) 
		{
			res.sendRedirect("customer-display.jsp");
		}
		else
			System.out.println("Data Not Deleted, Something Went Wrong");
	}

}
