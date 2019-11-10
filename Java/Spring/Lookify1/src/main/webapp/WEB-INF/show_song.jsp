<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    


<a href="/dashboard"></a>
<h3>Title : <c:out value="${song.song}"/></h3>
<h3>Artist : <c:out value="${song.artist}"/></h3>
<h3>Rating : <c:out value="${song.rating}"/></h3>
<a href="/songs/remove/${song.id}">Delete</a>