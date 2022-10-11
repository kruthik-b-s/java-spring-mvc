<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View all Person</title>
</head>
<body>

<table border="2px">

		<thead>

			<tr>

				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone Number</th>
				<th>Age</th>
				<th>Edit</th>

			</tr>

		</thead>
		<tbody>

			<c:forEach var="person" items="${persons}">

				<tr>

					<td>${person.getId()}</td>
					<td>${person.getName()}</td>
					<td>${person.getEmail()}</td>
					<td>${person.getPhoneNumber()}</td>
					<td>${person.getAge()}</td>
					<td>
					<a href="update?id=${person.getId()}">Update</a>/
					<a href="remove?id=${person.getId()}">Delete</a>
					</td>

				</tr>

			</c:forEach>

		</tbody>

	</table>

</body>
</html>