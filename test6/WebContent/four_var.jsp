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
	request.setAttribute("name1", "Timliang");
	pageContext.setAttribute("name2","asdsf");
	session.setAttribute("name3", "5456456");
	application.setAttribute("name4", "opipoi");
%>
<%=(String)request.getAttribute("name1") %>
<%=(String)pageContext.getAttribute("name2") %>
<%=(String)session.getAttribute("name3") %>
<%=(String)application.getAttribute("name4") %>
<a href="/dataBase/four_var1.jsp">asdfasdf</a>
</body>
</html>