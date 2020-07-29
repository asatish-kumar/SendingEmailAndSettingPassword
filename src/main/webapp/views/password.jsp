<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome To Forgot Password Page</h3>
	<table>
		<font color="red">${errMsg}</font>
		<form:form action="getPwd" method="POST" modelAttribute="password">

			<tbody>

				<tr>
					<td>Enter Your PhoneNumber :</td>
					<td><form:input path="userPhoneNumber" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="GetPassword"></td>
				</tr>
			</tbody>
		</form:form>
	</table>
</body>
</html>