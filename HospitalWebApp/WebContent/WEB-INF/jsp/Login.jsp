<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<form:form action="login" method="post" >
	<table>
		<tr>
			<td>Email</td>
			<td><form:input path = "email"/></td>
		</tr>
		
		<tr>
			<td>Password</td>
			<td><form:password path = "password"/></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"> <input type="submit" value="Login"/></td>
		</tr>
		
	</table>
</form:form>

</body>
</html>