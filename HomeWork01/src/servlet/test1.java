package servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test1
 */

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
		//response.setContentType("text/html;charset=utf-8");
		
		String data = "asdvsadfcadsfccxbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
		System.out.println("原始数据大小为："+data.getBytes().length);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		GZIPOutputStream gOutputStream = new GZIPOutputStream(bout);
		gOutputStream.write(data.getBytes());
		gOutputStream.close();
		byte g[] = bout.toByteArray();
		response.setHeader("Content-Encoding", "gzip");
		response.setHeader("Content-Length", g.length+"");
		System.out.println("压缩后数据大小为："+g.length);
		
		response.getOutputStream().write(g);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
