<%@ tag isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="student" required="true"
	type="net.start.amg.model.Student"%>
	
			Imie:<c:out value="${student.getName()}" /><br>
		Nazwisko: <c:out value="${student.getSurname()}" /><br>
		Numer Albumu: <c:out value="${student.getNrAlbumu()}" /><br>
		Address: <br> <c:out value="${student.getAdress().getCity() }"></c:out>
						<c:out value="${student.getAdress().getStreet() }" />
						<c:out value="${student.getAdress().getHouse() }" />
						<c:out value="${student.getAdress().getFlat() }" />
						<br>
		Faculties: <c:out value="${student.getFaculty().faculty}"></c:out>