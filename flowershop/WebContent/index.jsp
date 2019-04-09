<%@page import="vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" content=""/>
		<link rel="stylesheet" href="css/index.css" type="text/css" />
		
		<script type="text/javascript" src="js/Video.js"></script>
		<title>欢迎来到网络花店</title>
	</head>

	<body>
		<div id="banner">
			<div class="site-nav">
				<ul class="site-nav-l">
					<a href="index.jsp">
						<li class="hello">hi,欢迎来到网络花店</li>
					</a>
					<li id="weixin" onmouseover="showup()" onmouseleave="showclose()">关注微信
						<ul id="weixin_photo1">
							<li id="weixin_photo"><img src="img/weixin.png" alt=""/></li>
						</ul>
					</li>
				</ul>
				<ul class="site-nav-r">
					<%
						User user = (User)session.getAttribute("user");
						if(user != null){
							%>
							<li class="menu login" id="LoginInfo">
								你好<%=user.getUsername() %>，
								<a id="btn-reg" href="LogoutServlet">退出</a>
							</li>
							<li class="site-nav-pipe">|</li>
					<li>
						<a href="Check.jsp">订单查询</a>
					</li>
					<li class="site-nav-pipe">|</li>
					<li class="menu dropdown">
						<a href="Cart.jsp">购物车</a>
					</li>
							<%
						}else{
							%>
				<li class="menu login" id="LoginInfo">你好，请 <a id="btn-login"
					href="login.jsp">登录</a> <a id="btn-reg" href="login.jsp">注册</a>
				</li>


				<%
					}
				%>
					
					<li class="site-nav-pipe">|</li>
					<li>
						中国鲜花礼品网:中国鲜花网领先品牌
					</li>
				</ul>
			</div>
			<span id="photo"></span>
			<div id="name">网络花店</div>
			<nav>
				<ul>
					<li>
						<a href="index.jsp"><span></span>主页</a>
					</li>
					<li>
						<a href="huazhan.jsp"><span></span>花展</a>
					</li>
					<li>
						<a href="shop_product"><span></span>商城</a>
					</li>
					<li>
						<a href="Cart.jsp"><span></span>购物车</a>
					</li>
				</ul>
			</nav>

			<div class="container">
				<div class="banner-text">

					<h1>ROSEONLY</h1>
					<img src="img/ROSEONLY.jpg" alt=""/>
					<p>roseonly，奢侈玫瑰品牌，是中国专注打造爱情信物的品牌，斗胆制定“一生只送一人”的离奇规则。roseonly以“信者得爱，爱是唯一”为主张，以奢侈玫瑰和璀璨珠宝，打造永恒真爱信物。</p>
					<a onclick="openVideo()">Watch The Introduce
				</a></div>
			</div>

			<div id="modal-content" style="display: none;">
				<div class="modal-header">
					<div class="close" onclick="closeVideo()"></div>
				</div>
				<div class="modal-body">
					<video src="1.mp4" controls></video>
				</div>
			</div>

		</div>
	</body>

</html>