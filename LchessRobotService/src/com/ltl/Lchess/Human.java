package com.ltl.Lchess;

import java.awt.Point;
import java.util.ArrayList;


public class Human {
	private String name = "";
	private int bnum=0;
	private ArrayList<Point> step_chess_list;
	private ArrayList<Point> black_chess_list;
	private int PLAYING;
	private static int ISPLAYING = 0;
	private static int NOTPLAYING = 1;
	public Human(String nameFlag){
		name ="";
		bnum=0;
		if (nameFlag.equals("pname")) {
			PLAYING=ISPLAYING;
		}
		else if (nameFlag.equals("rname")) {
			PLAYING=NOTPLAYING;
		}
		else {
			PLAYING=-1;
		}
		
		step_chess_list = new ArrayList<Point>();
		black_chess_list = new ArrayList<Point>();
	}
	

	public int getPLAYING() {
		return PLAYING;
	}


	public void setPLAYING(int pLAYING) {
		PLAYING = pLAYING;
	}


	public Human(){
		name ="";
		bnum=0;
		step_chess_list = new ArrayList<Point>();
		black_chess_list = new ArrayList<Point>();
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


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "名称："+this.getName()+"\n下棋位置："+this.getStep_chess()+"\n黑点个数："+this.getBnum()+"\n产生不可达点位置："+this.getBlack_chess();
	}
	
}
