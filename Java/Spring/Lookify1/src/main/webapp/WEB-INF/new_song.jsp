<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
 
<h1>New Song</h1>
<form:form action="/songs/new" method="post" modelAttribute="songs">
    <p>
        <form:label path="song">Song</form:label>
        <form:errors path="song"/>
        <form:input path="song"/>
    </p>
    <p>
        <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:input path="artist"/>
    </p>

 	<p>
        <form:label path="rating">Rating</form:label>
        <form:errors path="rating"/>
        <form:input path="rating"/>
    </p>
  
    <input type="submit" value="Add Song"/>
</form:form>   