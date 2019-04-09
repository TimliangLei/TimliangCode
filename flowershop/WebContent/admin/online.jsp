<%@page import="listener.UserList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>  
        <br /> 欢迎你 <span style="color:red;"> <%=session.getAttribute("user")%> 
        <br /> 当前在线人数：<span style="color:red;"> <%=UserList.getUserCount()%>人</span>  
        <br />  
        <br> 在线用户名单 : <br /> 
        <select multiple="multiple" name="list"  style="width:200px;height:250px">  
            <%  
                for (int i = 0; i < UserList.getUserCount(); i++) {  
                    out.write("<option>" + UserList.getVector().get(i) + "</option>");  
                }  
            %>  
        </select>  
    </center> 
</body>
</html>