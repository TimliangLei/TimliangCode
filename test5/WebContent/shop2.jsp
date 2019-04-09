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
	if(request.getParameter("b1")!=null)
		session.setAttribute("s4", request.getParameter("b1"));
	if(request.getParameter("b2")!=null)
		session.setAttribute("s5", request.getParameter("b2"));
	if(request.getParameter("b3")!=null)
		session.setAttribute("s6", request.getParameter("b3"));
%>
各种球大甩卖，一律八块：
	<form action="/test5/shop2.jsp" method="post">
		<p>
			<input type="checkbox" name="b1" value="篮球">篮球&nbsp;
			<input type="checkbox" name="b2" value="足球">足球&nbsp;
			<input type="checkbox" name="b3" value="排球">排球&nbsp;
		</p>
		<p>
			<input type="submit" value="提交" name="x1">
			<a href="/test5/shop1.jsp">买点别的</a>
			<a href="/test5/display.jsp">查看购物车</a>
		</p>
	</form>
</body>
</html>