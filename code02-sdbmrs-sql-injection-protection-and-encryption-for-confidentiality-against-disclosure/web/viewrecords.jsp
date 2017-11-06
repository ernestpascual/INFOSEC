<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "dls.csb.sdbmrs.utility.Security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="record" type="java.sql.ResultSet" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DLS-CSB Student Registration Database Management System</title>
</head>
<body>
<h2>DLS-CSB Student Registration Database Management System</h2>
<table border='1'>
<tr>
 	<th>ID</th> 
 	<th>Last Name</th> 
 	<th>First Name</th> 
	<th>Year Level</th>
	<th>Course</th> 
</tr>
<% while (record.next()){ 
%>
<tr>
	<td align="center"> <%= Security.decrypt(record.getString("studentId")) %></td>
	<td><%= Security.decrypt(record.getString("lastName")) %></td>
	<td><%= Security.decrypt(record.getString("firstName")) %></td>
	<td align="center"> <%=record.getInt("yearLevel") %></td>
	<td><%= record.getString("course") %></td>
</tr>
<% }  %> 
<form action='index.html'>
<br>
	<input type="submit" value="<< GO BACK >>">
</form>
</table>
</body>
</html>