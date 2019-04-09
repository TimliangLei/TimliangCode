package product;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.shopDao;

/**
 * Servlet implementation class deleteProduct
 */
@WebServlet("/deleteProduct")
public class deleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errpro = null;
		ServletContext application = request.getServletContext();
		String name = request.getParameter("name");
		shopDao shopDao = new Dao.shopDao();
		if(shopDao.delete(name)){
			errpro = "É¾³ý³É¹¦";
			application.setAttribute("errpro", errpro);
			response.sendRedirect("admin/deleteProduct.jsp");
		}
		else{
			errpro = "É¾³ýÊ§°Ü";
			application.setAttribute("errpro", errpro);
			response.sendRedirect("admin/deleteProduct.jsp");
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
