package Check;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CheckDao;
import Dao.cartDao;
import vo.Cart;

/**
 * Servlet implementation class Check
 */
@WebServlet("/toCheck")
public class toCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static int checkid= 0;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cname = request.getParameter("cname");
		cartDao cartDao = new cartDao();
		CheckDao checkDao = new CheckDao();
		Cart cart = new Cart();
		cart.setCname(cname);
		List<Cart> list = cartDao.selectAll(cart);
		for (Cart cart2 : list) {
			checkDao.add(cart2, checkid);
			cartDao.delete(cart2.getCid(), cart2.getCname());
		}
		checkid++;
		response.sendRedirect("Check.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
