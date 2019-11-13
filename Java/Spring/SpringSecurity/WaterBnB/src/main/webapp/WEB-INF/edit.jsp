<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<h1>Edit Pool</h1>
<form:form action="/edit/${pool.id}" method="post" modelAttribute="pool">
    <p>
        <form:label path="address">Address</form:label>
        <form:errors path="address"/>
        <form:input path="address"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="cost">Cost</form:label>
        <form:errors path="cost"/>
        <form:input path="cost" type="number"/>
    </p>
    <p>
		<form:label path="size">Size</form:label>
		<form:errors path="size"></form:errors>
		<form:select path="size">
			<form:options items="${sizes}"/>
		</form:select>
    </p>    
    <input type="submit" value="Save Changes"/>
</form:form> 