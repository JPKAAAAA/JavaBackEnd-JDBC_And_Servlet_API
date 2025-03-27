<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomerRegister</title>
</head>
<body>
	<form action="insertCustomer" method="get" enctype="">
		<label>ID:</label><br/>
		<input type="number" placeholder="enter customer id" name="id"><br/>
		<label>NAME:</label><br/>
		<input type="text" placeholder="enter customer name" name="name"><br/>
		<label>EMAIL:</label><br/>
		<input type="email" placeholder="enter customer e-mail" name="email"><br/>
		<label>PHONE:</label><br/>
		<input type="tel" placeholder="enter customer phone" name="phone"><br/>
		<label>PASSWORD:</label><br/>
		<input type="password" placeholder="enter password" name="password"><br/><br/>
		<!--<label>INPUT:</label>
		<input type="file" name="image"><br/>-->
		<input type="submit" value="register">
	</form>
</body>
</html>