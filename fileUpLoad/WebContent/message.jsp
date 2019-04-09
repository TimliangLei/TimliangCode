<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>文件上传结果</title>
		<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
		<%	String filename = (String) request.getAttribute("fileName");%>
		<script type="text/javascript">
			$(document).ready(function() {
				LoadXMLDoc1();
			});

			function LoadXMLDoc1() {
				var xmlhttp;
				if(window.XMLHttpRequest) {
					xmlhttp = new XMLHttpRequest();
					alert(1);
				} else {
					xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				xmlhttp.onreadystatechange = function() {
					if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
						
						document.getElementById("content").innerHTML = xmlhttp.responseText;
						
					}
				}
				var filename = "<%=filename %>"
				xmlhttp.open("GET", "upload/" + filename, true);
				xmlhttp.setRequestHeader('Content-type','application/x-www-form-urlencoded');
				xmlhttp.send();
			}
		</script>

	</head>

	<body>
		<center>
			<h1>${message}</h1>
			<br>
			<h2>${username}</h2>
			<br>
			<h2>${age}</h2>
			<div id="content"></div>
		</center>
	</body>

</html>