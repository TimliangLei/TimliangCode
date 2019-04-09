<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	ServletContext sc = this.getServletContext();
	String path = sc.getRealPath("WEB-INF/config.properties");
	FileInputStream fin = new FileInputStream(path);
	Properties prop = new Properties();
	prop.load(fin);
	String driver = prop.getProperty("driver");
	String url = prop.getProperty("url");
	String user = prop.getProperty("user");
	String password = prop.getProperty("password");
	String url1 = url;
	String url2 = "?user="+user+"&password="+password;
	String url3 = "&useUnicode=true&charset=utf-8";
	String urlEnd = url1+url2+url3;
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(urlEnd);
%>
</body>
</html>