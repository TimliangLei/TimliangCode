<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" name="user" id="userid" name="userid">
 <input type="button"onclick="checkUserid()" value="检测">
<script type="text/javascript" src="js/jquery-1.11.0.js" ></script>
<script type="text/javascript">
function checkUserid() {  
	        $.get(  
	            'test',//url  
	            {  
	                commond:"userid",
					value:$("#userid").val()
	            },  
	            function(data){  
		
	                alert(data); 
	            }  
	        );  
	    }  
</script>
</body>
</html>