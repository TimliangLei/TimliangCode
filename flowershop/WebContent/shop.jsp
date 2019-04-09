<%@page import="Dao.FcartDao"%>
<%@page import="java.io.File"%>
<%@page import="vo.User"%>
<%@page import="Dao.shopDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Flower"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" content="" />
<title>网络花店商城</title>
<link rel="stylesheet" href="css/shop.css" type="text/css" />
</head>
<body>
	<%
		String errcart = (String) application.getAttribute("errcart");
		if (errcart != null) {
	%>
	<script type="text/javascript">
		alert("<%=errcart%>");
	</script>
	<%
		}
		errcart = null;
		application.setAttribute("errcart", errcart);
	%>
	<header> <img src="img/logo.jpg" alt="" />
	<div id="shopcar">
		<%
			User user = (User) session.getAttribute("user");
			if (user == null) {
			} else if (user != null) {
				FcartDao fcartDao = new FcartDao();
				int num = fcartDao.select(user);
		%>
		<table>
			<tr>
				<td rowspan="2"><img src="img/shopping.gif" alt="" /></td>
				<td><a href="Cart.jsp">购物车</a></td>
			</tr>

			<tr>
				<td><%=num%>个商品</td>
			</tr>

		</table>
		<%
			}
		%>
	</div>
	</header>
	<nav>
	<ul>
		<li><a href="index.jsp"><span></span>主页</a></li>
		<li><a href="huazhan.jsp"><span></span>花展</a></li>
		<li><a href="shop_product"><span></span>商城</a></li>
		<li><a href="Cart.jsp"><span></span>购物车</a></li>
	</ul>
	</nav>
	<div id="content">
		<div id="middle">
			<img src="img/title3.gif" width="100%" alt="" /><br /> <br />
			
			共${requestScope.page }/${requestScope.pagecount }页
			<c:choose>
				<c:when test="${requestScope.page+0 == 1 && requestScope.page+0 == requestScope.pagecount+0 }">
					首页|
					上一页|
					下一页|
					尾页
				</c:when>
				<c:when test="${requestScope.page+0 == 1 }">
					首页|
					上一页|
					<a href="shop_product?page=${requestScope.page+1 }">下一页</a>|
					<a href="shop_product?page=${requestScope.pagecount }">尾页</a>
				</c:when>
				<c:when test="${requestScope.page+0 == requestScope.pagecount+0 }">
					<a href="shop_product?page=1">首页</a>|
					<a href="shop_product?page=${requestScope.page-1 }">上一页</a>|
					下一页|
					尾页
				</c:when>
				<c:otherwise>
					<a href="shop_product?page=1">首页</a>|
					<a href="shop_product?page=${requestScope.page-1 }">上一页</a>|
					<a href="shop_product?page=${requestScope.page+1 }">下一页</a>|
					<a href="shop_product?page=${requestScope.pagecount }">尾页</a>
				</c:otherwise>
		</c:choose>
		<c:forEach var = "list" items = "${list}">
			<div id="news" border="0px">
				<div class="each" style="display: block;float: left; margin-top: 10px">
					<img src="resourse/${list.fphoto }" weight="124px"/>
					<p>
						<u>${list.name}</u><br /> <br />
						${list.info}<br /> 
						<font color="orangered">定&nbsp;价：${list.price }RMB</font><br /> 
						积分：${list.point}<br />
						<input type="button" value="加入购物车" float="right" onclick="window.location.href='addCart?fid=${list.fid}&name=add&page=${requestScope.page}';"/> 
						<input type="button" value="购买" float="right" onclick="window.location.href='addCart?fid=${list.fid}&name=purchase';"/>
					</p>
				</div>
			</div>
		</c:forEach>
	</div>
		<%
			if (user == null) {
		%>
		<div id="right">
			<img src="img/title4.gif" width="200px" alt="" /><br /> <br />
			<form action="LoginServlet">
				<label for="usrname"><b>账号：</b></label> <input type="text"
					id="username" name="username" width="180px"><br /> <label
					for="password"><b>密码：</b></label> <input type="password"
					id="password" name="password" width="180px"><br /> <select
					name="identity">
					<option value="1">后台管理员</option>
					<option value="0" selected>顾客</option>
				</select> <input name="checkCode" type="text" placeholder="请输入验证码"
					maxlength="10 class=" register_text"/> <img src="CheckServlet"
					id="checkImg" onclick="checkImg_refresh()" style="left: 12px"
					alt=""><br />
				<p>
					<a href="login.jsp">注册</a>
				</p>
				<input type="submit" value="登录" />
			</form>
		</div>
		<%
			} else {
		%>
		<div id="right1">
			<img src="img/title4.gif" width="200px" alt="" /><br /> <br /> 尊敬的<%=user.getUsername()%>，您好！<br />
			欢迎来到网络花店。 <a href="LogoutServlet" style="text-decoration: none;">退出</a>
		</div>
		<%}%>


		<footer> <br />
		<hr width="1016px" size="1" />
		<p>2014 网络花店 ICP备10012345号</p>
		</footer>
	</div>
</body>
</html>