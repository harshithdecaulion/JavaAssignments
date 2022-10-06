<%@page import="com.valtech.dao.EmployeesDAO"%>
<%@page import="com.valtech.dao.Employees"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
EmployeesDAO dao=new EmployeesDAO();
int id = Integer.parseInt(request.getParameter("empId"));
Employees e=dao.getEmployee(id);
String prev="emp.jsp?empId="+dao.getPreviousId(id);
String next="emp.jsp?empId="+dao.getNextId(id);
String first="emp.jsp?empId="+dao.getFirstId();
String last="emp.jsp?empId="+dao.getLastId();
/* String update="emp.jsp?empId="+dao.updateEmployee(emp); */

%>
 
<table>
<tr>
    <td>Id</td><td><%= e.getId() %></td>
</tr>
<tr>    
    <td>Name</td><td><%= e.getName() %></td>
</tr>
<tr>
    <td>Age</td><td><%= e.getAge() %></td>
</tr>
<tr>
    <td>Gender</td><td><%= e.getGender() %></td>
</tr>
<tr>
    <td>Salary</td><td><%= e.getSalary() %></td>
</tr>
 <tr>
    <td><a href =<%= prev %>>Previous</a></td>
    <td><a href=<%= next %>>Next</a></td>
    <td><a href=<%= first %>>First</a></td>
    <td><a href=<%= last %>>Last</a></td>
<%--     <td><a href=<%= update %>>Update</a></td> --%>
</tr> 
</table>
</body>
</html>