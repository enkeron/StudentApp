<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"	type="text/css" /> 
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add new Student</title>
</head>
<body>

		
	
<div class="maindiv">
		
		<div class="menu">
			<form action="home">
				<input type="submit" value="Add new Student">
			</form>
			<br>
			<form action="print" method="get">
				<input type="submit" value="View List of Students">
			</form>
			<br>
			<form action="remove" method="get">
				<input type="submit" value="Remove Student" >
			</form>
			<br>
			<form action="edit" method="get">
				<input type="submit" value="Edit Student" >
			</form>
		</div>
		
		
		<div class="main" align="center">
			<h2>Remove Student</h2>
			
			<form action="remove" method="POST">
				Numer albumu: <input type="text" name="nrAlbumu" /> <br> 
				<div class="searchbutton">
					<input type="submit" value="Remove Student">
				</div>
			</form>
			<br><br><br>
			<div class="green">
				<c:out value="${message}"></c:out> 
			</div>
			<br>
		</div>
	</div>
	
</body>
</html>