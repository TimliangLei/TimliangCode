package com.ltl.Lchess;

import java.awt.*;
import java.util.ArrayList;

public class GameRule {
	private int black_num;
	public GameRule() {
		// TODO Auto-generated constructor stub
		black_num = 0;
	}
	public String testBlack(int[][] chessBoard,int w,int h) {
		ArrayList<Point> emptyPoint = new ArrayList<Point>();
		//���ҵ��յ�
		for (int i = 0; i < w; i++) {
			for(int j = 0; j <  h; j++) {
				if (chessBoard[i][j] == 0) {
					Point p = new Point(i,j);
					emptyPoint.add(p);
				}
			}
		}
		//�ҵ��ڵ�λ��
		ArrayList<Point> isBlack = new ArrayList<Point>();
		for (Point pp : emptyPoint) {
			int x = pp.x;
			int y = pp.y;
			if (y == 0 && x == 0) {//���Ͻ�
				if ((chessBoard[x][y + 1] != 0 || chessBoard[x + 1][y] != 0) && chessBoard[x + 1][y + 1] != 0) {
					isBlack.add(pp);
				}
			} else if (y == 0 && x == w - 1) {//���Ͻ�
				if ((chessBoard[x - 1][y] != 0 || chessBoard[x][y + 1] != 0) && chessBoard[x - 1][y + 1] != 0) {
					isBlack.add(pp);
				}


			} else if (y == h - 1 && x == 0) {//���½�
				if ((chessBoard[x][y - 1] != 0 || chessBoard[x + 1][y] != 0) && chessBoard[x + 1][y - 1] != 0) {
					isBlack.add(pp);
				}
			} else if (x == w - 1 && y == h - 1) {//���½�
				if ((chessBoard[x][y - 1] != 0 || chessBoard[x - 1][y] != 0) && chessBoard[x - 1][y - 1] != 0) {
					isBlack.add(pp);
				}
			} else if (x == 0) {//��һ��
				if (chessBoard[x+1][y]==0&&chessBoard[x+1][y-1]==0){
					continue;
				}
				if (chessBoard[x+1][y]==0&&chessBoard[x+1][y+1]==0){
					continue;
				}
				if (chessBoard[x][y-1]==0&&chessBoard[x+1][y-1]==0){
					continue;
				}
				if (chessBoard[x][y+1]==0&&chessBoard[x+1][y+1]==0){
					continue;
				}
				if (chessBoard[x][y-1]==0&&chessBoard[x+1][y]==0){
					continue;
				}
				if (chessBoard[x][y+1]==0&&chessBoard[x+1][y]==0){
					continue;
				}
				isBlack.add(pp);
			} else if (x == w - 1) {//���һ��
				if (chessBoard[x-1][y]==0&&chessBoard[x-1][y-1]==0){
					continue;
				}
				if (chessBoard[x-1][y]==0&&chessBoard[x-1][y+1]==0){
					continue;
				}
				if (chessBoard[x][y-1]==0&&chessBoard[x-1][y-1]==0){
					continue;
				}
				if (chessBoard[x][y+1]==0&&chessBoard[x-1][y+1]==0){
					continue;
				}
				if (chessBoard[x][y-1]==0&&chessBoard[x-1][y]==0){
					continue;
				}
				if (chessBoard[x][y+1]==0&&chessBoard[x-1][y]==0){
					continue;
				}
				isBlack.add(pp);
			} else if (y == 0) {
				if (chessBoard[x][y+1]==0&&chessBoard[x-1][y+1]==0){
					continue;
				}
				if (chessBoard[x][y+1]==0&&chessBoard[x+1][y+1]==0){
					continue;
				}
				if (chessBoard[x-1][y]==0&&chessBoard[x-1][y+1]==0){
					continue;
				}
				if (chessBoard[x+1][y]==0&&chessBoard[x+1][y+1]==0){
					continue;
				}
				if(chessBoard[x][y+1]==0&&chessBoard[x-1][y]==0){
					continue;
				}
				if(chessBoard[x][y+1]==0&&chessBoard[x+1][y]==0){
					continue;
				}
				isBlack.add(pp);
			} else if (y == h - 1) {
				if (chessBoard[x][y-1]==0&&chessBoard[x-1][y-1]==0){
					continue;
				}
				if (chessBoard[x][y-1]==0&&chessBoard[x+1][y-1]==0){
					continue;
				}
				if (chessBoard[x-1][y]==0&&chessBoard[x-1][y-1]==0){
					continue;
				}
				if (chessBoard[x+1][y]==0&&chessBoard[x+1][y-1]==0){
					continue;
				}
				if(chessBoard[x][y-1]==0&&chessBoard[x-1][y]==0){
					continue;
				}
				if(chessBoard[x][y-1]==0&&chessBoard[x+1][y]==0){
					continue;
				}
				isBlack.add(pp);
			} else {
				//Top
				if (chessBoard[x][y-1] == 0&&chessBoard[x+1][y-1] == 0) {
					continue;
				}
				if (chessBoard[x][y-1] == 0 &&chessBoard[x-1][y-1] == 0) {
					continue;
				}
				//Button
				if (chessBoard[x][y+1] == 0&&chessBoard[x+1][y+1] == 0) {
					continue;
				}
				if (chessBoard[x][y+1] == 0&&chessBoard[x-1][y+1] == 0) {
					continue;
				}
				//Left
				if (chessBoard[x-1][y] == 0&&chessBoard[x-1][y+1] == 0) {
					continue;
				}
				if (chessBoard[x-1][y] == 0&&chessBoard[x-1][y-1] == 0) {
					continue;
				}
				//Right
				if (chessBoard[x+1][y] == 0&&chessBoard[x+1][y+1] == 0) {
					continue;
				}
				if (chessBoard[x+1][y] == 0&&chessBoard[x+1][y-1] == 0) {
					continue;
				}
				//center
				if (chessBoard[x][y-1]==0&&chessBoard[x+1][y]==0){
					continue;
				}
				if (chessBoard[x][y-1]==0&&chessBoard[x-1][y]==0){
					continue;
				}
				if (chessBoard[x][y+1]==0&&chessBoard[x-1][y]==0){
					continue;
				}
				if (chessBoard[x][y+1]==0&&chessBoard[x+1][y]==0){
					continue;
				}
				isBlack.add(pp);
			}
		}
		//���úڵ�

		if(isBlack.size()>0)
		{
			String black_json="[";
			for (Point b : isBlack) {
				black_json += "\""+b.x+" "+ b.y+"\",";
				black_num+=1;
			}
			black_json=black_json.substring(0,black_json.length()-1)+"]";
			return black_json;
		}
		else {
			System.out.println("û�в����ڵ㣡");
			return null;
		}

	}
	public int getBlackNum() {
		int result = this.black_num;
		this.black_num = 0;
		return result;
	}
	public ArrayList<Point> mySplitStep(String str){//���������ߵĲ�����ֵ 
		if (str==null||str.equals("[\"\"]")) {
			return null;
		}
		if(str.length()>15) {
			ArrayList<Point> arrayList = new ArrayList<Point>();
			String str_new1 = str.substring(2,str.length()-2);
			String str_new2[] = str_new1.split("\",\"");
			for(String str_temp:str_new2) {
				String point_str[] = str_temp.split(",");
				for(String p:point_str) {
					String str_num[] = p.split(" ");
					Point point = new Point();
					point.x=Integer.parseInt(str_num[0]);
					point.y=Integer.parseInt(str_num[1]);
					arrayList.add(point);
				}
			}
			return arrayList;
		}
		else {
			ArrayList<Point> arrayList = new ArrayList<Point>();
			String str_new1 = str.substring(2,str.length()-2);
			String point_str[] = str_new1.split(",");
			for(String p:point_str) {
				String str_num[] = p.split(" ");
				Point point = new Point();
				point.x=Integer.parseInt(str_num[0]);
				point.y=Integer.parseInt(str_num[1]);
				arrayList.add(point);
			}
			return arrayList;
		}



	}
	public ArrayList<Point> mySplitBlack(String str){
		if (str==null||str.equals("[\"\"]")) {
			return null;
		}
		if (str.length()>7) {
			ArrayList<Point> arrayList = new ArrayList<Point>();
			String str_new1 = str.substring(2,str.length()-2);
			String point_str[] = str_new1.split("\",\"");
			for(String p:point_str) {
				String str_num[] = p.split(" ");
				Point point = new Point();
				point.x=Integer.parseInt(str_num[0]);
				point.y=Integer.parseInt(str_num[1]);
				arrayList.add(point);
			}
			return arrayList;
		}
		else {
			ArrayList<Point> arrayList = new ArrayList<Point>();
			String str_new1 = str.substring(2,str.length()-2);
			String point_str[] = str_new1.split(" ");
			Point point = new Point();
			point.x=Integer.parseInt(point_str[0]);
			point.y=Integer.parseInt(point_str[1]);
			arrayList.add(point);
			return arrayList;
		}
	}
	public int[][] space(String name,ArrayList<Point> list,int[][] chessBoard)//�Ѿ��ߵĺͺڵ��λ�ã�������ʱ��Ϊ1��
	{
		if (name=="init") {
            for (Point p:list)
            {
                chessBoard[p.x][p.y]=5;//��ʾ��λ���Ѿ���ռ��
            }
        }
		if (name=="pstep") {
			for (Point p:list) 
			{
				chessBoard[p.x][p.y]=1;//��ʾ��λ���Ѿ���ռ��
			}
		}

		if (name=="rstep") {
			for (Point p:list) 
			{
				chessBoard[p.x][p.y]=2;//��ʾ��λ���Ѿ���ռ��
			}
		}

		if (name=="pblack") {
			for (Point p:list) 
			{
				chessBoard[p.x][p.y]=3;//��ʾ��λ���Ѿ���ռ��
			}
		}

		if (name=="rblack") {
			for (Point p:list) 
			{
				chessBoard[p.x][p.y]=4;//��ʾ��λ���Ѿ���ռ��
			}
		}
		return chessBoard;
	}
	
	public int parseDATAMAP(ArrayList<String> DATAMAP, String key) {
		for(int i = 0; i < DATAMAP.size(); i++) {
			if (DATAMAP.get(i).contains(key)) {
				return i;
			}
		}
		return -1;
	}
	public String getDATAMAP_JSON(ArrayList<String> DATAMAP, int i) {
		String string = DATAMAP.get(i);
		String result[] = string.split("=");
		
		return result[1];
	}
	
}