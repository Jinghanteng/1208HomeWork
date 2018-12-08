
<%@page import="model.Matter"%>
<%@page import="javax.annotation.PreDestroy"%>
<%@page import="java.lang.annotation.Target"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<title>JSP Page</title>
</head>
<body>

	<h1>欢迎你， ${name }</h1>
	<table class="table table-striped" >
		<tr>
			<td>编号</td>
			<td>标题</td>
			<td>内容</td>
			<td>时间</td>
			<td>类型</td>
			<td>作者</td>
			<td>操作</td>
		</tr>
		<%
			List<Matter> list = (List) request.getAttribute("list");

			for (Matter matter : list) {
				System.out.println(matter.getId());
				pageContext.setAttribute("li", matter);
		%>
		<tr>
			<td>${li.id }</td>
			<td>${li.title }</td>
			<td>${li.content }</td>
			<td>${li.time}</td>
			<td>${li.type }</td>
			<td>${li.author }</td>
			<td><a href="update.jsp?&id=${li.id }&title=${li.title }&content=${li.content }">修改</a> |
				<a href="DeleteServlet?&id=${li.id }"
				onclick='return confirm("确定要删除吗?")'>删除</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<h3><a href="add.jsp" class="btn btn-default btn-lg active" role="button">添加留言</a> </h3>
	

</body>
</html>