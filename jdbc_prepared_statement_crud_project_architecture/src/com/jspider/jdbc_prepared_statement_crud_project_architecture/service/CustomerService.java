package com.jspider.jdbc_prepared_statement_crud_project_architecture.service;

import com.jspider.jdbc_prepared_statement_crud_project_architecture.dao.CustomerDao;
import com.jspider.jdbc_prepared_statement_crud_project_architecture.dto.Customer;

public class CustomerService {
	CustomerDao customerDao=new CustomerDao();
	public int saveCustomerService(Customer customer)
	{
		int id=customer.getId();
		if(id>9999999 && id<100000000)
			return customerDao.saveCustomerDao(customer);
		else
		{
			System.out.println("ID must be exactly 8 digit long");
			return 0;
		}
	}
}
