<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/WebContent/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<% String result = (String) session.getAttribute("result");
	if(result == "correct"){ %>
		<div id="correct">Correct</div>
	<% } 
	
	else if(result == "too low"){%>
		<div id="incorrect">Too Low!</div>
	<% } 
	
	else if(result == "too high"){ %>
		<div id="incorrect">Too High!</div>
	<% } %>
</body>
</html>