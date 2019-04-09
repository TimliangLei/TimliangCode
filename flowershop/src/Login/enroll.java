package Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import Dao.*;
import vo.User;

/**
 * Servlet implementation class enroll
 */
@WebServlet("/enroll")
public class enroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enroll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = request.getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		userDao userDao = new userDao();
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String identity = request.getParameter("identity");
		String errlog = null;
		if(password1.equals(password2)){
			String password = password1;
			User user = new User();
			user.setIdentity(identity);
			user.setPassword(password);
			user.setUsername(username);
			
			if (userDao.add(user)) {
				out.println("�û�����"+username+"<br/>");
				out.println("���룺"+password+"<br/>");
				out.println("���� ��"+identity+"<br/>");
				application.setAttribute("errlog", errlog);
				out.print("<a href='login.jsp'>2s��ת������½ҳ��</a>");
				response.setHeader("Refresh", "2;url=login.jsp");
			}
			else{
				errlog="�û��Ѵ���";
				application.setAttribute("errlog", errlog);
				response.sendRedirect("login.jsp");
			}
		}
		else{
			errlog = "�����������벻ͬ����";
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
