<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello_<c:out value="${name}"/></title>
</head>
<body>
<div>
<h1>Hello <c:out value="${name}"/></h1>
<p>Welcome to Spring Boots!</p>
</body>
</html>