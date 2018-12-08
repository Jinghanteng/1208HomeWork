
<%@page import="model.Type"%>
<%@page import="dao.TypeDao"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Add">
		标题<input name="title"> <br />
		<textarea name="text" rows="10">请输入内容</textarea>
		<br /> <select name="type">
			<%
				TypeDao typeDao = new TypeDao();
				List<Type> list = typeDao.getAllType();
				for (Type type2 : list) {
					session.setAttribute("nameType", type2.getName());
			%>
			<option value="军事">${nameType }</option>
			<%
				}
			%>
		</select> <br> <input type="submit" value="提交">


	</form>
</body>
</html>