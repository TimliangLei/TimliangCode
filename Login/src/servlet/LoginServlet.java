package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;

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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("checkCode");
		String saveCode = (String) session.getAttribute("checkCode");
		String rem = request.getParameter("rem");
		PrintWriter pw = response.getWriter();
		//假设正确的用户是itcase密码123
		 if("itcase".equals(username)
				&&"123".equals(password) 
				&& checkCode.equals(saveCode)){
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setRem(rem);
			session.setAttribute("user", user);
			Cookie cookie=null;
			
			cookie = new Cookie("J_SESSION_ID", session.getId());
			
			response.sendRedirect("/Login/IndexServlet");
		}
		else if(checkCode.equals(saveCode))
		{
			pw.write("用户名或密码错误，登录失败");
		}
		else
		{
			pw.write("验证码错误");
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
