package Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.User;

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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user==null){
			response.getWriter().print(
					"您还没有登录，请<a href='login.jsp'>登陆,2s后自动转跳</a>");
			response.setHeader("Refresh", "2;url=login.jsp");
		}
		else
		{
			response.getWriter().println("用户名："+user.getUsername()+"<br/>"+
											"用户密码："+user.getPassword()+"<br/>"+
											"是否记住密码："+user.getRem()+"<br/>"+
											"用户身份："+user.getIdentity()+"<br/>");
			Cookie cookie = null;
			session.setAttribute("user", user);
			if(user.getRem().equals("1")){
				cookie = new Cookie("J_SESSION_ID", user.toString()+"#"+session.getId());
			}
			else{
				cookie = new Cookie("J_SESSION_ID", session.getId());
			}
			cookie.setMaxAge(60*60*2);
			cookie.setPath("/flowershop");
			response.addCookie(cookie);
			if(user.getIdentity().equals("0")){
				response.getWriter().print("<a href='shop_product'>恭喜，您登陆成功，欢迎前来购物,2s后自动转跳</a>");
				response.setHeader("Refresh", "2;url=shop_product");
			}
			else{
				response.getWriter().print("<a href='admin.jsp'>管理员您好，欢迎管理商品,2s后自动转跳</a>");
				response.setHeader("Refresh", "2;url=admin.jsp");
			}
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
