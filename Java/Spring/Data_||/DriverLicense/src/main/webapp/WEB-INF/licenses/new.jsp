<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
 
<h1>New License</h1>
<form:form action="/licenses/new" method="post" modelAttribute="license">

 	<p>
 	<form:label path="person">
		    <form:errors path="person"/>
		    <form:select path="person">
		    		<c:forEach items="${persons}" var="person">
					<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
				</c:forEach>
	</form:select></form:label>
 	</p>
  
    <p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
  <p>
        <form:label path="expirationDate">Expiration Date</form:label>
        <form:errors path="expirationDate"/>
        <form:input path="expirationDate"/>
    </p>   
    <input type="submit" value="Submit"/>
</form:form>   