<%@taglib uri="http://mytag.sf.net" prefix="t"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>自定义标签</title>
</head>
<body>
<%
	int i=Integer.parseInt(request.getParameter("id"));
	String s="false";
	if(i>5){
		s="true";
	}
%>
<t:demo size="<%=s %>">
<h1>您输入的数字>5</h1>
</t:demo>
</body>
</html>