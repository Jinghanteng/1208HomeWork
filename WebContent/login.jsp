<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Loginservlet">
    		<input name="username" value="${rename }" class="form-control" id="exampleInputName2" placeholder="用户名" />
    		<br />
    		<input name="password" class="form-control" id="exampleInputName2" placeholder="密码" />
    		<br />
    		<input type="submit" value="登录" />
    		<br />
    		没有用户名请点击<a href="register.jsp">注册</a>
    	</form>
    	<%session.getAttribute("msg"); %>
    	   ${msg }
</body>
</html>