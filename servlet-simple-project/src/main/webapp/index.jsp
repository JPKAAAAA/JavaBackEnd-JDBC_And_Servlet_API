<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Application</title>
</head>
<body>
	<h4>Welcome to Servlet API</h4>
	
	<%
		int a=10;
		System.out.println("a: "+a);    //on console
		out.print(a);    //on browser
	%>
	
	<h4 style="color: red"><%out.print(a); %></h4>
	<h4 style="color: green"><%=a %></h4>
	
	<%for(int i=1;i<=10;i++) {
		if(i%2==0) {
	%>
	<h3 style="color:cyan"><%=i %></h3>
	<%
		}
		else {
	%>
	<h3 style="color:purple"><%=i %></h3>
	<% } }%>
</body>
</html>