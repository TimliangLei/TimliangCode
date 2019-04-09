package servlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.LineListener;

/**
 * Servlet implementation class test2
 */

public class test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = this.getServletContext().getRealPath("resource/1.jpg");
		File file = new File(path);
		response.setContentType("text/html;charset=utf-8");
		FileInputStream inputStream = new FileInputStream(path);
		System.out.println("原始数据大小为："+file.length());
		
		String pathz = this.getServletContext().getRealPath("resource/a1.zip");
		File filez = new File(pathz);
		FileOutputStream fout = new FileOutputStream(pathz);
		GZIPOutputStream gOutputStream = new GZIPOutputStream(fout);
		byte b[] = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(b))>0) {
			gOutputStream.write(b, 0, len);
		}
		long g = filez.length();
		System.out.println("压缩后数据大小为："+g);
		response.setHeader("Content-Encoding", "gzip");
		gOutputStream.close();
		inputStream.close();
		fout.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
