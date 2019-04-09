package shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.shopDao;
import vo.Flower;

/**
 * Servlet implementation class shop_product
 */
@WebServlet("/shop_product")
public class shop_product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shop_product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 0;
		int page = 1;
		String prepage = request.getParameter("page");
		if (prepage == null) {
			page = 1;
		}
		else{
			page = Integer.parseInt(prepage);
		}
		shopDao shopDao = new shopDao();
		count = shopDao.count();
		System.out.println("count="+count);
		List<Flower> list = shopDao.selectpage(page);
		request.setAttribute("page", page);
		request.setAttribute("count", count);
		request.setAttribute("pagecount", count%3==0?count/3:count/3+1);
		request.setAttribute("list", list);
		request.getRequestDispatcher("shop.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
