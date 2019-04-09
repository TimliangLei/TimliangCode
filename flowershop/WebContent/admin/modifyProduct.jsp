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
		String name = request.getParameter("name");
		
	%>
	
	<form name="usemodify" action="../modifyProduct" method="post" enctype="multipart/form-data">
	<table border="1" bordercolor="#B3B6EE" width="40%" align="center" height="350" cellpadding="0" cellspacing="0">
    	<caption>修改商品</caption>
        <tr>
        	<th width="30%" align="right">商品名称：</th>
            <td width="70%">
            	<input value="<%=name %>" name="name" type="text"/>
           	</td>
        </tr>
        <tr>
        	<th align="right">商品介绍：</th>
            <td>
            	请写下你最想说的话：<br/>
    			<textarea cols="40" rows="5" id="contactus" name="info"></textarea>
            </td>
        </tr>
        <tr>
        	<th align="right">商品价格：</th>
            <td>
            	<input type="text" maxlength="18" name="price"/>
            </td>
        </tr>
        <tr>
        	<th align="right">商品积分：</th>
            <td>
            	<input type="text" maxlength="18" name="point">
            </td>
        </tr>
        <tr>
        	<th align="right">上传图片：</th>
            <td>
            	<input type="file" name="loadup" value="上传"/>
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