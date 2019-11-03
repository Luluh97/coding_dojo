<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Great Number Game</title>
</head>
<body>
	<h1>Welcome to the Great Number Game!</h1>
    <p>I am thinking of a number between 1 and 100</p>
    <p>Take a guess</p>
    <form action="Home" method="post">
        <input type="number" name="answer">
        <input type="submit" name="submit" value="submit">
    </form>
    
<c:out value="${random_num}"/>
</body>
</html>