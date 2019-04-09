package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * Servlet implementation class LoadUp
 */
@WebServlet("/LoadUp")
public class LoadUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("utf-8");
		String value = null;
		String path = null;
		String filename = null;
		UUID uid = null;
		List<FileItem> fileItems;
		try {
			fileItems = sfu.parseRequest(request);
			
			for (FileItem item : fileItems) {
				if (item.isFormField()) {
					String name = item.getFieldName();
					value = item.getString("utf-8");
					System.out.println("name=" + name + "   value=" + value);
				} 
				else 
				{
					filename = item.getName();
					path = this.getServletContext().getRealPath("/upload");
					File path1 = new File(path);
					if (!path1.exists())
						path1.mkdir();
					uid = UUID.randomUUID();
					File file = new File(path, uid.toString() + filename);
					FileOutputStream fout = new FileOutputStream(file);
					InputStream in = item.getInputStream();
					byte[] b = new byte[1024];
					int len = 0;
					while ((len = in.read(b)) > 0) {
						fout.write(b, 0, len);
					}
					System.out.println("picture");
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
