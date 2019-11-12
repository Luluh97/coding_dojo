<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
<div>
    <h1>Welcome  <c:out value="${currentUser.firstname}"></c:out></h1>
    
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</div>

<h3>First Name: </h3><c:out value="${currentUser.firstname}"></c:out>
<h3>Last Name: </h3><c:out value="${currentUser.lastname}"></c:out>
<h3>Email: </h3><c:out value="${currentUser.username}"></c:out>
<h3>Sign up date: </h3><c:out value="${currentUser.createdAt}"></c:out>


</body>
</html>