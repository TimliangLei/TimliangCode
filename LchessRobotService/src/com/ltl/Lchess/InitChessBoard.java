package com.ltl.Lchess;

import java.awt.Point;
import java.util.ArrayList;

public class InitChessBoard {
	private ArrayList<Point> black_chess_list;//ÿ��Ԫ�ش洢����Ϊ1 2,4 5,7 8
    public InitChessBoard() {
        black_chess_list = new ArrayList<Point>();
    }
    public void appendBlack_chess(ArrayList<Point> points) {
        //��Ϊ׷�ӷ���
        if (points == null) {
            return;
        }
        for(Point point:points) {
            this.black_chess_list.add(point) ;
        }
    }
    public String getBlack_chess() {
        //���������ʽ
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
    public void setBlack_chess_list(ArrayList<Point> black_chess_list) {
        if (black_chess_list==null) {
            return;
        }
        this.black_chess_list = black_chess_list;
    }
    public ArrayList<Point> getBlack_chess_list() {
        return black_chess_list;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\n�������ɴ��λ�ã�"+this.getBlack_chess();
    }

}