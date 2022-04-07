<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User Registration</title>
</head>
<body>
<form action="Registration.jsp" method="post">
			<table>
				<tr>
					<td>Full Name:</td>
					<td><input type="text" name="full_name"/> </td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email"/> </td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"/> </td>
				</tr>
				<tr>
					<td>Birth Date:</td>
					<td><input type="date" name="birth_date"/> </td>
				</tr>
				<tr>
					<td colspan="2" ><input type="submit" value="Register"/> </td>
				</tr>
			</table>
		</form>

</body>
</html>