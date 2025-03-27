<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomerLogin</title>
</head>
<body>
	<%
		String message=(String)request.getAttribute("msg");
	if(message!=null) {
	%>
	<h4 style="color:red"><%=message %></h4>
	<% } %>
	<form action="loginCustomer" method="get">
		<label>USERNAME:</label><br/>
		<input type="email" placeholder="enter customer email" name="email"><br/>
		<label>PASSWORD:</label><br/>
		<input type="password" placeholder="enter customer password" name="password"><br/><br/>
		<input type="submit" value="login">
	</form>
</body>
</html>