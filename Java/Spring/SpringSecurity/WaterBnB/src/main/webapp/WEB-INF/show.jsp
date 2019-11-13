<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<td><c:out value="${pool.address}"/></td>
<td><c:out value="${pool.description}"/></td>
<td><c:out value="${pool.size}"/></td>
<td>$<c:out value="${pool.cost}"/></td>
<a href="/review/${pool.id}">Leave a review</a>
<p>
        <c:forEach items="${reviews}" var="review">    
            Rating: <c:out value="${review.rate}"/>/5
            <c:out value="${review.review1}"/>
            _________________________________________
        </c:forEach>
   </p>     
        
            
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>