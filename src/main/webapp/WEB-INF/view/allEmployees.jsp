<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Manager Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Employee List</h1>
            <h3><a href="employee">New Employee</a></h3>
            <table border="1">
                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
                <th>Company</th>
                 
                <c:forEach var="employee" items="${employeeList}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.email}</td>
                    <td>${employee.company.companyName}</td>
                    <td>
                        <a href="/editEmployee?id=${employee.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/deleteEmployee?id=${employee.id}">Delete</a>
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