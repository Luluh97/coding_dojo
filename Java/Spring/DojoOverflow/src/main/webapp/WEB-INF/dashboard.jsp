<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<h1>All Questions</h1>
<table>
    <thead>
        <tr>
            <th>Question</th>
            <th>Tag</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${questions}" var="q">
        <tr>
            <td><a href="/questions/${q.id}"><c:out value="${q.question}"/></a></td>
			<td><c:forEach items="${q.tag}" var="t">${t.subject} </c:forEach></td></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/questions/new">New Question</a>