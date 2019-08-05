<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <h1 style="color: maroon;text-align: center;">All SSN(Social Security Number) Enrollment Details</h1>
    
<c:if test="${!empty listdto }">
    <table border="1" cellpadding='0' cellspacing='0' align="center" height="350" length="250" style="text-align: center;">
        <tr>
           <th width="70" height="25">SSN NO</th>
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