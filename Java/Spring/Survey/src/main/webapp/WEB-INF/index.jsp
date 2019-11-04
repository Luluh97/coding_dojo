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
	<form action="/info" method="POST">
	    <p>Your Name: <input id ='name' type="text" name="name"></p>
	    <p>Dojo Location: 
	                    <select id='location' name="location">
	                            <option value="San Jose">San Jose</option>
	                            <option value="Los Angeles">Los Angeles</option>
	                            <option value="Arizona">Arizona</option>
	                            <option value="San Francisco">San Francisco</option>
	                    </select>
	            </p>
	            <p>Favorite Language: 
	                    <select id ='language' name="language">
	                            <option value="Python">Python</option>
	                            <option value=" JavaScript">JavaScript</option>
	                            <option value="C++">C++</option>
	                            <option value="C#">C#</option>
	                    </select>
	            </p>
	            <p> Comment (Optional): <input id='comment' type="text" name="comment"></p>
	            <button id="submit" type="submit">Button</button>
	</form>

</body>
</html>