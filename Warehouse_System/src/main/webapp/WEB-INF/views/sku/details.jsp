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

	<h2>Stock Keeping Unit Request detail:</h2>
	<br /> Name :${sku.name}
	<br /> Price :${sku.price}
	<br /> Quantitiy :${sku.quantitiy}
	<br /> Dimensions :${sku.dimensions}
	<br /> Weight :${sku.weight}
	<br /> Delivery Time :${sku.deliveryTime}
	<br /> Volume Mark :${sku.volumeMark}
	<br /> Max Stack Floors :${sku.maxStackFloors}
	<br /> Max Stack Floors :${sku.desribtion}
	<br /> Location Number :${sku.location.locationNumber}	
	<br />

</body>
</html>