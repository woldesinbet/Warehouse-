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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"> </script>
<script>
	function ship(event){
		var reqId = $(event.target).data('id');
		if (confirm("Are you sure you want to ship this request? ")) {
			var data = {
				'id' : reqId,
			};
			$
					.ajax({
						async : false,
						type : "POST",
						url : "/shipment/ship",
						data : data,
						timeout :7000,
						success : function(
								data) {
							alert("Succesfully Shipped request: " + $(event.target).data("id"));
							$(event.target).closest('tr').remove();		   							
						},
						error : function(
								xhr,
								textStatus,
								errorThrown) {
							alert(textStatus);
						}
					});

		}
	return false;	
	}
	</script>
</head>

<body>

	<table id="tbRequests" border="1">
		<thead>
			<tr>
				<td>ID:</td>
				<td>Destination Address Line</td>
				<td></td>
			</tr>
		</thead>
		<c:forEach items="${list}" var="request">
			<tr>
				<td>${request.id}</td>
				<td>${request.destination}</td>
				<td>${request.id}</td>
				<td><button data-id="${request.id}"
						onclick=" return ship(event,${request.id})" class="ship">Ship</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>