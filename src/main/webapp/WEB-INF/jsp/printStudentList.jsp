<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="AMG" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"	type="text/css" /> 

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="maindiv">
	
		<div class="menu">
			<form action="home">
				<input type="submit" value="Add new Student">
			</form>
			<br>
			<form action="print" method="get">
				<input type="submit" value="View List of Students"
					disabled="disabled">
			</form>
			<br>
			<form action="remove" method="get">
				<input type="submit" value="Remove Student">
			</form>
			<br>
			<form action="edit" method="get">
				<input type="submit" value="Edit Student">
			</form>
		</div>
		<div class="main" align="center">
			<h2>List of Students</h2>
			<table cellpadding="3px">
				<tr>
				
				<tr>
					<td colspan="2" align="center" >
					<c:forEach items="${students}"	var="element">
							<div class="elementborder">
							<AMG:printList student="${element}"></AMG:printList>
							</div>
							
						</c:forEach></td>
				</tr>
			</table>
		</div>
		</div>
	
</body>
</html>