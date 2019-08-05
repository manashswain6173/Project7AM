<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<form method="get" action="getState">
<table align="center">
	<tr>
	    <th>Enter your SSN Number:</th>
		<th><input type="text" name="ssnNo"></th>
		<th><input type="submit" value="submit"></th>
    </tr>
    
</table>
</form>
<h1 style="text-align: center;">
	Your are belongs to <span style="color: green;">${stateName}</span>
</h1>