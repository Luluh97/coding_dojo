<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	
    <% String width = request.getParameter("width"); %>
    <% String height = request.getParameter("height"); %>
    <%  int cols = Integer.parseInt(width);  %>
    <%  int rows = Integer.parseInt(height);  %>
    
    <h1>Checkerboard: <%= width %>w X <%= height %>h </h1>
    
    <table>
        <% for(int i = 1; i <= rows; i++) { %>
        	 <tr>
        	 	<% for(int j = 1; j <= cols; j++) { %>
        	 		<% int m = (i+j)%2+1; %>
        	 			<td class="cell<%= m %>"></td>
        	 	<% } %>
        	 </tr>
        <% } %>
    </table>

 
   
     
 
</body>
</html>