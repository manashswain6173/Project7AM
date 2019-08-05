<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
 <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script> 
<!-- <script type="text/javascript" src="validata.js"></script> -->
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
 .error {
  color: red;
  margin-bottom: 5px;
}
label.error { 
   float: none; color: red; 
   padding-left: .5em;
   vertical-align: top; 
   display:block;
}​
</style>
</head>
<body>
	<h1 style="color: green; text-align: center;">STUDENT REGISTRATION
		FORM</h1>

	<form:form modelAttribute="studCmd" action="register" id="submit_form">
		<table align="center" cellpadding="10">
			<tr>
				<td>FIRST NAME</td>
				<td><form:input path="firstName" maxlength="20"/><form:errors path="firstName" cssStyle="color:red"/>
					(max 20 characters a-z and A-Z)</td>
			</tr>
			<tr>
				<td>LAST NAME</td>
				<td><form:input path="lastName" maxlength="20"/><form:errors path="lastName" cssStyle="color:red"/>
				 (max 20 characters a-z and A-Z)</td>
			</tr>
			<tr>
			    
				<td>GENDER</td>
				<td><div class="gender"><form:radiobuttons path="gender" items="${gList}" id="gender"/></div></td>
			</tr>
			<tr>
				<td>ADDRESS <br /> <br /> <br /></td>
				<td><form:textarea path="address" rows="4" cols="25"/><form:errors path="address" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td>EMAIL ID</td>
				<td><form:input path="email" maxlength="20"/><form:errors path="email" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td>MOBILE NUMBER</td>
				<td><form:input path="mobileNo" maxlength="10"/><form:errors path="mobileNo" cssStyle="color:red"/>
					(10 digit number)</td>
			</tr>
				<td>Courses Applied</td>
				<td><form:checkboxes items="${couresList}" path="courses"/></td>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit"> <input type="reset" value="Reset">
				</td>
			</tr>
		</table>
	</form:form>
	
	
	<c:if test="${!empty msg}">
	    <h1 style="color:green;text-align: center;">${msg}</h1><h3>${profile}</h3>
	</c:if>
	<c:if test="${!empty result}">
	    <table align="center">
	           <tr>
	               <td>Registration Number::</td>
	               <td>${result.regNo}</td>
	           </tr>
	           
	           <tr>
	               <td>First Name::</td>
	               <td>${result.firstName}</td>
	           </tr>
	           <tr>
	               <td>Last Name::</td>
	               <td>${result.lastName}</td>
	           </tr>
	           <tr>
	               <td>Gender::</td>
	               <td>${result.gender}</td>
	           </tr>
	           <tr>
	               <td>Address::</td>
	               <td>${result.address}</td>
	           </tr>
	           <tr>
	               <td>Email id</td>
	               <td>${result.email}</td>
	           </tr>
	           <tr>
	               <td>Mobile no::</td>
	               <td>${result.mobileNo}</td>
	           </tr>
	           <tr>
	               <td>Course Applied::</td>
	               <td><c:forEach items="${result.courses}" var="cor">
	                    ${cor}
	               </c:forEach></td>
	           </tr>
	    </table>
	</c:if>
	

	
</body>
</html>