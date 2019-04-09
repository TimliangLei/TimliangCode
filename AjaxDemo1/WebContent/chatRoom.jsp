<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat Room</title>
<script type="text/javascript" src="js/jquery-1.11.0.js" ></script>
<script type="text/javascript" src="js/chatRoom.js" ></script>
</head>
<body>
<div id="content" style="height: 206px; overflow: hidden;">欢迎光临碧海聆音聊天室！</div>
<form name="form1" method="post" action="">
	<input name="user" type="text" id="user" size="20" />说：
	<input name="speak" type="text" id="speak" size="50" />
	<br />
	<input id="send" type="button" class="btn_grey" value="发送" onclick="sendmsg();"/>
</form>
</body>
</html>