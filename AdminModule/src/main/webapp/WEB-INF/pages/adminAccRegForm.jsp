<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>
<script type="text/javascript" src="validata.js"></script>


<c:if test="${!empty msg}">
	<h1>${msg}</h1>
</c:if>
<h1></h1>
<form:form action="submitForm" modelAttribute="admin" method="POST"
	id="submit_form">
	<table align="center" height="350" length="250"
		style="color: maroon; background-color: silver;">
		<tr>
			<td>First Name::</td>
			<td><form:input path="firstName" /> <form:errors
					path="firstName" cssStyle="color:red" cssClass="errors" /></td>
		</tr>
		<tr>
			<td>Last Name::</td>
			<td><form:input path="lastName" /> <form:errors path="lastName"
					cssStyle="color:red" cssClass="error" /></td>
		</tr>

		<tr>
			<td>Gender</td>
			<td>
				<div class="gender">
					<form:radiobuttons path="gender" items="${genderList}" />
				</div> <form:errors path="gender" cssStyle="color:red" cssClass="error" />
			</td>
		</tr>
		<tr>
			<td>Email::</td>
			<td><form:input type="text" path="email" id="email" /> <span
				id="emailMsg" style="color: red"></span></td>
		</tr>
		<tr>
			<td>password::</td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td>Date Of Birth::</td>
			<td><input type="text" name="dob" id="datepicker"
				placeholder="dd/mm/yyyy" /> <form:errors path="dob"
					cssStyle="color:red" cssClass="error" /></td>
		</tr>

		<tr>
			<td>SSN No::</td>
			<td><form:input path="ssn" /></td>
		</tr>
		<tr>
			<td>Mobile Number</td>
			<td><form:input path="mobileNo" /> <form:errors path="mobileNo"
					cssStyle="color:red" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Select Role</td>
			<td><form:select path="roles" multiple="false">
					<form:option value="" label="--select--" />
					<form:options items="${rolesList}" />
				</form:select> <form:errors path="roles" cssStyle="color:red" /></td>
		</tr>
		<tr>
			<td align="center"><input type="submit" value="Enroll"
				id="submitbtn"></td>
			<td align="left"><input type="reset" value="clear"></td>
		</tr>
	</table>
</form:form>