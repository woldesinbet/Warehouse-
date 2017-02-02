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


	<form:form modelAttribute="location" method="post">
		<table>
			<tr>
				<td>Building:</td>
				<td><form:input id="building" name="building" path="building"
						type="text" /></td>
				<td><form:errors path="building" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<td>Aisle:</td>
				<td><form:textarea id="aisle" path="aisle" /></td>
				<td><form:errors path="aisle" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<td>PalletRack:</td>
				<td><form:textarea id="palletRack" path="palletRack" /></td>
				<td><form:errors path="palletRack" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<td>floorStack:</td>
				<td><form:textarea id="floorStack" path="floorStack" /></td>
				<td><form:errors path="floorStack" cssStyle="color:red;" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>