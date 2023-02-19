<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Submitted Employee Information</h2>
	<table>
		<tr>
			<td>ID :</td>
			<td>${employee.id}</td>
		</tr>
		<tr>
			<td>Name :</td>
			<td>${employee.firstName}</td>
		</tr>
		<tr>
			<td>Lastname :</td>
			<td>${employee.lastName}</td>
		</tr>
		<tr>
			<td>Email :</td>
			<td>${employee.email}</td>
		</tr>
		<tr>
			<td>Company :</td>
			<td>${employee.company.companyName}</td>
		</tr>
	</table>
		<p>
             <a href="/">Home Page</a>
        </p>
</body>
</html>