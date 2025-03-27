<%@ page import="com.jspider.servlet_simple_project.dto.Customer" %>
<%@ page import="com.jspider.servlet_simple_project.dao.CustomerDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomerEdit</title>
</head>
<body>
	<%
		int id=Integer.parseInt(request.getParameter("id"));
		Customer customer=new CustomerDao().getCustomerByIdDao(id);
	%>
	<form action="updateCustomer" method="post">
		<label>ID:</label><br/>
			<input type="number" value="<%= customer.getId() %>" name="id" readonly="readonly"><br/>
		<label>NAME:</label><br/>
			<input type="text" value=<%= customer.getName() %> name="name"><br/>
		<label>EMAIL:</label><br/>
			<input type="email" value="<%= customer.getEmail() %>" name="email"><br/>
		<label>PHONE:</label><br/>
			<input type="tel" value="<%= customer.getPhone() %>" name="phone"><br/>
		<label>PASSWORD:</label><br/>
			<input type="password" value="<%= customer.getPassword() %>" name="password"><br/>
		<input type="submit" value="update">
	</form>
</body>
</html>