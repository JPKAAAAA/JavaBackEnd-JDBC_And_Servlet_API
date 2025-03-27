<%@ page import="com.jspider.servlet_simple_project.dto.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jspider.servlet_simple_project.dao.CustomerDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LandingPage</title>
<style type="text/css">
	a {
		text-decoration: none;
	}
	#tablebdy {
	    font-family: Arial, Helvetica, sans-serif;
	    border: 1px solid #ddd;
	    border-collapse: collapse; 
	    width: 50%;
	}
	#tablebdy th{
		height:30px;
	    padding-top: 12px;
	    padding-bottom: 12px;
	    text-align: left;
	    background-color: #04AA6D;
	    color: white;
	}
	#tablebdy td, #tablebdy th{
	    border: 1px solid #ddd;
	    padding: 8px;
	}
	#tablebdy tr:nth-child(even){
    	background-color: #f2f2f2
	}
	#tablebdy tr:hover{
    	background-color: #ddd;
	}
</style>
</head>
<body>
	<h4>Welcome, You have Logged-In Successfully!!</h4>
	<%
		List<Customer> customers=new CustomerDao().displayAllCustomerDao();
	%>
	<table id="tablebdy">
		<caption>Customer Table</caption>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PHONE</th>
			<th colspan="2">ACTION</th>
		</tr>
		<%
		for(Customer customer:customers) {
		%>
		<tr>
			<td><%= customer.getId() %></td>
			<td><%= customer.getName() %></td>
			<td><%= customer.getEmail() %></td>
			<td><%= customer.getPhone() %></td>
			<td><a href="delete?id=<%= customer.getId()%>" style="color: red">Delete</a></td>
			<td><a href="customer-edit.jsp?id=<%=customer.getId()%>" style="color: green">Update</a></td>
		</tr>
		<%}%>
	</table>
</body>
</html>