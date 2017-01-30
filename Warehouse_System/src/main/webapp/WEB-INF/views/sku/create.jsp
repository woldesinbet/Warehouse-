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

	<h2>Stock Keeping Unit Request detail:</h2>
	<br /> Name :${skucr.name}
	<br /> Price :${skucr.price}
	<br /> Quantitiy :${skucr.quantitiy}
	<br />


	<form:form modelAttribute="sku" method="post">
		<table>
			<tr>
				<td>Dimensions:</td>
				<td><form:input id="dimensions" name="dimensions"
						path="dimensions" type="text" /></td>
				<td><form:errors path="dimensions" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<td>Weight:</td>
				<td><form:textarea id="weight" path="weight" /></td>
				<td><form:errors path="weight" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<td>Delivery Time:</td>
				<td><form:input type = "date" id="deliveryTime" path="deliveryTime" /></td>
				<td><form:errors path="deliveryTime" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<td>Volume Mark:</td>
				<td><form:textarea id="volumeMark" path="volumeMark" /></td>
				<td><form:errors path="volumeMark" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<td>Max Stack Floors:</td>
				<td><form:textarea id="maxStackFloors" path="maxStackFloors" /></td>
				<td><form:errors path="maxStackFloors" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<td>Location:</td>
				<td><form:select
						path="location" items="${locations}" itemValue="id"
						itemLabel="LocationNumber" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>