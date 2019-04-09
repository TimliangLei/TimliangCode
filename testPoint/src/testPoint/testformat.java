package testPoint;

import java.util.ArrayList;

public class testformat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> NAMELIST = new ArrayList<String>();
		NAMELIST.add("123");
		NAMELIST.add("456");
		String json_namelist = "\"pstep\":[";
		for(String str:NAMELIST) {
			json_namelist+= "\""+str+"\",";
		}
		json_namelist = json_namelist.substring(0, json_namelist.length()-1)+"]";
		System.out.println(json_namelist);
	}

}
