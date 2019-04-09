package com.ltl.Lchess;

import java.awt.Point;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
/**
 * Servlet implementation class myServlet
 */
@WebServlet("/RobotServlet")
public class RobotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> list =null;
	private String USERID = "userid";
	private String CHESS_STEP="chess_step";
	private String NEWGAME="newgame";
	private String LOGOUT = "logout";
	public static int ROW = 9;
	public static int COL = 9;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RobotServlet() {
		list = new ArrayList<String>();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String commond =new String(request.getParameter("commond"));
		String value =new String(request.getParameter("value"));
		System.out.println("-------------------------------------");
		System.out.println("传送的键值对：");
		System.out.println(commond+":"+value+"\n");
		//初始化对象参数
		GameRule gameRule = new GameRule();
		int chessBoard[][] = new int[ROW][COL];
		String result_data="";
		Human human = new Human();
		Robot robot = new Robot();
		InitChessBoard initChessBoard = new InitChessBoard();
		if (commond.equals(USERID)) {
			human.setName(value);
			robot.setName("robot");
			if(list.contains(human.getName()))
			{
				out.write("用户名已经存在");
				System.out.println("用户名已经存在");
			}
			else
			{
				System.out.println("用户名可以使用");
				if(!human.getName().equals("test")) {
					list.add(human.getName());
				}
				ArrayList<Point> arrayList = new ArrayList<Point>();
				Random random = new Random();
				for (int i=0; i<random.nextInt(15)+1;i++){
					int x =random.nextInt(ROW-2)+1;
					int y =random.nextInt(COL-2)+1;
					chessBoard[x][y]=5;
					Point point = new Point(x, y);
					arrayList.add(point);
				}
				initChessBoard.appendBlack_chess(arrayList);
				String test1 = gameRule.testBlack(chessBoard, ROW, COL);
				initChessBoard.appendBlack_chess(gameRule.mySplitBlack(test1));
				System.out.println(initChessBoard.toString());
				int rd=Math.random()>0.5?1:0; 
				if(rd==1)//如果是1的话，人先下。
				{
					System.out.println("用户先手！");
				}
				else
				{
					System.out.println("机器人先手！");
					robot.appendStep_chess(gameRule.mySplitStep(robot.getRobotChess(chessBoard, ROW, COL)));

					ArrayList<Point> chessGroup = gameRule.mySplitStep(robot.getStep_chess());
					for(Point point:chessGroup) {
						int x = point.x;
						int y = point.y;
						chessBoard[x][y]=2;
					}
					String test = gameRule.testBlack(chessBoard, ROW, COL);
					robot.appendBlack_chess(gameRule.mySplitBlack(test));
					robot.setBnum(gameRule.getBlackNum());
				}
				result_data = "{" + 
						"\"pname\":\""+human.getName()+"\"," + 
						"\"pnum\":"+human.getBnum()+"," + 
						"\"pstep\":"+human.getStep_chess()+"," + 
						"\"pblack\":"+human.getBlack_chess()+"," + 
						"\"rname\":\""+robot.getName()+"\"," + 
						"\"rnum\":"+robot.getBnum()+"," + 
						"\"rstep\":"+robot.getStep_chess()+"," + 
						"\"rblack\":"+robot.getBlack_chess()+"," + 
						"\"init\":"+initChessBoard.getBlack_chess()+ 
						"}";//  接收到 json
				System.out.println(result_data);
				out.print(result_data);
			}
			System.out.println("用户列表:"+list.toString());
			System.out.println("-------------------------------------");
			out.flush();
			out.close();
		}

		if (commond.equals(CHESS_STEP)) {
			String json=value;
			System.out.println("开始解包");
			JSONObject jo = JSONObject.fromObject(json);//将接收到的json格式字符串转换成json对象

			human.setName(jo.getString("pname"));
			human.setStep_chess_list(gameRule.mySplitStep(jo.getString("pstep")));
			human.setBnum(jo.getInt("pnum"));
			human.setBlack_chess_list(gameRule.mySplitBlack(jo.getString("pblack")));
			System.out.println(human.toString());
			robot.setName(jo.getString("rname"));
			robot.setStep_chess_list(gameRule.mySplitStep(jo.getString("rstep")));
			robot.setBnum(jo.getInt("rnum"));
			robot.setBlack_chess_list(gameRule.mySplitBlack(jo.getString("rblack")));
			System.out.println(robot.toString());
			
			initChessBoard.setBlack_chess_list(gameRule.mySplitBlack(jo.getString("init")));
			System.out.println(initChessBoard.toString());
			//放置棋盘
			chessBoard=gameRule.space("init",initChessBoard.getBlack_chess_list(), chessBoard);
			chessBoard=gameRule.space("pstep", human.getStep_chess_list(), chessBoard);
			chessBoard=gameRule.space("pblack", human.getBlack_chess_list(), chessBoard);
			chessBoard=gameRule.space("rstep", robot.getStep_chess_list(), chessBoard);
			chessBoard=gameRule.space("rblack", robot.getBlack_chess_list(), chessBoard);
			System.out.println("解包完成\n");
			//判断是否游戏结束
			//用户下玩就结束
			if(!isfinish(chessBoard)) {
				human.appendBlack_chess(gameRule.mySplitBlack(gameRule.testBlack(chessBoard, ROW, COL)));
				human.setBnum(human.getBnum()+gameRule.getBlackNum());
				chessBoard = gameRule.space("pblack", human.getBlack_chess_list(), chessBoard);
				System.out.println(human.getName()+"产生"+human.getBnum()+"个不可达点:"+human.getBlack_chess());
				//用户产生黑点后结束
				if(!isfinish(chessBoard)) {
					robot.appendStep_chess(gameRule.mySplitStep(robot.getRobotChess(chessBoard, ROW, COL)));
					chessBoard = gameRule.space("rstep", robot.getStep_chess_list(), chessBoard);
					System.out.println(robot.getName()+"下棋的位置:"+robot.getStep_chess());
					//机器人下完后结束
					if (!isfinish(chessBoard)) {
						robot.appendBlack_chess(gameRule.mySplitBlack(gameRule.testBlack(chessBoard, ROW, COL)));
						robot.setBnum(robot.getBnum()+gameRule.getBlackNum());
						chessBoard = gameRule.space("rblack", robot.getBlack_chess_list(), chessBoard);
						System.out.println(robot.getName()+"产生"+robot.getBnum()+"不可达点:"+robot.getBlack_chess());
					}
				}
			}
			//构造并打印JSON数据包
			System.out.println("\n构造并打印JSON数据包");
			result_data = "{" + 
					"\"pname\":\""+human.getName()+"\"," + 
					"\"pnum\":"+human.getBnum()+"," + 
					"\"pstep\":"+human.getStep_chess()+"," + 
					"\"pblack\":"+human.getBlack_chess()+"," + 
					"\"rname\":\""+robot.getName()+"\"," + 
					"\"rnum\":"+robot.getBnum()+"," + 
					"\"rstep\":"+robot.getStep_chess()+"," + 
					"\"rblack\":"+robot.getBlack_chess()+"," + 
					"\"init\":"+initChessBoard.getBlack_chess()+ 
					"}";//  接收到 json
			System.out.println(result_data);
			System.out.println("处理结束");
			out.print(result_data);
			System.out.println("-------------------------------------");
			out.flush();
			out.close();
		}
		if (commond.equals(NEWGAME)) {
			human.setName(value);
			robot.setName("robot");
			if(list.contains(human.getName())||value.equals("test")){
				System.out.println("用户名可以使用");
				int rd=Math.random()>0.5?1:0; 
				if(rd==1)//如果是1的话，人先下。
				{
					System.out.println("用户先手！");
				}
				else
				{
					System.out.println("机器人先手！");
					robot.appendStep_chess(gameRule.mySplitStep(robot.getRobotChess(chessBoard, ROW, COL)));

					ArrayList<Point> chessGroup = gameRule.mySplitStep(robot.getStep_chess());
					for(Point point:chessGroup) {
						int x = point.x;
						int y = point.y;
						chessBoard[x][y]=2;
					}
					String test = gameRule.testBlack(chessBoard, ROW, COL);
					robot.appendBlack_chess(gameRule.mySplitBlack(test));
					robot.setBnum(gameRule.getBlackNum());
				}
				result_data = "{" + 
						"\"pname\":\""+human.getName()+"\"," + 
						"\"pnum\":"+human.getBnum()+"," + 
						"\"pstep\":"+human.getStep_chess()+"," + 
						"\"pblack\":"+human.getBlack_chess()+"," + 
						"\"rname\":\""+robot.getName()+"\"," + 
						"\"rnum\":"+robot.getBnum()+"," + 
						"\"rstep\":"+robot.getStep_chess()+"," + 
						"\"rblack\":"+robot.getBlack_chess()+"," + 
						"\"init\":"+initChessBoard.getBlack_chess()+ 
						"}";//  接收到 json
				System.out.println(result_data);
				out.print(result_data);
			}
			System.out.println("用户列表:"+list.toString());
			System.out.println("-------------------------------------");
			out.flush();
			out.close();
		}
		if (commond.equals(LOGOUT)) {
			if (value!=null&&value!="test") {
				String name = value;
				
				list.remove(name);
			}
			System.out.println(list.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public boolean isfinish(int[][] chessBoard) {
		for(int i = 1; i < ROW; i++) {
			for(int j = 1; j < COL; j++) {
				if (chessBoard[i][j]==0) {
					return false;
				}
			}
		}
		return true;

	}
}
