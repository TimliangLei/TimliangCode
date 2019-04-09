var board = new Array();
var size = 9; //设置棋盘的大下
var hasConflicted = new Array();
var savecol = new Array(); //存储颜色的数组
var steparr = new Array(); //创建用来三步存储的数组
var empty = 0;
var step = 0; //定义步数
var data = {
	"pname": "",
	"pnum": 0,
	"pstep": [""],
	"pblack": [""],
	"rname": "",
	"rnum": 0,
	"rstep": [""],
	"rblack": [""]
};

//obj  定义存储最终json的元素
$(function() { //在加载HTML页面的时候  直接执行这个方法  不需要调用
	newgame(); //写上函数名就可以
});

window.onbeforeunload = function() {
	$.get('RobotServlet', {
		commond: "logout",
		value: data.pname //传递userid  刚开始的时候
	});
}

$(document).ready(function() {
	$("#enter").click(function() { //用户点击了登录按钮
		$.get('RobotServlet', {
				commond: "userid",
				value: $("#userid").val() //传递userid  刚开始的时候
			},
			function(olddata) {
				if(olddata == "用户名已经存在") { //首先判断传递的参数是不是允许用户使用
					alert("用户已经登录存在，请重新登录");
				} else { //用户名可以使用  将服务器的内容显示出来
					initArrSavecol(); //将数组重新初始化
					data = JSON.parse(olddata); //给成员变量
					if(data.rstep == "") {
						alert("你先下，请下棋！");
						cancelDiv(); //取消透明的div掉层
					} else {
						alert("机器先手，现在请你下棋！");
					}
					ServetJsonShow(data); //调用服务器json显示的方法
				}
			}
		);
	});
});

//将div覆盖上
function coverDiv() {
	$("#cover").css("z-index", 1);
}

//将div取消
function cancelDiv() {
	$("#cover").css("z-index", -1);
}

function newgame() {
	//初始化棋盘格
	//clearDiv();
	createDiv();
	init(); //设置小格子的样式
	initArrSavecol();
}

function initArrSavecol() {
	//初始化存储元素颜色的数组  数组的大小是由size决定的
	for(var k = 0; k < size; k++) { //一维长度为i,i为变量，可以根据实际情况改变
		savecol[k] = new Array(); //声明二维，每一个一维数组里面的一个元素都是一个数组；
		for(var j = 0; j < size; j++) { //一维数组里面每个元素数组可以包含的数量p，p也是一个变量；
			savecol[k][j] = "0"; //这里将变量初始化，我这边统一初始化为空，后面在用所需的值覆盖里面的值
		}
	}
}

function createDiv() { //初始化棋盘  大小由size决定
	for(var i = 0; i < size; i++) {
		for(var j = 0; j < size; j++) {
			x = "grid-cell-" + i + "-" + j; //设置的小的div的id属性
			var Odiv = document.createElement("div"); //创建一个div
			Odiv.id = x; //创建div的id
			Odiv.className = "grid-class"; //小的div的class属性
			Odiv.style.cssText = "width:50px;height:50px;border-radius: 6px;background-color: #ccc0b3;position: absolute;"; //创建小的div的css样式
			document.getElementById("grid-container").appendChild(Odiv); //在grid-container（大div）内新增一个div 
		}
	}
	//初始化步数的数组
	for(var k = 0; k < 3; k++) { //一维长度为i,i为变量，可以根据实际情况改变
		steparr[k] = new Array(); //声明二维，每一个一维数组里面的一个元素都是一个数组；
		for(var j = 0; j < 2; j++) { //一维数组里面每个元素数组可以包含的数量p，p也是一个变量；
			steparr[k][j] = "0"; //这里将变量初始化，我这边统一初始化为空，后面在用所需的值覆盖里面的值
		}
	}
}

function init() { //设置小格子的样式  小格子的数量由size决定
	for(var i = 0; i < size; i++) {
		board[i] = new Array();
		for(var j = 0; j < size; j++) {
			//初始化小格子值为0
			board[i][j] = 0;
			var gridCell = $("#grid-cell-" + i + "-" + j);
			gridCell.css("top", getPostTop(i, j));
			gridCell.css("left", getPostLeft(i, j));
		}
	}
}

function getPostTop(i, j) {
	return 6 + 56 * i; //小div之间的间距是6像素   小div的大小是56像素
}

function getPostLeft(i, j) {
	return 6 + 56 * j;
}

$(function() { //最开始就需要调用的方法
	$(".grid-class").click(function() { //给小的div添加了  onclick属性
		x = this.id.substring(10, 11); //获取id中的数字  知道了点击点的坐标
		y = this.id.substring(12, 13); //获取id中的数字  知道了点击点的坐标

		if(savecol[x][y] == "0") { //如果等于0才能进行剩下的操作
			steparr[parseInt(step) % 3][0] = x;
			steparr[parseInt(step) % 3][1] = y; //将刚刚点击的点的坐标存储到数组中去   0  1  2
			var gridCell = $("#grid-cell-" + x + "-" + y);
			gridCell.css("background-color", "#b9d3ee"); //先进行修改颜色
			savecol[x][y] = "1"; //点击修改后修改  savecol的数值    将点击存储到数组中

			if(step == 0) { //说明是三次中的第一次添加
				//不进行任何处理
			} else if(step == 1) { //说明是三次中的第二次添加
				//需要与第一次进行比较  保证是同行或者同列
				//同行比较  x相同  y=+-1
				if(((steparr[0][1] == (steparr[1][1] - 1)) && (steparr[0][0] == steparr[1][0])) || (((steparr[0][1] - 1) == steparr[1][1]) && steparr[0][0] == steparr[1][0])) {
					//alert("同行！");
				} else if(((steparr[0][0] == (steparr[1][0] - 1)) && (steparr[0][1] == steparr[1][1])) || (((steparr[0][0] - 1) == steparr[1][0]) && steparr[0][1] == steparr[1][1])) {
					//不是同行就判断是不是同列
					//alert("同列！");
				} else {
					//不同行也不同列  取消两次点击的按钮  变回原来的颜色 并将两次的数组取消掉
					//alert("不同行也不同列！"+steparr[0][0]+steparr[0][1]+steparr[1][0]+steparr[1][1]);
					$("#grid-cell-" + steparr[0][0] + "-" + steparr[0][1]).css("background-color", "#ccc0b3");
					$("#grid-cell-" + steparr[1][0] + "-" + steparr[1][1]).css("background-color", "#ccc0b3");
					savecol[steparr[0][0]][steparr[0][1]] = "0";
					savecol[steparr[1][0]][steparr[1][1]] = "0";
					step = -1;
				}
			} else { //否则就是第三次点击     step=2
				step = -1;
				//判断前两个是同行还是同列
				if(((steparr[0][1] == (steparr[1][1] - 1)) && (steparr[0][0] == steparr[1][0])) || (((steparr[0][1] - 1) == steparr[1][1]) && steparr[0][0] == steparr[1][0])) {
					//同行  判断是不是L型  
					//alert("同行！");
					//alert(steparr[2][1]+"++"+steparr[0][1]+"++"+steparr[1][1]);
					if(((steparr[2][1] == steparr[1][1]) || (steparr[2][1] == steparr[0][1])) && ((steparr[2][0] - 1) == steparr[1][0] || (steparr[2][0]) == steparr[1][0] - 1)) {
						//alert("先同行L型！ 传递到服务器数组steparr");
						parPasJson(steparr);
					} else {
						//alert("不是L型！");
						CancelColor(savecol);
						step = -1;
					}
				} else { //同列
					if(((steparr[2][0] == steparr[1][0]) || (steparr[2][0] == steparr[0][0])) && ((steparr[2][1] - 1) == steparr[1][1] || (steparr[2][1]) == steparr[1][1] - 1)) {
						//alert("先同列L型！ 传递到服务器数组steparr");
						parPasJson(steparr);
					} else {
						//alert("不是L型！");
						CancelColor(savecol);
						step = -1;
					}
				}
			}
			step = step + 1; //点击的3步次数加1 
		}
	});
});

function parPasJson(steparr) { //将用户点击产生的数组steparr保存的data中  并将data传递给服务器
	coverDiv(); //点击完毕了 禁止用户点击  加上透明的div
	if(data.pstep.length == 1) {
		data.pstep[data.pstep.length - 1] = steparr[0][0] + " " + steparr[0][1];
		data.pstep[data.pstep.length] = steparr[1][0] + " " + steparr[1][1];
		data.pstep[data.pstep.length] = steparr[2][0] + " " + steparr[2][1];
	} else {
		data.pstep[data.pstep.length] = steparr[0][0] + " " + steparr[0][1];
		data.pstep[data.pstep.length] = steparr[1][0] + " " + steparr[1][1];
		data.pstep[data.pstep.length] = steparr[2][0] + " " + steparr[2][1];
	}
	$.get('RobotServlet', {
			commond: "chess_step", //传递参数
			value: JSON.stringify(data) //传递json
		},
		function(olddata) { //解析服务器传递回来的参数json  并将其显示
			data = JSON.parse(olddata); //给成员变量
			ServetJsonShow(data); //调用服务器json显示的方法
		}
	);
}

//将前两步产生的颜色取消掉
function CancelColor(savecol) {
	$("#grid-cell-" + steparr[0][0] + "-" + steparr[0][1]).css("background-color", "#ccc0b3");
	$("#grid-cell-" + steparr[1][0] + "-" + steparr[1][1]).css("background-color", "#ccc0b3");
	$("#grid-cell-" + steparr[2][0] + "-" + steparr[2][1]).css("background-color", "#ccc0b3");
	savecol[steparr[0][0]][steparr[0][1]] = "0";
	savecol[steparr[1][0]][steparr[1][1]] = "0";
	savecol[steparr[2][0]][steparr[2][1]] = "0";
}
//将服务器传递的参数显示出来
function ServetJsonShow(data) {

	$(document).ready(function() { //修改用户的分数
		$("#username").html(data.pname);
	});

	$(document).ready(function() { //修改用户的分数
		$("#pescore").html(data.pnum);
	});

	$(document).ready(function() { //修改机器人的分数
		$("#roscore").html(data.rnum);
	});

	//用户走的棋子
	if(data.pstep.toString() != "") {
		var spPstep = data.pstep.toString().split(',');
		for(var i = 0; i < spPstep.length; i++) {
			savecol[spPstep[i].split(' ')[0]][spPstep[i].split(' ')[1]] = "1"; //将棋子保存在savecol数组中
		}
	}
	//机器人下的棋子
	if(data.rstep.toString() != "") {
		var spRstep = data.rstep.toString().split(',');
		for(var i = 0; i < spRstep.length; i++) {
			savecol[spRstep[i].split(' ')[0]][spRstep[i].split(' ')[1]] = "2";
		}
		//alert(savecol);
	}
	//找到用户产生的黑点
	if(data.pblack.toString() != "") {
		var spPblack = data.pblack.toString().split(',');
		for(var i = 0; i < spPblack.length; i++) {
			savecol[spPblack[i].split(' ')[0]][spPblack[i].split(' ')[1]] = "3";
		}
	}
	//找到机器人产生的黑点
	if(data.rblack.toString() != "") {
		var spRblack = data.rblack.toString().split(',');
		for(var i = 0; i < spRblack.length; i++) {
			savecol[spRblack[i].split(' ')[0]][spRblack[i].split(' ')[1]] = "4";
		}
	}
	//遍历数组savecol将不同的颜色显示出来
	for(var i = 0; i < savecol.length; i++) { //savecol.length表示行数
		for(var j = 0; j < savecol[0].length; j++) {
			switch(savecol[i][j]) {
				case "0":
					$("#grid-cell-" + i + "-" + j).css("background-color", "#ccc0b3");
					empty += 1;
					break;
				case "1": //用户下的棋子
					$("#grid-cell-" + i + "-" + j).css("background-color", "#00b2ee");
					break;
				case "2": //机器下的棋子
					$("#grid-cell-" + i + "-" + j).css("background-color", "#B23AEE");
					break;
				case "3": //用户产生的黑点
					$("#grid-cell-" + i + "-" + j).css("background-color", "#00e5ee");
					break;
				case "4": //机器产生的黑点
					$("#grid-cell-" + i + "-" + j).css("background-color", "#cd69c9");
					break;
				default:
					break;
			}
		}
	}

	cancelDiv(); //解析完了传递过来的div  开始让用下棋
	if(empty == 0) {
		coverDiv();
		if(data.pnum > data.rnum) {
			$("#cover").html("游戏结束,你胜利了！")
				.css("color", "#EE0000").css("font-size", "40px")
				.css("text-align", "center");
		} else if(data.pnum == data.rnum) {
			$("#cover").html("游戏结束，你与对手旗鼓相当，再接再厉！")
				.css("color", "#B2DFEE").css("font-size", "40px")
				.css("text-align", "center");
		} else {
			$("#cover").html("游戏结束，你失败了，再接再厉！")
				.css("color", "#8B8989").css("font-size", "40px")
				.css("text-align", "center");
		}
	} else {
		empty = 0;
	}
}
$(function() { //当用户点击new game的时候
	$("#newgame").click(function() {
		if(data.pname == "") {} else {
			$("#cover").html("");
			$.get('RobotServlet', {
					commond: "newgame",
					value: data.pname //传递userid  刚开始的时候
				},
				function(olddata) {
					initArrSavecol(); //将数组重新初始化
					data = JSON.parse(olddata); //将传递回来的json给成员变量
					if(data.rstep == "") {
						alert("你先下，请下棋！");
						cancelDiv(); //取消透明的div掉层
					} else {
						alert("机器先手，现在请你下棋！");
					}
					ServetJsonShow(data); //调用服务器json显示的方法
				}
			);
		}
	});
});