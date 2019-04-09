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
		String errpro = (String) application.getAttribute("errpro");
		if (errpro != null) {
	%>
	<script type="text/javascript">
		alert("<%=errpro%>");
	</script>
	<%
		application.setAttribute("errpro", null);
		}
	%>
<form name="usemodify" action="modifyProduct.jsp" method="post">
	<table border="1" bordercolor="#B3B6EE" width="40%" align="center" height="100" cellpadding="0" cellspacing="0">
    	<caption>修改商品</caption>
        <tr>
        	<th width="30%" align="right">你要修改商品的名称：</th>
            <td width="70%">
            	<input name="name" type="text" />
           	</td>
        </tr>
        <tr>
        	<td colspan="2" align="center">
            	<input type="submit" value="提交" />
                <input type="reset" value="重置" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>