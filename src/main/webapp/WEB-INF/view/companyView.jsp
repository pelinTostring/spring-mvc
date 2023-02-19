<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Submitted Company Information</h2>
	<table>
		<tr>
			<td>ID :</td>
			<td>${company.id}</td>
		</tr>
		<tr>
			<td>Company :</td>
			<td>${company.companyName}</td>
		</tr>
		<tr>
			<td>Web Site :</td>
			<td>${company.webSite}</td>
		</tr>
	</table>
		<p>
            <a href="/">Home Page</a>
        </p>
</body>
</html>