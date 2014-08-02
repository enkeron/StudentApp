<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
				<input type="submit" value="Remove Student">
			</form>
			<br>
			<form action="edit" method="get">
				<input type="submit" value="Edit Student" >
			</form>
		</div>
		
		
		<div class="main" align="center">
			<h2>Edit Student</h2>
			
			<form action="search" method="POST">
				Numer albumu: <input type="text" name="nrAlbumu" value="${nrAlbumu}"/> <br> 
				<div class="searchbutton">
					<input type="submit" value="Search by NrAlbumu">
				</div>
			</form>
			<br><br>
			
			<h4><c:out value="${message}"></c:out></h4> 
			<div class="label">
			<form action="edit" method="POST" class="form">
					<form:form modelAttribute="student">
						
						<label for="nrAlbumuInput">NrAlbumu: </label><br>
						<form:input path="nrAlbumu" id="nrAlbumuInput" readonly="readonly"/><br>
						
						<label for="nameInput">Name: </label><br>
						<form:input path="name" id="nameInput" /><br>
						<label for="surnameInput">Surname: </label><br>
						<form:input path="surname" id="surnameInput" /><br>
						<label for="adressInput">Adress: </label><br>
						

						<label for="adressInput">City: </label><br>
						<form:input path="adress.city" id="cityInput" /><br>
						<br>
						
						<label for="adressInput">Street: </label><br>
							<form:input path="adress.street" id="streetInput" />
						<br>
						<label for="adressInput">House: </label><br>
						<form:input path="adress.house" id="houseInput" /><br>
						<br>
						<label for="adressInput">Flat: </label><br>
						<form:input path="adress.flat" id="flatInput" /><br>
											



						<label for="facultyInput">Faculty: </label><br>
						<form:input path="faculty.faculty" id="facultyInput" />
						<br /><br>

						<input type="submit" value="Edit Student">
					</form:form>
					
			</form>
				
				</div>
				<c:out value="${editmessage}"></c:out>
		

		</div>
	</div>
	
</body>
</html>