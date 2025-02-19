package com.jspider.jdbc_prepared_statement_crud_project_architecture.controller;

import java.util.List;
import java.util.Scanner;

import com.jspider.jdbc_prepared_statement_crud_project_architecture.dao.CustomerDao;
import com.jspider.jdbc_prepared_statement_crud_project_architecture.dto.Customer;
import com.jspider.jdbc_prepared_statement_crud_project_architecture.service.CustomerService;

public class CustomerController {
	public static void main(String args[])
	{
		Scanner cin=new Scanner(System.in);
		CustomerService customerService=new CustomerService();
		boolean flag=true;
		do
		{
			CustomerDao customerDao=new CustomerDao();
			System.out.println("1. INSERT\n2. DISPLAY BY ID\n3. DISPLAY ALL\n4.DELETE BY ID\n5.UPDATE NAME BY ID\n6. EXIT");
			System.out.println("Enter your Option: ");
			int choice=cin.nextInt();
			switch(choice)
			{
			case 1:{
				System.out.println("Enter Customer ID: ");
				int id=cin.nextInt();
				System.out.println("Enter Customer Name: ");
				String name=cin.next();
				System.out.println("Enter customer E-mail: ");
				String email=cin.next();
				System.out.println("Enter Customer Phone: ");
				long phone=cin.nextLong();
				
				Customer customer=new Customer();
				customer.setId(id);
				customer.setName(name);
				customer.setEmail(email);
				customer.setPhone(phone);
				
				//int a=customerDao.saveCustomerDao(customer);
				int a=customerService.saveCustomerService(customer);
				String msg=a!=0?"Data Stored":"Date Not Stored, Something Went Wrong";
				System.out.println(msg);
			}break;
			case 2:{
				System.out.println("Enter Customer ID to Display: ");
				int SearchID=cin.nextInt();
				Customer customer=customerDao.getCustomerByIdDao(SearchID);
				System.out.println(customer);
			}break;
			case 3:{
				List<Customer> lst=customerDao.displayAllCustomerDao();
				for(Customer customer:lst)
					System.out.println(customer);
			}break;
			case 4:{
				System.out.println("Enter customer ID to delete: ");
				int id=cin.nextInt();
				int a=customerDao.deleteCustomerByIdDao(id);
				String msg=a!=0?"Data Deleted":"Data Not Deleted, Please Check the ID";
				System.out.println(msg);
			}break;
			case 5:
			{
				System.out.println("Enter Customer ID: ");
				int id=cin.nextInt();
				System.out.println("Enter Customer Name: ");
				String name=cin.next();
				int a=customerDao.updateCustomerNameByIdDao(name, id);
				String msg=a!=0?"Record Updated":"Record Updation failed, Please Check the ID";
				System.out.println(msg);
			}break;
			case 6:{
				flag=false;
			}break;
			default:{
				System.out.println("Invalid Choice");
			}
			}
		}while(flag);
		System.out.println("Program Terminated");
		cin.close();
	}
}
