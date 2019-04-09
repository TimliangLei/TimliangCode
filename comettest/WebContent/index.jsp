<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务器推送的时间</title>
<SCRIPT TYPE="text/javascript">
	function go() {
		var url = "http://localhost:8080/comettest/TomcatCometServlet";
		var request = new XMLHttpRequest();
		request.open("GET", url, true);
		request.setRequestHeader("Content-Type", "application/x-javascript;");
		request.onreadystatechange = function() {
			if (request.readyState == 4) {
				if (request.status == 200) {
					if (request.responseText) {
						document.getElementById("currenttime").innerHTML = request.responseText;
					}
				}
				go();
			}
		};
		request.send(null);
	}
</SCRIPT>
</head>
<body>
	<h1>获取服务器推送的时间</h1>
	<input type="button" onclick="go()" value="开始"></input>
	<div id="currenttime"></div>
	<br>
	<br>
	<hr>
	<br>
	<br>
	编译完成后，需将本项目下面的catalina.jar删除，否则将报一下错误
	HTTP Status 500 - java.lang.ClassCastException: org.apache.catalina.util.DefaultAnnotationProcessor cannot be cast to org.apache.AnnotationProcessor
</body>
</html>