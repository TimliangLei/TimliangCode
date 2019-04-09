<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.activation.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MySQL数据源应用</title>
</head>
<body>
<%
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try{
	InitialContext ctx = new InitialContext();
	ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
	conn = ds.getConnection();
	String sql = "select * from stu_info";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	rs.last();
%>
你要查询的学生数据表中共有<font size="5" color="red"><%=rs.getRow() %></font>人
<table>
<tr>
<td>记录条数</td>
<td>学号</td>
<td>性别</td>
<td>年龄</td>
<td>体重</td>
<td>身高</td>
</tr>
<%
	rs.beforeFirst();
	while(rs.next()){%>
	<tr align="center">
		<td><%=rs.getRow() %></td>
		<td><%=rs.getString("sid") %></td>
		<td><%=rs.getString("sname") %></td>
		<td><%=rs.getString("sex") %></td>
		<td><%=rs.getString("sage") %></td>
		<td><%=rs.getDouble("sweight") %></td>
		<td><%=rs.getDouble("sheight") %></td>
	</tr>
	<%}%>
	</table>
	<%}catch(Exception e){
		%>出现意外，信息是<%=e.getMessage() %><%}
	finally{
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
%>

</table>
</body>
</html>