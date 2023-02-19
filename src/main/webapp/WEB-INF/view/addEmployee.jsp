<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form Example - Register an Employee</title>
</head>
<body>
	<h3>Welcome, Enter The Employee Details</h3>

	<form:form method="POST" action="/addEmployee" modelAttribute="employee">
		<table>
		<tr>
				<td><form:label path="id">Id</form:label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="firstName">Name</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Lastname</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="company">Company Name</form:label></td>			
				<td><form:select path="company" name="company">
    					<c:forEach var="company" items="${companyList}">
                    <option value="${company.companyName}"/>
                    
                    </c:forEach>  
					</form:select>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
			<p>
                <a href="/">Home Page</a>
            </p>
	</form:form>
</body>

</html>