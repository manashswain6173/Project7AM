<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <c:if test="${!empty msg}">
       <h1>"${msg}"</h1>
    </c:if>
    <form action="/submitForm" method="get" id="submit_form">
    Enter Email::<input type="text" name="email">
    <br><span id="errEmail" style="color: red;"></span>
    <input type="submit" value="submit">
    </form>