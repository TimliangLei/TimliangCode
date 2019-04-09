package Cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.FcartDao;
import Dao.cartDao;
import vo.Cart;
import vo.Fcart;

/**
 * Servlet implementation class addSelf
 */
@WebServlet("/addSelf")
public class addSelf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSelf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid_str = request.getParameter("cid");
		String num_str = request.getParameter("num");
		String cname = request.getParameter("cname");
		String name = request.getParameter("name");
		int cid = Integer.parseInt(cid_str);
		int num = Integer.parseInt(num_str);
		cartDao cartDao = new cartDao();
		Cart cart = new Cart();
		cart.setCid(cid);
		cart.setCname(cname);
		if (num-1 == 0 && name.equals("decrease")) {
			cartDao.delete(cid,cname);
			response.sendRedirect("Cart.jsp");
		}
		else{
			if(name.equals("add")){
				cart.setNum(num+1);
			}
			else
			{
				
				cart.setNum(num-1);
			}
			cartDao.update(cart);
			response.sendRedirect("Cart.jsp");
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
