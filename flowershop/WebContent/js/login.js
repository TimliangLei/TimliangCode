function change(){
	setInterval("show()",2000);
}
var i = 0;
function show(){
	var imgs =["login1.jpg","login2.jpg","login3.jpg","login4.jpg"];
	if(i > 3) i = 0;
	document.getElementById("background_img").style.backgroundImage="url(img/"+imgs[i]+")";
	i++;
}
function login(){
	document.getElementById("register_l").style.display="block";
	document.getElementById("register_z").style.display="none";
}
function zhuce(){
	document.getElementById("register_l").style.display="none";
	document.getElementById("register_z").style.display="block";
}
function checklog(){
	var name =	document.getElementById("username1").value;
	var passwords = document.getElementById("password1").value;
	if (name != "" && passwords != "") {
		//alert("登陆成功");
	} 
	else if(name ==""){
		alert("用户名不能为空！！！");
	}
	else{
		alert("密码不能为空！！！");
	}
}
