<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Person</title>
</head>
<body>

<h2>Create Person</h2>

<form:form action="saveperson" modelAttribute="person">

Name: <form:input path="name"/> <br> <br>
Email: <form:input path="email"/> <br> <br>
Phone Number: <form:input path="phoneNumber"/> <br> <br>
Age: <form:input path="age"/> <br> <br>
<form:button>Save</form:button>

</form:form>

</body>
</html>