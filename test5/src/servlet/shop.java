package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Demo_7
 */
@WebServlet("/shop")
public class shop extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public shop() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	String id=request.getParameter("id");
	
	ArrayList<String> list=null;
	
	HttpSession httpSession=request.getSession();
	//	request.getSession(false);
	
	System.out.println(httpSession.getId());
	list = (ArrayList<String>)httpSession.getAttribute("cart");
	if(list == null)
	{
		System.out.println("session is one generate");
		
		list=new ArrayList<String>();
		
	}
	else {
		
		System.out.println("session is not one generate");
		

	}
	list.add(id);
	httpSession.setAttribute("cart", list);
	/*
	//first
	response.sendRedirect("/test5/cart.jsp");
	
	response.encodeRedirectURL("/test5/cart.jsp");*/
	//second
	String string=response.encodeURL("/test5/cart.jsp");
	
	response.sendRedirect(string);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
