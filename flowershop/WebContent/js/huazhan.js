function display(){
	if(i == 0)	document.getElementById("pre").style.display="none";
}
var i=0;
var imgs= new Array("1.jpg","2.jpg","3.jpg","4.jpg","5.jpg");
function nextshow(){
	if(i < 4){
		i++;
		document.getElementById("paint").style.backgroundImage="url(img/"+imgs[i]+")";
	}
	if(i == 4 ){
		document.getElementById("pre").style.display="block";
		document.getElementById("next").style.display="none";
	}
	else if(i >0 && i < 4){
		document.getElementById("pre").style.display="block";
		document.getElementById("next").style.display="block";
	}
	
}
function preshow(){
	if(i >= 0){
		i--;
		document.getElementById("paint").style.backgroundImage="url(img/"+imgs[i]+")";
	}
	if(i == 0 ){
		document.getElementById("next").style.display="block";
		document.getElementById("pre").style.display="none";
	}
	else if(i >0 && i < 4){
		document.getElementById("pre").style.display="block";
		document.getElementById("next").style.display="block";
	}
}