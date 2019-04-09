$(document).ready(function () {
	window.setInterval("time()",1000);
})
function time(){
	$("#getTime").load("getTime");
}