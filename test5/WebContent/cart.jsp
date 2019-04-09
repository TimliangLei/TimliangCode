<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.ArrayList" import="java.util.*"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<%
String str1=response.encodeURL("/test5/shop?id=1");
String str2=response.encodeURL("/test5/shop?id=2");
String str3=response.encodeURL("/test5/shop?id=3");
String str4=response.encodeURL("/test5/shop?id=4");
String str5=response.encodeURL("/test5/shop?id=5");
%>
<a href="<%=str1%>">java web1</a><br>
<a href="<%=str2%>">java web2</a><br>
<a href="<%=str3%>">java web3</a><br>
<a href="<%=str4%>">java web4</a><br>
<a href="<%=str5%>">java web5</a><br>
You have bought:
<%

List<String> list=(ArrayList<String>)session.getAttribute("cart");

if(list!=null)
{
	for(String str:list)
		{
		out.println(str);
		}
	}
%>
</body>
</html>