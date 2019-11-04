<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey Index</title>
</head>
<body>

	<c:out value="${name}"/>
	<c:out value="${location}"/>
	<c:out value="${language}"/>
	<c:out value="${comment}"/>
	<a href="/">Go back</a>
	
</body>
</html>