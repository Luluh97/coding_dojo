<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

  <h1>Current Listing</h1>  
    <table>
    <thead>
        <tr>
            <th>Address</th>
            <th>Pool Size</th>
            <th>Cost per night</th>
            <th>Details</th>
          
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${pools}" var="pool">
        <tr>
            <td><c:out value="${pool.address}"/></td>
            <td><c:out value="${pool.size}"/></td>
            <td>$<c:out value="${pool.cost}"/></td>
            <td><a href="/host/pools/${pool.id}">edit</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<h1>New Listing</h1>
<form:form action="/pools" method="post" modelAttribute="pool">
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
    <input type="submit" value="Submit"/>
</form:form>   

  <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>