package test_stu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * Servlet implementation class test1
 */
@WebServlet("/test1")
public class test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
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
		request.setAttribute("page", page);
		request.setAttribute("count", count);
		request.setAttribute("pagecount", count%3==0?count/3:count/3+1);
		//request.getRequestDispatcher("getdata");
		//List<test_stu> list = stuDao.selectAll();
		ArrayList<test_stu> list = (ArrayList<test_stu>) session.getAttribute("list");
		System.out.println(list.size());
		ArrayList<test_stu> arrayList = new ArrayList<test_stu>();
		arrayList.addAll(list);
		ListIterator<test_stu> iterator= arrayList.listIterator(page-1);
		List<test_stu> resultlist = new ArrayList<test_stu>();
		for(int i = 0;i < 3;i++) {
			resultlist.add(iterator.next());
			
		}
		request.setAttribute("list", resultlist);
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
