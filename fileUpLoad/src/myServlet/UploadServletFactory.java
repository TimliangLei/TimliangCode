package myServlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class UploadServletFactory
 */
@WebServlet("/UploadServletFactory")
public class UploadServletFactory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 
    /**
     * 上传数据及保存文件
     */
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
    	if (!ServletFileUpload.isMultipartContent(request)) {
			PrintWriter writer = response.getWriter();
			writer.println("Error:表单必须包括enctype=multipart/form-data");
			writer.flush();
			return;
		}
    	//配置上传参数
    	DiskFileItemFactory factory = new DiskFileItemFactory();
    	//设置内存临界值
    	factory.setSizeThreshold(MEMORY_THRESHOLD);
    	//设置临时目录
    	factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
    	//文件上传 
    	ServletFileUpload upload = new ServletFileUpload(factory);
    	//设置最大文件上传值
    	upload.setFileSizeMax(MAX_FILE_SIZE);
    	//设置最大请求值（包含文件和表单数据）
    	upload.setSizeMax(MAX_REQUEST_SIZE);
    	//中文处理
    	upload.setHeaderEncoding("UTF-8");
    	//构造临时路径来存储上传的文件
    	//这个路径对当前应用的目录
    	String uploadPath = request.getServletContext().getRealPath("")+UPLOAD_DIRECTORY;
    	File uploadDir = new File(uploadPath);
    	if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
    	String value = null;
    	try {
			List<FileItem> formItems = upload.parseRequest(request);
			if (formItems != null && formItems.size()>0) {
				for(FileItem item:formItems) {
					//处理表单中数据
					if (item.isFormField()) {
						String name = item.getFieldName();
						value = item.getString("utf-8");
						System.out.println("name:"+name+" value:"+value);
						request.setAttribute(name, value);
					}
					else{//处理非表单数据
						String fileName = item.getName();
						String filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);
						//控制台输出文件路径
						System.out.println(filePath);
						item.write(storeFile);
						request.setAttribute("fileName", fileName);
						request.setAttribute("message", "文件上传成功");
						
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "错误信息："+e.getMessage());
		}
    	request.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
    	
    }
}
