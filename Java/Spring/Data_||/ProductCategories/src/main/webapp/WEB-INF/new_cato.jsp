
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<title>new cateogray</title>
</head>
<body>
<div class="form">
	<form:form method="POST" action="/catos/new" modelAttribute="categories">
    			<h4>New Categoray:</h4>
		    
		    <form:label path="name">Name:
		    <form:errors path="name"/><br>
		      <form:input type="text" path="name"/></form:label><br><br>
		    
		    
		    <button type=submit>Submit</button> 
    		</form:form>
    		</div>
</body>
</html>