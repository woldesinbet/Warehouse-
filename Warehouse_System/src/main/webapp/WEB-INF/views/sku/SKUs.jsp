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
	<h2>List of SKUs in the stock:</h2>
	<form:form modelAttribute="location" method="post">

		<table border="1">
			<thead>
				<tr>
					<td>ID:</td>
					<td>Name</td>
					<td>Price</td>
					<td>Quantitiy</td>
					<td>Dimensions</td>
					<td>Weight</td>
					<td>Delivery Time</td>
					<td>Volume Mark</td>
					<td>Maximum Stack Floors</td>
				</tr>
			</thead>
			<c:forEach items="${skus}" var="sku">
				<tr>
					<td><a
						href="<spring:url value="/sku/details/${sku.id}" /> ">
							</span> ${sku.id}
					</a></td>
					<td>${sku.name}</td>
					<td>${sku.price}</td>
					<td>${sku.quantitiy}</td>
					<td>${sku.dimensions}</td>
					<td>${sku.weight}</td>
					<td>${sku.deliveryTime}</td>
					<td>${sku.volumeMark}</td>
					<td>${sku.maxStackFloors}</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>