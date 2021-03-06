package com.ltl.Lchess;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Robot {
	private String name = "";
	private int bnum=0;
	private ArrayList<Point> step_chess_list;//每个元素存储内容为1 2,4 5,7 8
	private ArrayList<Point> black_chess_list;//每个元素存储内容为1 2,4 5,7 8
	private int PLAYING;
	public Robot() {
		name ="";
		bnum=0;
		step_chess_list = new ArrayList<Point>();
		black_chess_list = new ArrayList<Point>();
		PLAYING=-1;
	}

	public int getPLAYING() {
		return PLAYING;
	}

	public void setPLAYING(int pLAYING) {
		PLAYING = pLAYING;
	}

	public ArrayList<Point> getStep_chess_list() {
		return step_chess_list;
	}

	public void setStep_chess_list(ArrayList<Point> step_chess_list) {
		if (step_chess_list==null) {
			return;
		}
		this.step_chess_list = step_chess_list;
	}

	public ArrayList<Point> getBlack_chess_list() {
		return black_chess_list;
	}

	public void setBlack_chess_list(ArrayList<Point> black_chess_list) {
		if (black_chess_list==null) {
			return;
		}
		this.black_chess_list = black_chess_list;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "名称："+this.getName()+"\n下棋位置："+this.getStep_chess()+"\n黑点个数："+this.getBnum()+"\n产生不可达点位置："+this.getBlack_chess();
	}

	public String getStep_chess() {
		//定义输出格式
		String result="[";
		if (step_chess_list.size()>0) {
			for(Point p:step_chess_list) {
				result+= "\""+p.x+" "+p.y+"\",";
			}
		}else {
			result+= "\"\",";
		}
		result = result.substring(0,result.length()-1)+"]";
		return result;	
	}
	public void appendStep_chess(ArrayList<Point> points) {
		if (points==null) {
			return;
		}
		//改为追加方法
		for(Point point:points) {
			this.step_chess_list.add(point) ;
		}

	}
	public String getBlack_chess() {

		//定义输出格式
		String result="[";
		if (black_chess_list.size()>0) {
			for(Point p:black_chess_list) {
				result+= "\""+p.x+" "+p.y+"\",";
			}
		}else {
			result+= "\"\",";
		}
		result = result.substring(0,result.length()-1)+"]";
		return result;	
	}
	public void appendBlack_chess(ArrayList<Point> points) {
		//改为追加方法
		if (points == null) {
			return;
		}
		for(Point point:points) {
			this.black_chess_list.add(point) ;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getRobotChess(int[][] chessBoard,int w,int h) {

		Random random = new Random();
		ArrayList<Point> emptyPoint_sorted = new ArrayList<Point>();
		//先找到空点
		for (int i = 0; i < w; i++) {
			for(int j = 0; j <  h; j++) {
				if (chessBoard[i][j] == 0) {
					Point p = new Point(i,j);
					emptyPoint_sorted.add(p);
				}
			}
		}
		//打乱空点顺序
		int n = emptyPoint_sorted.size();
		int[] sort_list = new int[n];
		boolean[]  bool = new boolean[n];
		int randInt = 0;
		for(int i = 0; i < n ; i++) {
			do {
				randInt  = random.nextInt(n);
				
			}while(bool[randInt]);
			bool[randInt] = true;
			sort_list[i] = randInt;
		}

		ArrayList<Point> emptyPoint = new ArrayList<Point>();
		for(int i:sort_list) {
			emptyPoint.add(emptyPoint_sorted.get(i));
		}
		
		ArrayList<Point> robotChessList = new ArrayList<Point>();
		randInt = random.nextInt(n);
		Point[] point = new Point[3];
		point[0] = emptyPoint.get(randInt);
		for(Point ePoint:emptyPoint) {
			if (Math.abs(ePoint.x-point[0].x) == 1&& ePoint.y == point[0].y) {//上下,12同列
				point[1] = ePoint;
				for(Point ePoint2:emptyPoint) {
					if (ePoint2.x == point[0].x && Math.abs(ePoint2.y-point[0].y)==1) {
						point[2]=ePoint2;
					}
					else if (ePoint2.x == point[1].x && Math.abs(ePoint2.y-point[0].y)==1) {
						point[2]=ePoint2;
					}
				}
			}
			else if (Math.abs(ePoint.y-point[0].y) == 1&& ePoint.x == point[0].x) {//左右,12同行
				point[1] = ePoint;
				for(Point ePoint2:emptyPoint) {
					if (ePoint2.y == point[0].y && Math.abs(ePoint2.x-point[0].x)==1) {
						point[2]=ePoint2;
					}
					else if (ePoint2.y == point[1].y && Math.abs(ePoint2.x-point[0].x)==1) {
						point[2]=ePoint2;
					}
				}
			}
		}
		for(Point p:point) {
			robotChessList.add(p);
		}
		String black_json="[";
		for (int i=0;i<robotChessList.size();i++){
			black_json += "\""+robotChessList.get(i).x+" "+ robotChessList.get(i).y+"\",";
		}
		black_json=black_json.substring(0,black_json.length()-1)+"]";
		return black_json;
	}
}
