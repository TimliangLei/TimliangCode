package testPoint;

import java.awt.Point;
import java.util.ArrayList;

public class testPoint1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point();
		p.x=1;p.y=2;
		System.out.println("p.x:"+p.x);
		System.out.println("p.y:"+p.y);
		ArrayList<Point> isBlack = new ArrayList<Point>();
		isBlack.add(p);
		p=new Point(4, 5);
		isBlack.add(p);
		p=new Point(7, 8);
		isBlack.add(p);
		
		String black_json="";
		for (Point b : isBlack) {
			black_json = black_json+b.x+" "+ b.y+",";
		}
		black_json=black_json.substring(0,black_json.length()-1);
		System.out.println(black_json);
		
	}

}
