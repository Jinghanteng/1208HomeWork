<%@page import="model.Type"%>
<%@page import="java.util.List"%>
<%@page import="dao.TypeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateServlet">
		<%
			HttpSession session2 = request.getSession();
			String title = request.getParameter("title");
			session2.setAttribute("title", title);
			String content = request.getParameter("content");
			session2.setAttribute("content", content);
		%>
		标题<input name="title" value="  ${title }"><br />
		<textarea name="text" rows="10"> ${content }</textarea>
		<br />
		<%
			TypeDao typeDao = new TypeDao();
			List<Type> list = typeDao.getAllType();
			for (Type type2 : list) {
				String nameType = type2.getName();
			}
			String id = request.getParameter("id");
			System.out.println(id);

			int id1 = Integer.valueOf(id).intValue();
			session2.setAttribute("id", id1);
		%>
		<select name="type">
			<%
				List<Type> list2 = typeDao.getAllType();
				for (Type type2 : list2) {
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