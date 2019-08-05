<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- importing jquery tag libery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="validata.js"></script>


<style>
.error {
	color: red;
	margin-bottom: 5px;
}
</style>

<h1 style="color: maroon; text-align: center;">Enrollment For
	SSN(Social Security Number)</h1>

<h2 style="color: green; text-align: center">${msg}</h2>
<form:form action="submitSSN" modelAttribute="ssnmodel" method="POST"
	enctype="multipart/form-data" id="submit_form">
	<table  align="center" height="350" length="250"
		style="color: maroon; background-color: silver;">
		<tr>
			<td>First Name::</td>
			<td><em>*</em> <form:input path="firstName" /> <form:errors
					path="firstName" cssStyle="color:red" cssClass="errors" /></td>
		</tr>
		<tr>
			<td>Last Name::</td>
			<td><em>*</em> <form:input path="lastName" /> <form:errors
					path="lastName" cssStyle="color:red" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Date Of Birth::</td>
			<td><em>*</em><input type="text" name="dob" id="datepicker"
				placeholder="dd/mm/yyyy" /> <form:errors path="dob"
					cssStyle="color:red" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><em>*</em>
				<div class="gender">
					<form:radiobuttons path="gender" items="${glist}" />
				</div> <form:errors path="gender" cssStyle="color:red" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><form:input path="phoneNo" /> <form:errors path="phoneNo"
					cssStyle="color:red" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Select State</td>
			<td><em>*</em> <form:select path="state">
					<form:option value="NONE" label="--select--" />
					<form:options items="${states}" />
				</form:select> <form:errors path="state" cssStyle="color:red" /></td>
		</tr>
		<tr>
			<td>Select Photo</td>
			<td><em>*</em><input type="file" name="photo"></td>
		</tr>
		<tr>
			<td align="center"><input type="submit" value="Enroll"></td>
			<td align="left"><input type="reset" value="clear"></td>
		</tr>
	</table>
</form:form>
<h3 style="text-align: left;">
	<a href="home">Home</a>
</h3>
<h3>
	<a href="/allssn">view SSN Details</a>
</h3>

