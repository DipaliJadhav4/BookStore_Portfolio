<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
</head>
<body>
<jsp:useBean id="ub" class="bean.UserBean" scope="session"/>
			
			${ub.message}
			<h2>User Id : ${ub.user.userId}</h2><br/>
			<h2>Full Name : ${ub.user.fullName}</h2><br/>
			<h2>Birth Date : ${ub.user.birthDate}</h2><br/>
			<h2>Creation Date : ${ub.user.creationDate}</h2><br/>
		<a href="Login.jsp">Click here</a> to logout.


</body>
</html>