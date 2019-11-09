<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
 
<h1>What is your question?</h1>
<form action="/questions/new" method="post">
	Question: 	<br><textarea name="question"></textarea>
	<br>
	Tags: 	<br><input type="text" name="tag">	<br>
	<button type="submit">Submit</button>
</form>   