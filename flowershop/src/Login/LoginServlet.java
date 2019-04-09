package Login;

import java.applet.AppletContext;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.omg.CORBA.portable.ApplicationException;
import Dao.userDao;
import vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String identity = request.getParameter("identity");
		String errlog = null;
		String checkCode = request.getParameter("checkCode");
		String saveCode = (String) session.getAttribute("checkCode");
		
		String rem = request.getParameter("rem");
		
		userDao userDao = new userDao();
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setIdentity(identity);
		if (rem==null) {
			rem = "0";
		}
		user.setRem(rem);
		
		if((boolean)userDao.select(user) && checkCode.equals(saveCode)){
			session.setAttribute("user", user);
			Cookie cookie=null;
			cookie = new Cookie("J_SESSION_ID", session.getId());
			application.setAttribute("errlog", errlog);
			response.sendRedirect("IndexServlet");
		}
		else if(checkCode.equals(saveCode))
		{
			errlog = "ÓÃ»§Ãû»òÃÜÂë´íÎó£¬µÇÂ¼Ê§°Ü";
			application.setAttribute("errlog", errlog);
			response.sendRedirect("login.jsp");
		}
		else
		{
			errlog = "ÑéÖ¤Âë´íÎó";
			application.setAttribute("errlog", errlog);
			response.sendRedirect("login.jsp");
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
