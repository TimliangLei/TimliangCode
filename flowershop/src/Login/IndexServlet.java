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
					"����û�е�¼����<a href='login.jsp'>��½,2s���Զ�ת��</a>");
			response.setHeader("Refresh", "2;url=login.jsp");
		}
		else
		{
			response.getWriter().println("�û�����"+user.getUsername()+"<br/>"+
											"�û����룺"+user.getPassword()+"<br/>"+
											"�Ƿ��ס���룺"+user.getRem()+"<br/>"+
											"�û���ݣ�"+user.getIdentity()+"<br/>");
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
				response.getWriter().print("<a href='shop_product'>��ϲ������½�ɹ�����ӭǰ������,2s���Զ�ת��</a>");
				response.setHeader("Refresh", "2;url=shop_product");
			}
			else{
				response.getWriter().print("<a href='admin.jsp'>����Ա���ã���ӭ������Ʒ,2s���Զ�ת��</a>");
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
