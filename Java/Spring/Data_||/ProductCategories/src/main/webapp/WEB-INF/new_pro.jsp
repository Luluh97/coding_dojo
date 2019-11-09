
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>new pro</title>
</head>
<body>

		<form:form method="POST" action="/products/new" modelAttribute="product">
    			<h4>New Product:</h4>
		    
		    <form:label path="name">Name:
		    <form:errors path="name"/><br>
		      <form:input type="text" path="name"/></form:label><br><br>
		    
		    <form:label path="description">Des:
		    <form:errors path="description"/><br>
		    <form:input type="text" path="description"/></form:label><br>
		    
		    <form:label path="price">price:
		    <form:errors path="price"/><br>
		    <form:input type="text" path="price"/></form:label><br>
		    
		    <button type=submit>Submit</button> 
    		</form:form>
    		
</body>
</html>