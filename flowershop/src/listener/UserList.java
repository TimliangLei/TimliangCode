package listener;

import java.util.Vector;

public class UserList {
	private static Vector online = new Vector();  
    //添加在线人数  
    public static void addUser(String userName){  
        online.addElement(userName);  
    }  
    //移除在线人数  
    public static void removeUser(String userName){  
        online.removeElement(userName);  
    }  
    //获取在线用户数量  
    public static int getUserCount(){  
        return online.size();  
    }  
    public static Vector getVector(){  
        return online;  
    } 
}
