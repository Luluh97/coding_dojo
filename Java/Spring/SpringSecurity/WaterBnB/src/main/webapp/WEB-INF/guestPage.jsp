<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

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
            <td><a href="/pools/${pool.id}">See more</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

  <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>