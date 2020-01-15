
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Employee Salary Management</title>
</head>
<body>

        <h1>Employee Salary Management</h1>
        <h2>
            <a href="add">Add New Person</a>
            &nbsp;&nbsp;&nbsp;
            <a href="PersonList">List All Person</a>
            &nbsp;&nbsp;&nbsp;
            <!--  <a href="benefits/beneficiary"></a> -->
             
        </h2>
    <div>
        <table>
            <tr>
                <th>PersonID</th>
                <th>FirstName</th>
				<th>LastName</th>
                <th>Money</th>
				<th>CC Type</th>
                <th>CC Number</th>
                <th colspan="1"></th>
            </tr>
         <c:forEach var="person" items="${persons}">
            	<c:if test = "${!empty person.creditCard}">
            		<c:forEach items="${person.creditCard}" var = "creditCards">
	            		<tr>
		                    <td>${person.id}</td>
		                    <td>${person.firstName}</td>
		                    <td>${person.lastName}</td>
		                    <td>${person.money}</td>
		                    <td>${creditCards.type}</td>
							<td>${creditCards.number}</td>
							<!-- <c:url var="addcc" value="/main/creditcard/add?id=${person.id}" />
							<td><a href = "${addcc}">Add Credit Card</a></td> -->
							 <td><a href="/main/creditcard/add/<c:out value='${person.id}' />">Add Credit Card</a></td> 
							
	                    </tr>
                    </c:forEach>
            	</c:if>
            	<c:if test="${empty person.creditCard}">
					<tr>
						<td>${person.id}</td>
						<td>${person.firstName}</td>
						<td>${person.lastName}</td>
						<td>${person.money}</td>
						<td>N/A</td>
						<td>N/A</td>
						<td> <a href="/main/creditcard/add/<c:out value='${person.id}' />">Add Credit Card</a></td>
						<!-- &nbsp;&nbsp;&nbsp;&nbsp; --> 
						<!-- <td><a href="/delete/<c:out value='${employee.employeeId}' />">Delete</a> </td>  -->
						<!-- &nbsp;&nbsp;&nbsp;&nbsp; -->
						<!-- <td> <a href="benefits/show/<c:out value='${employee.employeeId}' />">Benefits</a> </td>   -->
					</tr>
				</c:if>        	
        </c:forEach>                     
        </table>
    </div>   
</body>
</html>