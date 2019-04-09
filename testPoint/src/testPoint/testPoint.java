package testPoint;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class testPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Point p = new Point();
		p.x=1;p.y=2;
		System.out.println("p.x:"+p.x);
		System.out.println("p.y:"+p.y);
		ArrayList<Point> robotChessList = new ArrayList<Point>();
		robotChessList.add(p);
		p=new Point(4, 5);
		robotChessList.add(p);
		p=new Point(7, 8);
		robotChessList.add(p);
		
		String black_json="";
		for (int i=0;i<3;i++){
			black_json = black_json+robotChessList.get(i).x+" "+ robotChessList.get(i).y+",";
		}
		black_json=black_json.substring(0,black_json.length()-1);
		System.out.println(black_json);
		Random random = new Random();
		for(int i=0; i<20; i++) {
			System.out.println(random.nextInt(4));
		}
	}

}
