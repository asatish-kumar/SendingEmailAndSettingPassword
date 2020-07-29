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
	<h3>Welcome To Login Page</h3>
	<table>
		<tbody>
			<form:form action="userlogin" method="POST" modelAttribute="login">
				<font color="red">${errMsg}</font>
				<tr>
					<td>EMAIL ID :</td>
					<td><form:input path="userEmail" /></td>
				</tr>
				<tr>
					<td>PASSWORD :</td>
					<td><form:password path="userPazzword" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
					<td><input type="reset" value="Reset"></td>
				</tr>
				<br />
				<br />
				<br />
				<tr>
					<td><a href="/user/show">Sign Up</a></td>
					<td><a href="/user/password">Forgot Password</a></td>
				</tr>
			</form:form>
		</tbody>
	</table>
</body>
</html>