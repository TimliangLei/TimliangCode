package testPoint;

import java.util.UUID;

public class testHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "ltl";
		String id = UUID.randomUUID().toString();
		String IdAndName = id+"_"+name;
		System.out.println(IdAndName);
		System.out.println(IdAndName.substring(IdAndName.lastIndexOf("_")+1,IdAndName.length()));
	}

}
