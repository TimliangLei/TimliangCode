<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="vo.Fcheck"%>
<%@page import="java.util.List"%>
<%@page import="Dao.FcheckDao"%>
<%@page import="Dao.FcartDao"%>
<%@page import="vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head lang="en">
<meta charset="UTF-8" content="">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>网上花店购物车</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<style type="text/css">
nav {
	margin: 0 auto;
	width: 100%;
	height: 60px;
	background: dimgray;
}
nav ul{
	padding: 0;
	margin: 0;
	list-style: none;
	
}
nav ul li {
	float: left;
	padding: 15px;
	border-left: white dotted 2px;
}

nav ul li a {
	text-decoration: none;
	font-weight: bolder;
	font-size: 22.5px;
	color: white;
	text-align: center;
	
	display: block;
	width: 12.5rem;
	background-size: cover;
}
nav ul li:hover{
	background: orange;
}
nav ul li a:visited{
	color: white;
}
</style>
</head>
<body>
<%
	User user = (User)session.getAttribute("user");
%>
	<nav>
	<ul>
		<li><a style="text-decoration: none;" href="index.jsp">主页</a></li>
		<li><a style="text-decoration: none;" href="huazhan.jsp">花展</a></li>
		<li><a style="text-decoration: none;" href="shop_product">商城</a></li>
	</ul>
	</nav>
	<div class="ct-pageWrapper">
  <main>
	<div class="container">
	  <div class="row">
		<div class="col-md-3">
		  <div class="widget">
			<h2 class="widget-header">账单</h2>
		  </div>
		</div>
		<div class="col-md-9">
		  <div class="row">
		  <%
		  	FcheckDao fcartDao = new FcheckDao ();
		  	List<Fcheck> list = fcartDao.selectAll(user);
		  	Iterator<Fcheck> iterator = list.iterator();
		  	String path = "resourse";
		  	while(iterator.hasNext()){
		  		Fcheck fcheck = iterator.next();
				String src = path + File.separator +fcheck.getFphoto();
				int pid = fcheck.getPid();
				int num = fcheck.getNum();
		  %>
		  	<div class="col-sm-4">
			  <div class="ct-product" style="width: 200px;display: block;">
				<div class="image"><img src="<%=src %>" alt=""></div>
				<div class="inner"><a href="#" class="btn btn-motive ct-product-button"><%=fcheck.getCheckid() %></a>
				  <h2 class="ct-product-title"><%=fcheck.getName() %></h2>
				  <p class="ct-product-description"><%=fcheck.getInfo() %></p>
				  <span class="ct-product-price">
				  	<%=fcheck.getPrice() %>RMB&nbsp;&nbsp;&nbsp;&nbsp;
				  	数量：<%=num %>
				  </span>
				</div>
			  </div>
			</div>
		  <%
		  	}
		  %>
			
		  </div>
		</div>
	  </div>
	</div>
  </main>

<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/shop.min.js" type="text/javascript"></script>

</div>
<div style="text-align: center;">
</div>
</body>
</html>