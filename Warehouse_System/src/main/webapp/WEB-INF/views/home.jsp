<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<h2>Well Come to Home Page</h2>
	<ul>
		<sec:authorize access="hasRole('ROLE_STORE_MANAGER')">
			<li><a href="<spring:url value="/sku/SKUCreationRequests" /> ">
					</span> SKU Creation Requests List
			</a></li>
			<li><a href="<spring:url value="/sku/SKUs" /> "> </span> List of
					SKU List in warehouse
			</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_WAREHOUSE_MANAGER')">
			<li><a href="<spring:url value="/location/createLocation" /> ">
					</span> Add Location
			</a></li>
			<li><a href="<spring:url value="/location/locations" /> "> </span>
					View Locations
			</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_ORDER_PICKER')">
			<li><a href="<spring:url value="/shipment/peakRequestsList" /> ">
					</span> List of Shipment Requests To be picked
			</a></li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_CLERK')">
			<li><a href="<spring:url value="/shipment/shipRequestsList" /> ">
					</span> List of Shipment Requests To be shipped
			</a></li>
		</sec:authorize>

	</ul>
</body>
</html>