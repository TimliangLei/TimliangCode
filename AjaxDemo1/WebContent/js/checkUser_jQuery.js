function checkUser(userName){
	if(userName.val== ""){
		alert("请输入用户名：");
		$("#username").focus();
		return;
	}
	else{
		$.get("checkUser",
				{user:$("#username").val()},
				function(data){
					$("#toolTip").text(data);
					$("#toolTip").show();
				}
		);
	}
}