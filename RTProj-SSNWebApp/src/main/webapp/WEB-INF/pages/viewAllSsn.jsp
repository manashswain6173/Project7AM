<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
</head>
<body>

<h1 style="color: maroon; text-align: center;">All SSN(Social
	Security Number) Enrollment Details</h1>

<c:if test="${!empty listdto }">
	<table id="example" class="table table-striped table-bordered" style="width:100%;text-align: center;">
		<tr>
			<th>SSN NO</th>
			<th>FIRST NAME</th>
			<th>LAST NAME</th>
			<th>DOB</th>
			<th>GENDER</th>
			<th>PHONE NO</th>
			<th>STATE_NAME</th>
		</tr>
		<c:forEach items="${listdto}" var="dto">
			<tr>
				<td width="80" height="30">${dto.ssnNo}</td>
				<td>${dto.firstName}</td>
				<td>${dto.lastName}</td>
				<td>${dto.dob}</td>
				<td>${dto.gender}</td>
				<td>${dto.phoneNo}</td>
				<td>${dto.state}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<a href="/home">Home</a>
</body>
</html>
