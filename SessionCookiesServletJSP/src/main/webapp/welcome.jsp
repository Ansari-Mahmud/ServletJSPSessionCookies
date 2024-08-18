<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<form action = "LogoutServlet" method="GET">
		<h2>Welcome, <%= session.getAttribute("username") %></h2>
    	<a href="index.jsp">Logout</a>
	</form>
</body>
</html>