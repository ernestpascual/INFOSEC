<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
   %>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DLS-CSB Student Registration Database Management System</title>
</head>
<body>
<h2>DLS-CSB Student Registration Database Management System</h2>
<p>Record successfully registered. </p>
<!--  Expression language -->
<p>ID: <b>${student.studentId}</b></p>
<p>Last Name: <b>${student.lastName}</b></p>
<p>First Name: <b>${student.firstName}</b></p>
<p>Year level: <b>${student.yearLevel}</b></p>
<p>Course:  <b>${student.course}</b></p>

<hr/>
<p><form action='listrecords.action'>
<input type="submit" value="View ALL Records">
</form>
<br/>
<hr/>
<form action='index.html'>
<input type="submit" value="<< GO BACK >>">
</form>
</body>
</html>