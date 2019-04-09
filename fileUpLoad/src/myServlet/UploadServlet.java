package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;

/**
 * Servlet implementation class myServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(location="d:\\Tomcat")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UploadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String path = this.getServletContext().getRealPath("/");
		
		Part p = request.getPart("file1");
		if (p.getContentType().contains("image")) {
			ApplicationPart ap = (ApplicationPart)p;
			String fname1 = ap.getSubmittedFileName();
			int path_idx = fname1.lastIndexOf("\\")+1;
			String fname2 = fname1.substring(path_idx, fname1.length());
			p.write(path+"/upload"+fname2);
			out.write("文件上传成功");
		}
		else {
			out.write("请选择图片文件!!!");
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
