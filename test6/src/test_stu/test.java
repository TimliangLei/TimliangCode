package test_stu;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.rmi.CORBA.Stub;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int count = 0;
		int page = 1;
		String prepage = request.getParameter("page");
		if (prepage == null) {
			page = 1;
		}
		else{
			page = Integer.parseInt(prepage);
		}
		test_stuDao stuDao = new test_stuDao();
		count = stuDao.count();
		List<test_stu> list = stuDao.selectpage(page);
		request.setAttribute("page", page);
		request.setAttribute("count", count);
		request.setAttribute("pagecount", count%3==0?count/3:count/3+1);
		request.setAttribute("list", list);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
