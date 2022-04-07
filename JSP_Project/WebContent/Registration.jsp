<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
<jsp:useBean id="ub" class="bean.UserBean"></jsp:useBean>

			<jsp:setProperty name="ub" property="*" />
				<jsp:forward page="${ub.register()}.jsp"/>

</body>
</html>