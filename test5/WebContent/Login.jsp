<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	response.setDateHeader("expire", -1);
	response.setHeader("cache-control", "no-cache");
	response.setHeader("pragma", "no-cache");
	String name = "";
	String ps = "";
	Cookie[] cookies=request.getCookies();
	
	if(cookies!=null){
		
		for(Cookie cook:cookies){
			if(cook.getName().equals("user")){
				String s[]=cook.getValue().split("#");
				name=s[0];
				ps=s[1];
				
				
			}
		}
	}
%>
<form action="/test5/CookiesLogin" method="get">
	<h1>用户名</h1><br><input type="text" name="user" value="<%=name %>"/><br>
	<h1>密码</h1><br><input type="password" name="psw" value="<%=ps %>"/><br>
	<input type="checkbox" name="rem" value="1"/>记住密码 <br>
	<input type="submit" value="提交"/>
</form>
</body>
</html>