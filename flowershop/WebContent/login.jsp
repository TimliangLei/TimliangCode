<%@page import="Dao.shopDao"%>
<%@page import="vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8" content="">
		<title>ROSEONLY_登陆</title>
		<link rel="stylesheet" href="css/login.css" />
		<script type="text/javascript" src="js/login.js" ></script>
		<script type="text/javascript">
			function checkImg_refresh(){
				var checkImg = document.getElementById("checkImg");
				checkImg.src="CheckServlet?"+Math.random(0,1);
			}
		</script>
	</head>

	<body onload="change()">
	<%
		String errlog = (String) application.getAttribute("errlog");
		if (errlog != null) {
	%>
	<script type="text/javascript">
		alert("<%=errlog%>");
	</script>
	<%	errlog = null;
		}
	%>

	<%
		User user = (User)session.getAttribute("user");
		if(user != null){
	%>
	<script type="text/javascript">
		alert("您已登录，欢迎购物！");
	</script>
	<%	response.setHeader("Refresh", "0.01;url=shop.jsp");	
		}
	%>
	<div id="container">
			<a href="index.jsp"><img id="logo_nbtn" src="img/login_title.png" alt=""/></a>
		</div>
		<div id="background_img">
			
			<div id="form_Tab">
				<form id="form_container" action="LoginServlet" method="post">
					<div class="signin_tit"  onclick="login()">登录</div>
					<div class="signin_zhuce" onclick="zhuce()">注册</div>
					<div id="register_l">
					<%
						response.setDateHeader("expire", -1);
						response.setHeader("cache-control", "no-cache");
						response.setHeader("pragma", "no-cache");
						String name = "";
						String ps = "";
						Cookie[] cookies = request.getCookies();
						if (cookies != null) {
							for (Cookie cook : cookies) {
								if (cook.getName().equals("J_SESSION_ID")) {
									String[] str = cook.getValue().split("#");
									if (str.length == 5) {
										name = str[0];
										ps = str[1];
									}
								}
							}
						}
					%>
					<div class="register_nav">
							<img src="img/phone.png" style="left: 12px" class="register_nav_img" alt="">
							<input type="text" value="<%=name %>" name="username" id="username1" maxlength="30" class="register_text text_p">
						</div>
						<div class="register_nav">
							<img src="img/passkey.png" alt="" class="register_nav_img">
							<input type="password" name="password" value="<%=ps %>" id="password1" maxlength="16" class="register_password">
						</div>
						<div class="register_nav">
							<select name="identity">
								<option value="1">后台管理员</option>
								<option value="0" selected>顾客</option>
							</select>
						</div>
						<div class="register_nav">
							<input name="checkCode" type="text" placeholder="请输入验证码" maxlength="10 class="register_text"/>
							<img src="CheckServlet" id="checkImg" onclick="checkImg_refresh()" style="left: 12px" alt=""><br/>
						</div>
						<div class="signin_a">
							记住密码<input name="rem" type="checkbox" value="1"/>
							<input type="submit" value="确定" id="login-btn-submit" class="signin_button" onclick="checklog()">
						</div>
					</div>
				</form>	
				
				<form id="form_container" action="enroll" method="post">
					<div id="register_z">
						<div class="register_nav">
							<img src="img/phone.png" style="left: 12px" class="register_nav_img" alt="">
							<input type="text" placeholder="请输入手机号" name="username" id="username" maxlength="30" class="register_text text_p">
						</div>
						<div class="register_nav">
							<img src="img/passkey.png" alt="" class="register_nav_img">
							<input type="password" name="password1" placeholder="请输入密码" id="password" maxlength="16" class="register_password">
						</div>
						<div class="register_nav">
							<img src="img/passkey.png" alt="" class="register_nav_img">
							<input type="password" name="password2" placeholder="请重新输入密码" id="password" maxlength="16" class="register_password">
						</div>
						<div class="register_nav">
							<select name="identity">
								<option value="1">后台管理员</option>
								<option value="0" selected>顾客</option>
							</select>
						</div>
						<div class="signin_a">
							<input type="submit" value="确定" id="login-btn-submit"/>
						</div>
					</div>
				</form>

			</div>
		</div>
		
	</body>

</html>