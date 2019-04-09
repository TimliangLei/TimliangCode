package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IndexServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user==null){
			response.getWriter().print(
					"Äú»¹Ã»ÓÐµÇÂ¼£¬Çë<a href='/Login/Login.jsp'>µÇÂ½</a>");
		}
		else
		{
			response.getWriter().println(user.toString());
			response.getWriter().print(
					"ÄúÒÑµÇÂ½£¬Çë<a href='/Login/LogoutServlet'>ÍË³ö</a>");
			
			Cookie cookie = null;
			session.setAttribute("user", user);
			if(user.getRem().equals("1")){
				cookie = new Cookie("J_SESSION_ID", user.toString()+"#"+session.getId());
			}
			else{
				cookie = new Cookie("J_SESSION_ID", session.getId());
			}
			cookie.setMaxAge(60*60);
			cookie.setPath("/Login");
			response.addCookie(cookie);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
