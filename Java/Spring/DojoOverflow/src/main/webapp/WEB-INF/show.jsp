<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
 
<h1><c:out value="${question.question}"/></h1>
<h2>Tags: <small><c:forEach items="${question.tag}" var="t">${t.subject} </c:forEach>
</small>
</h2>



<h2>Add your answer</h2>


<form:form modelAttribute="answer1" method="post" action="/questions/${question.id}">
    <form:label path="text">
        <form:errors path="text"/>
        <form:textarea path="text"/>
    </form:label>
    <button>Answer it!!</button>
</form:form>

<table>
    <thead>
        <tr>
            <th>Answer</th>
      
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${question.answers}" var="a">
        <tr>
            <td><c:out value="${a.text}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>