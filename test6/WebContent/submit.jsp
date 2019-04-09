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
	String name = request.getParameter("name");
	String tok = request.getParameter("tok");
	System.out.println(tok);
	String token = (String)session.getAttribute("token");
	if(token == null){
		System.out.println("token=null");
	}
	else if( token.equals(tok)){
		System.out.println(name+"xieru");
		session.removeAttribute("token");
	}
	else{
		System.out.print("后退再提交");
	}
%>
</body>
</html>