<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<a href="/songs/new">Add New</a>
<a href="/search/topTen">Top Songs</a>

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${art}" var="a">
        <tr>
            <td><c:out value="${a.song}"/></td>
            <td><c:out value="${a.rating}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
