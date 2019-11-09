<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
 

<h4>License of <i><c:out value="${license.person.firstName}"/> <c:out value="${license.person.lastName}"/></i> </h4>
		<p>License Number: <c:out value="${license.number}"/> </p>
		<p>State Issued: <i><c:out value="${license.state}"/></i></p>	
		<p>Expiration Date: <i><c:out value="${license.expirationDate}"/></i></p>
		
