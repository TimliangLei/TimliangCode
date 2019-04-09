package Cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.cartDao;
import Dao.shopDao;
import vo.Cart;
import vo.Flower;
import vo.User;

/**
 * Servlet implementation class addCart
 */
@WebServlet("/addCart")
public class addCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String fid_t = request.getParameter("fid");
		String page = request.getParameter("page");
		int fid = Integer.parseInt(fid_t);
		ServletContext application = request.getServletContext();
		String errcart = null;
		Cart cart = new Cart();
		//开始获取相应信息
		User user = (User)session.getAttribute("user");
		shopDao shopDao = new Dao.shopDao();
		Flower flower = (Flower)shopDao.select(fid);
		if(flower != null && user != null){
			cart.setCid(fid);
			cart.setCname(user.getUsername());
			cartDao cartDao = new cartDao();
			if(cartDao.add(cart)){
				if(name.equals("add")){
					errcart="添进入购物车成功";
					application.setAttribute("errcart", errcart);
					response.sendRedirect("shop_product?page="+page);
				}
				else if (name.equals("purchase")) {
					response.sendRedirect("Cart.jsp");
				}
			}
			else{
				errcart = "添加数据库失败，未能添加进购物车";
				application.setAttribute("errcart", errcart);
				response.sendRedirect("shop_product?page="+page);
			}
			
			
		}
		else if(user != null){
			errcart = "商城中没有此类商品，未能添加进购物车";
			application.setAttribute("errcart", errcart);
			response.sendRedirect("shop_product?page="+page);
		}
		else {
			errcart = "您好，您未登录，未能添加进购物车";
			application.setAttribute("errcart", errcart);
			response.sendRedirect("shop_product?page="+page);
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
