<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WaterBnB</title>
</head>
<body>

Review of <c:out value="${pool.address}"/>

<form:form action="/reviews" method="post" modelAttribute="review">
    <p>
        <form:label path="review1">Review</form:label>
        <form:errors path="review1"/>
        <form:textarea path="review1"/>
    </p>
  	<p>
        <form:label path="rate">rate</form:label>
        <form:errors path="rate"/>
        <form:input path="rate" type="number"/>
    </p>    
    <input type="submit" value="Submit Review"/>
</form:form> 

</body>
</html>