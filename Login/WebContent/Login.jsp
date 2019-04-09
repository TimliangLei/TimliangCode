
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function checkImg_refresh(){
		var checkImg = document.getElementById("checkImg");
		checkImg.src="/Login/CheckServlet?"+Math.random();
	}
</script>
</head>
<body>
<%
	response.setDateHeader("expire", -1);
	response.setHeader("cache-control", "no-cache");
	response.setHeader("pragma", "no-cache");
	String name = "";
	String ps = "";
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie cook:cookies){
			if(cook.getName().equals("J_SESSION_ID")){
				String[] str = cook.getValue().split("#");
				if(str.length == 4){
					name = str[0];
					ps = str[1];
				}
			}
		}
	}
%>
<form name="reg" action="/Login/LoginServlet" method="post">
	用户名:<input name="username" type="text" value="<%=name %>"/><br/>
	密码:<input name="password" type="password" value="<%=ps %>"/><br/>
	验证码:<input name="checkCode"  type="text" />
			<img src="/Login/CheckServlet" id="checkImg" onclick="checkImg_refresh()"><br/>
	记住密码<input name="rem" type="checkbox" value="1"/><br/>
	<input type="submit" value="提交" id="bt"/>
	
</form>
</body>
</html>