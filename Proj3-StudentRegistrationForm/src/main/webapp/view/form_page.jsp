<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
<style>
  table{
  font-family: Calibri; 
  color:white; 
  font-size: 11pt; 
  font-style: normal;
  font-weight: bold;
  text-align:; 
  background-color: SlateBlue; 
  border-collapse: collapse; 
  border: 2px solid navy
}
</style>
</head>
<body>
	<h1 style="color: green; text-align: center;">STUDENT REGISTRATION
		FORM</h1>

	<form:form modelAttribute="studCmd" action="register.htm" >
		<table align="center" cellpadding="10">
			<tr>
				<td>FIRST NAME</td>
				<td><form:input path="firstName" maxlength="20"/>
					(max 20 characters a-z and A-Z)</td>
			</tr>
			<tr>
				<td>LAST NAME</td>
				<td><form:input path="lastName" maxlength="20"/>
				 (max 20 characters a-z and A-Z)</td>
			</tr>
			<tr>
				<td>GENDER</td>
				<td>Male <form:radiobutton path="gender" value="M"/>
					Female <form:radiobutton path="gender" value="F" />
				</td>
			</tr>
			<tr>
				<td>ADDRESS <br /> <br /> <br /></td>
				<td><form:textarea path="address" rows="4" cols="25"/></td>
			</tr>
			<tr>
				<td>EMAIL ID</td>
				<td><form:input path="email" maxlength="20"/></td>
			</tr>
			<tr>
				<td>MOBILE NUMBER</td>
				<td><form:input path="mobileNo" maxlength="10"/>
					(10 digit number)</td>
			</tr>
			<%-- <tr>
				<td>Courses Applied</td>
				<td><form:select path="courses">
				     <form:option value="Java"/>
				     <form:option value="Oracle"/>
				     <form:option value="UI"/>
				     <form:option value="Python"/>
				   </form:select>
				</td>
			</tr> --%>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit"> <input type="reset" value="Reset">
				</td>
			</tr>
		</table>
	</form:form>
	
	
	<c:if test="${!empty msg}">
	    <h1 style="color:green;text-align: center;">${msg}</h1>
	</c:if>
	<c:if test="${!empty cmd}">
	    <table>
	           <tr>
	               <td>First Name::</td>
	               <td>${cmd.firstName}</td>
	           </tr>
	           <tr>
	               <td>Last Name::</td>
	               <td>${cmd.lastName}</td>
	           </tr>
	           <tr>
	               <td>Gender::</td>
	               <td>${cmd.gender}</td>
	           </tr>
	           <tr>
	               <td>Address::</td>
	               <td>${cmd.address}</td>
	           </tr>
	           <tr>
	               <td>Email id</td>
	               <td>${cmd.email}</td>
	           </tr>
	           <tr>
	               <td>Mobile no::</td>
	               <td>${cmd.mobileNo}</td>
	           </tr>
	           <%-- <tr>
	               <td>Course Applied::</td>
	               <td><c:forEach items="courses" var="cor">
	                    ${cor}
	               </c:forEach></td>
	           </tr> --%>
	    </table>
	</c:if>
	
	
</body>
</html>