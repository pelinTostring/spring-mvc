<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form Example - Register an Company</title>
</head>
<body>
	<h3>Welcome, Enter The Company Details</h3>

	<form:form method="POST" action="/companies/addCompany" modelAttribute="company">
		<table>
		<tr>
				<td><form:label path="id">Id</form:label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="companyName">Company</form:label></td>
				<td><form:input path="companyName" /></td>
			</tr>
			<tr>
				<td><form:label path="webSite">Web Site</form:label></td>
				<td><form:input path="webSite" /></td>
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