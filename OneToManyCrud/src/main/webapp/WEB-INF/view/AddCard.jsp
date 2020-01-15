<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url var="addCcUrl" value="/main/creditcard/addCard?id=${personId}" />
<form:form action="${addCcUrl}" method="post" modelAttribute = "creditCardAttribute">
			<table style="with: 50%">
				<tr>
					<td>PersonId</td>
					<td><input type="text" value="${personId}" name = "personId" readonly/>
				</tr>
					<tr>
					<td>Card Type</td>
					<td><form:input path="type" /></td>
				</tr>
				<tr>
					<td>Number</td>
					<td><form:input path="number" /></td>
				</tr>
				<tr>
					<td>
					<input type="submit" value="Submit" />
					</td>
				</tr>
			</table>
			
		</form:form>
</body>

</html>