<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	<table border="1">
		<thead>
			<tr>
				<td>ID:</td>
				<td>Destination Address Line</td>
				<td>Number of Items</td>
			</tr>
		</thead>
		<c:forEach items="${list}" var="request">
			<tr>
				<td>${request.id}</td>
				<td>${request.destination}</td>
				<td>${request.items.size()}</td>				
				<td><a href="<spring:url value="/shipment/peakItemsList/${request.id}" /> ">
						Items To Peak</span> ${request.id}
				</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>