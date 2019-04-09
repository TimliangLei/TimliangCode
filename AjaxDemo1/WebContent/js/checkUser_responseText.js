var http_request;
function createRequest(url) {
	http_request = false;
	if (window.XMLHttpRequest) {
		http_request = new XMLHttpRequest();
	}else if (window.ActiveObject) {
		try {
			http_request = new ActiveXObject("Msxm12.XMHTTP");
		} catch (e) {
			try {
				http_request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				// TODO: handle exception
			}
		}
	}
	if (!http_request) {
		alert("不能创建XMLHttpRequest对象实例！");
		return false;
	}
	http_request.onreadystatechange = getResult;
	http_request.open('GET',url,true);
	http_request.send(null);
}
function getResult() {
	if (http_request.readyState == 4) {
		if (http_request.status == 200) {
			
			document.getElementById("toolTip").innerHTML=http_request.responseText;
			document.getElementById("toolTip").style.display="block";
		}
		else {
			alert("您请求的页面有错误！");
		}
	}
}
function checkUser(userName) {
	if (userName.value == "") {
		alert("请重新输入用户名！");
		userName.focus();
		return;
	} else {
		createRequest('checkUser?user='+ encodeURIComponent(userName.value));
	}
}