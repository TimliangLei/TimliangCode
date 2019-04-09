package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkUser
 */
@WebServlet("/checkUser")
public class checkUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public checkUser() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String[] userList = {"明日科技","mr","mrsoft","wgh"};
		String user = new String(request.getParameter("user"));
		System.out.println(user);
		Arrays.sort(userList);
		int result = Arrays.binarySearch(userList, user);
		PrintWriter out  = response.getWriter();
		if (result>-1) {
			out.println("很抱歉，该用户已经注册");
			System.out.println("很抱歉，该用户已经注册");
		}
		else {
			out.println("恭喜您，该用户名没有被注册");
			System.out.println("恭喜您，该用户名没有被注册");
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
