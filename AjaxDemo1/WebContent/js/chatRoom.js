$(document).ready(function(){
	getContent();
	window.setInterval("getContent();",5000);
});
function getContent(){
	$.get("ChatServlet?nocache="+new Date().getTime(),
		function(data){
			var msg = "";
			
			var chats = eval(data);
			$.each(chats,function(i){
				msg+="<br>"+chats[i].message;
			});
			$("#content").html(msg);
		},"JSON"
	);
}

function sendmsg(){
	if($("#user").val() == ""){
		alert("请输入您的昵称!");
	}
	else if($("#speak").val() == ""){
		alert("说话内容不可以为空！");
		$("#speak").focus();
	}
	$.post("ChatServlet",
		{user:$("#user").val(),speak:$("#speak").val()}
	);
	$("#speak").val("");
	$("#speak").focus();
}
