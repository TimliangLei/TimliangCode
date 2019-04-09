<%@page import="com.mysql.jdbc.Driver"%>
<%@page import="java.sql.*"%>
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
		String path = sc.getRealPath("config.properties");
		//String path = this.getClass().getClassLoader().getResource("config.properties").getPath();
		FileInputStream fin = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fin);
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String url1 = url;
		String url2 = "?user=" + username + "&password=" + password;
		String url3 = "&useUnicode=true&characterEncoding=utf-8";
		String urlEnd = url1 + url2 + url3;
		String sql_insert = "INSERT INTO student_info(id,name,sex,age,weight,hight) values(?,?,?,?,?,?)";
		System.out.println(urlEnd);
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(urlEnd);
		PreparedStatement pstmt = conn.prepareStatement(sql_insert);
		pstmt.setInt(1, 16);
		pstmt.setString(2, "张三");
		pstmt.setString(3, "男");
		pstmt.setInt(4, 20);
		pstmt.setFloat(5, 70);
		pstmt.setFloat(6, 175);
		int n = pstmt.executeUpdate();
		String outString=null;
		if (n == 1) {
			outString = "数据插入成功！";
		} 
		else 
		{
			outString = "数据插入失败！";
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	%>
	<%=outString%><br>
</body>
</html>