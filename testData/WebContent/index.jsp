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
	var json = "{" + 
	"\"pname\":\"name\"," + 
	"\"pnum\":3," + 
	"\"pstep\":[\"0 0,0 1,1 1\",\"0 2,0 2,2 2\"]," + 
	"\"pblack\":[\"3 0\",\"0 3,5 6\",\"3 3\"]," + 
	"\"rname\":\"robot\"," + 
	"\"rnum\":3," + 
	"\"rstep\":[\"5 5,5 6,6 6\",\"6 8,7 8,8 8\"]," + 
	"\"rblack\":[\"4 1\",\"0 4,5 6\",\"5 6\"]" + 
	"}";
	        $.get(  
	            'test',//url  
	            {  
					commond:"chess_step",
	                value:json+""
	            },  
	            function(data){
					alert(data); 
	            }  
	        );  
	    }  
</script>
</body>
</html>