<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Manager Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Company List</h1>
            <h3><a href="company">New Company</a></h3>
            <table border="1">
                <th>Id</th>
                <th>Company</th>
                <th>Web Site</th>
                 
                <c:forEach var="company" items="${companyList}">
                <tr>
                    <td>${company.id}</td>
                    <td>${company.companyName}</td>
                    <td>${company.webSite}</td>
                    <td>
                        <a href="/companies/editCompany?id=${company.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/companies/deleteCompany?id=${company.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
            <p>
                <a href="/">Home Page</a>
            </p>
        </div>
    </body>
</html>