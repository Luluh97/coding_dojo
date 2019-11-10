<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h1>Top Ten Songs</h1>
<table>

    <tbody>
        <c:forEach items="${top}" var="t">
        <tr>
        	<td><c:out value="${t.rating}"/>-</td>
            <td><a href="/songs/${t.id}"><c:out value="${t.song}"/></a></td>
        	<td><c:out value="${t.artist}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>