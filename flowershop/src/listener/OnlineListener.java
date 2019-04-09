package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineListener
 *
 */
@WebListener
public class OnlineListener implements HttpSessionListener, HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public OnlineListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("会话已创建！");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("会话已销毁！");
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  {
    	if(se.getName().equals("user")){
    		UserList.addUser(String.valueOf(se.getValue()));//增加一个用户  
            System.out.println("session("+se.getSession().getId()+")增加属性"+se.getName()+",值为"+se.getValue()); 
    	}
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	UserList.removeUser(String.valueOf(se.getValue()));  
        System.out.println(se.getValue()+"属性已移除"); 
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	String oldValue=String.valueOf(se.getValue());//旧的属性  
        String newValue=String.valueOf(se.getSession().getAttribute(se.getName()));//新的属性  
        UserList.removeUser(oldValue);//移除旧的属性  
        UserList.addUser(newValue);//增加新的属性  
        System.out.println(oldValue+"属性已更改为"+newValue);
    }
	
}
