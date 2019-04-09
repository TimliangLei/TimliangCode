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
    
    // �ϴ��ļ��洢Ŀ¼
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // �ϴ�����
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 
    /**
     * �ϴ����ݼ������ļ�
     */
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
    	if (!ServletFileUpload.isMultipartContent(request)) {
			PrintWriter writer = response.getWriter();
			writer.println("Error:���������enctype=multipart/form-data");
			writer.flush();
			return;
		}
    	//�����ϴ�����
    	DiskFileItemFactory factory = new DiskFileItemFactory();
    	//�����ڴ��ٽ�ֵ
    	factory.setSizeThreshold(MEMORY_THRESHOLD);
    	//������ʱĿ¼
    	factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
    	//�ļ��ϴ� 
    	ServletFileUpload upload = new ServletFileUpload(factory);
    	//��������ļ��ϴ�ֵ
    	upload.setFileSizeMax(MAX_FILE_SIZE);
    	//�����������ֵ�������ļ��ͱ����ݣ�
    	upload.setSizeMax(MAX_REQUEST_SIZE);
    	//���Ĵ���
    	upload.setHeaderEncoding("UTF-8");
    	//������ʱ·�����洢�ϴ����ļ�
    	//���·���Ե�ǰӦ�õ�Ŀ¼
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
					//�����������
					if (item.isFormField()) {
						String name = item.getFieldName();
						value = item.getString("utf-8");
						System.out.println("name:"+name+" value:"+value);
						request.setAttribute(name, value);
					}
					else{//����Ǳ�����
						String fileName = item.getName();
						String filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);
						//����̨����ļ�·��
						System.out.println(filePath);
						item.write(storeFile);
						request.setAttribute("fileName", fileName);
						request.setAttribute("message", "�ļ��ϴ��ɹ�");
						
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "������Ϣ��"+e.getMessage());
		}
    	request.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
    	
    }
}
