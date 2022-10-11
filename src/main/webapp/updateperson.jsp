<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Person</title>
</head>
<body>

<h3>Update person data</h3>

<form:form action="updateperson" method="post" modelAttribute="person">
Id: <form:input path="id" readonly="true"/> <br> <br>
Name: <form:input path="name"/> <br> <br>
Email: <form:input path="email"/> <br> <br>
Phone Number: <form:input path="phoneNumber"/> <br> <br>
Age: <form:input path="age"/> <br> <br>
<form:button>update</form:button>

</form:form>

</body>
</html>