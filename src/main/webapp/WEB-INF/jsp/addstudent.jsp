<%@ page isELIgnored="false"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  	
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style type="text/css">

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
				<input type="submit" value="Edit Student">
			</form>
		</div>
		
		
		<div class="main" align="center">
			<h2>Add new Student</h2>
			<div class="green">
			<c:out value="${message}"></c:out>
			
			</div>
			<br>
			<form action="addOne" method="POST" class="form">
				<form:form modelAttribute="student" >
				<div class="label">
						
							
							<label for="nrAlbumuInput">NrAlbumu: </label>
							<br>
							<form:input path="nrAlbumu" id="nrAlbumuInput" readonly="readonly"/><br>
							<form:errors path="nrAlbumu" class="error" /> <br>
							<label for="nameInput"  >Name: </label>
							
							<br>
							<form:input path="name" id="nameInput" /><br>
							<form:errors path="name" class="error"></form:errors>
							<br>
							<label for="surnameInput">Surname: </label>
							<br>
							<form:input path="surname" id="surnameInput" /><br>
							<form:errors path="surname" class="error"></form:errors>
							<br>
							
							<label for="adressInput">City: </label><br>
							<form:input path="adress.city" id="cityInput" /><br>
							<form:errors path="adress.city" class="error"></form:errors>
							<br>
							
							<label for="adressInput">Street: </label><br>
							<form:input path="adress.street" id="streetInput" /><br>
							<form:errors path="adress.street" class="error"></form:errors>
							<br>
							
							<label for="adressInput">House: </label><br>
							<form:input path="adress.house" id="houseInput" /><br>
							<form:errors path="adress.house" class="error"></form:errors>
							
							<br>
							
							<label for="adressInput">Flat: </label><br>
							<form:input path="adress.flat" id="flatInput" /><br>
							<form:errors path="adress.flat" class="error"></form:errors>
							<br>
							
							<br>
							<label for="facultyInput">Faculty: </label>
							<br>
								<select id="faculty" name="faculty"
								onchange="alert(quantity.value)" >
									<option value="weeia">WEEiA</option>
									<option value="ftims">FTIMS</option>
									<option value="ife">IFE</option>
								</select>
							<br /><br>
							<input type="submit" value="Add this Student">
					</div>
					
				</form:form>
				
			</form>
				



		</div>
		
	</div>
</body>
</html>