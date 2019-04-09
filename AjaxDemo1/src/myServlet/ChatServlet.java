package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatServlet
 */
@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.println("[");
		/********************聊天信息*******************/
		ServletContext application = getServletContext();
		if (null!=application.getAttribute("message")) {
			Vector<String> v_temp = (Vector<String>)application.getAttribute("message");
			String msg = "";
			for(int i=v_temp.size()-1;i>=0;i--) {
				msg+="{\"message\":\""+v_temp.get(i)+"\"},";
			}
			out.println(msg.substring(0,msg.length()-1));
		}
		else {
			out.println("{\"message\":\"欢迎光临碧海聆音聊天室！\"}");
		}
		out.println("]");
		out.flush();
		out.close();
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sendmsg(request,response);
	}

	protected void sendmsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = getServletContext();
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String speak = request.getParameter("speak");
		Vector<String> vector = null;
		String message = "["+user+"]说"+speak;
		if (null == application.getAttribute("message")) {
			vector = new Vector<String>();
		}
		else {
			vector = (Vector<String>)application.getAttribute("message");
		}
		vector.add(message);
		application.setAttribute("message", vector);
		
		
		
	}

	

}
