package test;

import java.awt.Point;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
	private ArrayList<String> list =null;
	private String USERID = "userid";
	private String CHESS_STEP="chess_step";
	private int ROW = 10;
	private int COL = 10;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public test() {
		list = new ArrayList<String>();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String commond =new String(request.getParameter("commond"));
		String value =new String(request.getParameter("value"));
		System.out.println(commond+":"+value);
		//初始化对象参数
		int i = 1;

		if (commond.equals(USERID)) {
			i++;
			out.print(i);
		}
		if (commond.equals(CHESS_STEP)) {
			i++;
			out.print(i);
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
