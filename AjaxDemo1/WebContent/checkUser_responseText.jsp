<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>传统Ajax编程训</title>
	<script type="text/javascript" src="js/checkUser_responseText.js"></script>
</head>
<body>
	<form action="post" action="" name="form1">
		用户名：<input name="username" type="text" id="username" size="32"><div onclick="checkUser(form1.username);">检查用户名</div>
		密码：<input name="pwd1" type="password" id="pwd1" size="35"/><br/> 
		确认密码：<input name="pwd2" type="password" id="pwd2" size="35"/><br/> 
		E-mail:<input type="text" name="email" id="email" size="45"/><br/> 
		<input type="submit" value="确定">
	</form>
	<div id="toolTip"></div>
</body>

</html>