<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	font-family: Calibri;
}
input[type=submit] {
	color: #fff; 
  text-decoration: none;
  user-select: none; 
  background: rgb(238, 92, 4); 
  padding: .5em 1em; 
  outline: none; 
  border: none;
}
input[type=submit]:hover {
	background: rgb(234,119,50);
}
input[type=submit] active {
	background: rgb(152,15,0);
}
input[type=text] {
	padding:5px; border:2px solid #ccc; 
	-webkit-border-radius: 5px;
	border-radius: 5px;
	width: 180px;
}
input[type=text]:focus {
	border-color:#333; 
}

.maintable {
	padding: 10px;
	margin: 10px;
	vertical-align: top;
}
.main {
	background-color: #e7e7e7;
	color: #676767;
	border:1px dashed #333;
	width: 400px;
	float: left;
	padding-bottom: 10px;
	margin: 20px;
}
.menu {
	
	background-color: #e7e7e7;
	color: #676767;
	border:1px dashed #333;
	margin: 20px;
	float: left;
	padding: 20px;
	
}

.searchbutton {
	margin: 10px 40px;
	float: right;
}

</style>
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
			<br><br>
		<h4><c:out value="${message}"></c:out></h4> 

		</div>
	</div>
	
</body>
</html>