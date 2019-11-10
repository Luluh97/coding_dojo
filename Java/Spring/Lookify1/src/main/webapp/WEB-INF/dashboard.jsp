<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<a href="/songs/new">Add New</a>
<a href="/search/topTen">Top Songs</a>

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Action</th>
       
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="s">
        <tr>
            <td><a href="/songs/${s.id}"><c:out value="${s.song}"/></a></td>    
            <td><c:out value="${s.rating}"/></td>
            <td><a href="/songs/remove/${s.id}">Delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<form:form action="/search/${artist1}" method="post" modelAttribute="artist1">
    <p>
        <form:input name="artist1" path="artist" />
    </p>
    <input type="submit" value="Search Artist"/>
</form:form> 