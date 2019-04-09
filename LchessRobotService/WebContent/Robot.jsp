<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Lchess网页版</title>
		<link rel="stylesheet" href="css/lchess.css" />
		<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
		<script type="text/javascript" src="js/main.js"></script>
	</head>
</head>
<body>
             <%
             //设置缓存为空   
                response.setHeader("Pragma","No-cache");  
    			response.setHeader("Cache-Control","no-cache");  
    			response.setDateHeader("Expires", 0); 
             %> 
		<header>
			<!--//测试透明的div层的 <input type="button" value="取  消" onclick="cancelDiv()">
			<input type="button" value="显  示" onclick="coverDiv()">-->
			用户名 ：
			<input type="text" id="userid" class="form_input" placeholder="请输入用户名" />
			<input type="submit" value="登     录" id="enter">
			<a href="javascript: ;" id="newgame">New Game</a>

			<div id="prscore">
				<div id="pscore" class="prscore"><span id="username">user</span> score:<span id="pescore">0</span></div>
				<div id="rscore" class="prscore">robot score:<span id="roscore">0</span></div>
			</div>

		</header>
		<div id="all">
			<div id="cover"></div>
			<div id="grid-container">
				<!--  <div id="grid-cell-0-0" class="grid-class"></div> -->
			</div>
		</div>
	</body>

</html>