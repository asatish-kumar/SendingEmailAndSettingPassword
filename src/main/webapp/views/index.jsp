<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#userEmail").blur(function(event) {
			$("#dupEmail").html("");
			var userEmail = $("#userEmail").val();
			$.ajax({
				type : "GET",
				url : "validateEmail?userEmail=" + userEmail,
				success : function(abc) {
					if (abc == 'Duplicate') {
						$("#dupEmail").html("Email already registered");
						$("#userEmail").focus();
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<form:form action="save" method="POST" modelAttribute="user">
		<table>
			<thead align="center">
				<tr>
					<th>User Registration</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>User Name:</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>User Number:</td>
					<td><form:input path="userPhoneNumber" /></td>
				</tr>
				<tr>
					<td>User Email</td>
					<td><form:input path="userEmail" /> <font color='red'>
							<div id="dupEmail"></div>
					</font></td>
				</tr>
				<tr>
					<td><input type="submit" value="Register"></td>
					<td><input type="reset" value="Reset"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td>${msg}${errMsg}</td>
				</tr>
			</tfoot>
		</table>
	</form:form>
</body>
</html>