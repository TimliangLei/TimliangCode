<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用JSP方法读取数据库内容</title>
</head>

<body>
<h1>USER</h1>
<form action ="getdata">
<input type="submit" value="提交" />
</form>
<table>
<tr><th>姓名</th><th>学号</th></tr>
<c:forEach var = "str" items = "${list}">
<tr><td>${str.sname}</td><td>${str.sid}</td></tr>
</c:forEach>
共${requestScope.page }/${requestScope.pagecount }页
<c:choose>
	
	<c:when test="${requestScope.page+0 == 1 }">
		首页|
		上一页|
		<a href="test?page=${requestScope.page+1 }">下一页</a>|
		<a href="test?page=${requestScope.pagecount }">尾页</a>
	</c:when>
	<c:when test="${requestScope.page+0 == requestScope.pagecount+0 }">
		<a href="test?page=1">首页</a>|
		<a href="test?page=${requestScope.page-1 }">上一页</a>|
		下一页|
		尾页
	</c:when>
	<c:otherwise>
		<a href="test?page=1">首页</a>|
		<a href="test?page=${requestScope.page-1 }">上一页</a>|
		<a href="test?page=${requestScope.page+1 }">下一页</a>|
		<a href="test?page=${requestScope.pagecount }">尾页</a>
	</c:otherwise>
</c:choose>
</table>

</body>
</html>