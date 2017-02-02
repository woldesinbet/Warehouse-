<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<body>
	<h2>List of Items to be Picked:</h2>

	<br /> ID :${request.id}
	<br /> Destination :${request.destination}
	<br />Lits Of Items To Be Peaked:
	<table border="1">
		<thead>
			<tr>
				<td>SKU ID:</td>
				<td>SKU Name</td>
				<td>SKU Location</td>
				<td>Quantitiy</td>
			</tr>
		</thead>
		<c:forEach items="${request.items}" var="item">
			<tr>
				<td>${item.sku.id}<a
					href="<spring:url value="/sku/details/${item.sku.id}" /> "> </span>
						(SKU Details)
				</a></td>
				<td>${item.sku.name}</td>
				<td>${item.sku.location.locationNumber}</td>
				<td>${item.quantity}</td>
			</tr>
		</c:forEach>
	</table>
	<form name="submitForm" method="POST" action="/shipment/pick/">
		<input type="hidden" name="requestId" value="${request.id}"> 
		<A HREF="javascript:document.submitForm.submit()">Pick</A>
	</form>
</body>
</html>