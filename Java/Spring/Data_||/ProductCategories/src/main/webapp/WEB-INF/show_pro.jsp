
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>product</title>
</head>
<body>

<h1>${product.name}</h1>
<h2>Categories:</h2>
<ul>
<c:forEach items="${cato}" var="c">
	<li>${c.name}</li>
</c:forEach>
</ul>

<form action="/addc" method="POST">
	<label for="newCategory">Add Category:</label> 
	<select name="newCategory">
		<c:forEach items="${Allc}" var="ca">
			<option value="${ca.id}">${ca.name}</option>
		</c:forEach>
	</select>
	<input type="hidden" name="product" value=${product.id}>
	<input type="submit" value="Add">
</form>

</body>
</html>