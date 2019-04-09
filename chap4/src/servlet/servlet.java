package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String path = this.getServletContext().getRealPath("resource/1.jpg")
		String path = this.getClass().getClassLoader().getResource("../../resource/1.jpg").getPath();
		System.out.println(path);
		response.setHeader("content-type", "image/jpg");//image/jpeg
		response.setHeader("Content-Disposition", "attachment;filename=aa");
		ServletOutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(path);
		byte[] b = new byte[1024];
		int len = 0;
		while((len = in.read(b))>0)
		{
			out.write(b,0,len);
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
