<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="java.text.SimpleDateFormat"
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String lastAccessTime = null;
		Cookie[] cookies = request.getCookies();
		String str="";
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if ("lastAccess".equals(cookies[i].getName())) {
				lastAccessTime = cookies[i].getValue();
				break;
			}
		}
		if (lastAccessTime == null) {
			str="您是首次访问本站！！！";
		} else {
			Date date = new Date(Long.parseLong(lastAccessTime));
			SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String lastAccessTime1 = myDateFormat.format(date);
			str="您上次访问的时间是：" + lastAccessTime1;
		}
		String currenttime = System.currentTimeMillis() + "";
		Cookie cookie = new Cookie("lastAccess", currenttime);
		cookie.setMaxAge(60 * 60);
		response.addCookie(cookie);
	%>
<%=str %>
</body>
</html>