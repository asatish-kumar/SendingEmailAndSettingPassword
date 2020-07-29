<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function validatePwds() {
		var newPwd = $('#newPwd').val();
		var confirmPwd = $('#confirmPwd').val();

		if (newPwd != confirmPwd) {
			$('#errId').text('New Password & Confirm Password Should Be Same');
			return false;
		}
		return true;

	}
</script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Unlock Your Account</th>
			</tr>
		</thead>
		<tbody>
			<form:form action="unlock" method="POST" modelAttribute="account">
				<font color="red"><span id="errId"></span></font>
				<font color="red">${errMsg}</font>
				<tr>
					<td>User Email:</td>
					<td><form:input path="userEmail"  readonly="true"/></td>
				</tr>
				<tr>
					<td>Temporary Password:</td>
					<td><form:password path="tempPwd" /></td>
				</tr>
				<tr>
					<td>New Password:</td>
					<td><form:password path="newPwd" /></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><form:password path="confirmPwd" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Unlock"
						onclick="return validatePwds()"></td>
				</tr>
			</form:form>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>