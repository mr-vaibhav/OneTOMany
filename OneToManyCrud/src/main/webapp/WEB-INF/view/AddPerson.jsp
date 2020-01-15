<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="personEntry" method="post">
			<table style="with: 50%">
				<tr>
					<td>FirstName</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
					<tr>
					<td>LastName</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
					<td>Money</td>
					<td><input type="text" name="money" /></td>
				</tr>
				<tr><td>
				<input type="submit" value="Submit" /></td>
				</tr>
			</table>
			
		</form>
</body>

</html>