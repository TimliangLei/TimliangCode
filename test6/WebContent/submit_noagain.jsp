<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function ab()
	{
		var tt = document.getElementById("submit");
		tt.disabled="disabled";
		return true;
	}
</script>
</head>
<body>
<%
	String token = UUID.randomUUID().toString();
	session.setAttribute("token", token);
	out.println(session.getAttribute("token"));
%>

<form method="post" action="/dataBase/submit.jsp" onsubmit="return ab()">
	name<input type="text" value="" name="name"><br/>
	<input type="hidden" value="<%=token %>" name="tok"><br/>
	<input type="submit" values="" id="submit">
</form>
</body>
</html>