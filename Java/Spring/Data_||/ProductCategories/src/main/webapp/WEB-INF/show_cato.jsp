
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title> cateogry </title>
</head>
<body>

<h1>${cato.name}</h1>
<h2>Products:</h2>
<ul>
<c:forEach items="${products}" var="p">
	<li>${p.name}</li>
</c:forEach>
</ul>

<form action="/addp" method="POST">
	<label for="newPro">Add product:</label> 
	<select name="newPro">
		<c:forEach items="${Allp}" var="p">
			<option value="${p.id}">${p.name}</option>
		</c:forEach>
	</select>
	<input type="hidden" name="cato" value=${cato.id}>
	<input type="submit" value="Add">
</form>


</body>
</html>