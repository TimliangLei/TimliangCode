<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	if(request.getParameter("c1")!=null){
		session.setAttribute("s1", request.getParameter("c1"));
	}
	if(request.getParameter("c2")!=null){
		session.setAttribute("s2", request.getParameter("c2"));
	}
	if(request.getParameter("c3")!=null){
		session.setAttribute("s3", request.getParameter("c3"));
	}
%>
各种肉大甩卖，一律十块：<br/>
<form method="post" action="/test5/shop1.jsp">
	<p>
		<input type="checkbox" name="c1" value="猪肉">猪肉&nbsp;
		<input type="checkbox" name="c2" value="牛肉">牛肉&nbsp;
		<input type="checkbox" name="c3" value="羊肉">羊肉&nbsp;
	</p>
	<p>
		<input type="submit" value="提交" name="B1">
		<a href="/test5/shop2.jsp">买点别的</a>&nbsp;
		<a href="/test5/display.jsp">查看购物车</a>
	</p>
</form>
</body>
</html>