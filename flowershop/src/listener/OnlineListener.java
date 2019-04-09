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
    	System.out.println("�Ự�Ѵ�����");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("�Ự�����٣�");
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  {
    	if(se.getName().equals("user")){
    		UserList.addUser(String.valueOf(se.getValue()));//����һ���û�  
            System.out.println("session("+se.getSession().getId()+")��������"+se.getName()+",ֵΪ"+se.getValue()); 
    	}
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	UserList.removeUser(String.valueOf(se.getValue()));  
        System.out.println(se.getValue()+"�������Ƴ�"); 
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	String oldValue=String.valueOf(se.getValue());//�ɵ�����  
        String newValue=String.valueOf(se.getSession().getAttribute(se.getName()));//�µ�����  
        UserList.removeUser(oldValue);//�Ƴ��ɵ�����  
        UserList.addUser(newValue);//�����µ�����  
        System.out.println(oldValue+"�����Ѹ���Ϊ"+newValue);
    }
	
}
