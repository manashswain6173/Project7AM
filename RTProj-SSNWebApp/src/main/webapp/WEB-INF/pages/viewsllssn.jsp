<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<h1 style="color: maroon; text-align: center;">All SSN(Social
	Security Number) Enrollment Details</h1>

<c:if test="${!empty listdto }">
	<!-- <div class="table-responsive"> -->
	<table id="mytable" class="table table-striped">
		<tr>
			<th class="th-sm">SSN NO</th>
			<th class="th-sm">FIRST NAME</th>
			<th class="th-sm">LAST NAME</th>
			<th class="th-sm">DOB</th>
			<th class="th-sm">GENDER</th>
			<th class="th-sm">PHONE NO</th>
			<th class="th-sm">STATE_NAME</th>
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