package product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.CORBA.Request;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import Dao.*;
import vo.Flower;
import vo.User;

/**
 * Servlet implementation class addProduct
 */
@WebServlet("/addProduct")
public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String errpro = null;
		ServletContext application = request.getServletContext();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("utf-8");
		String path;
		String filename = null;
		UUID uid = null;
		List<FileItem> fileItems;
		String name = null;
		String info = null;
		int price = -1;
		int point = -1;
		String fphoto = null;
		try {
			fileItems = sfu.parseRequest(request);
			for (FileItem item : fileItems) {
				if (item.isFormField()){
					String fname = item.getFieldName();
					String fvalue = item.getString("utf-8");
					if(fname.equals("name")){
						name = fvalue;
					}
					else if (fname.equals("info")) {
						info = fvalue;
					}
					else if (fname.equals("price")) {
						price = Integer.parseInt(fvalue);
					}
					else {
						point = Integer.parseInt(fvalue);
					}
				}
				else{
					filename = item.getName();
					path = this.getServletContext().getRealPath("/resourse");
					File path1 = new File(path);
					if (!path1.exists())
						path1.mkdir();
					uid = UUID.randomUUID();
					fphoto = uid.toString() + filename;
					File file = new File(path, fphoto);
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(name!=null && info!=null&&price != -1&&point!=-1){
			Flower flower = new Flower();
			flower.setName(name);
			flower.setInfo(info);
			flower.setPrice(price);
			flower.setPoint(point);
			flower.setFphoto(fphoto);
			shopDao shopDao = new shopDao();
			if(shopDao.add(flower)){
				errpro = "添加成功";
				application.setAttribute("errpro", errpro);
				response.sendRedirect("admin/addProduct.jsp");
			}
			else{
				errpro="与已有的产品名相同，插入失败！！";
				application.setAttribute("errpro", errpro);
				response.sendRedirect("admin/addProduct.jsp");
			}
		}
		else if(name == null){
			errpro="产品名称不能为空，插入失败！！";
			application.setAttribute("errpro", errpro);
			response.sendRedirect("admin/addProduct.jsp");
		}
		else if(info==null){
			errpro="产品介绍不能为空，插入失败！！";
			application.setAttribute("errpro", errpro);
			response.sendRedirect("admin/addProduct.jsp");
		}
		else if (price != -1) {
			errpro="产品价格不能为空，插入失败！！";
			application.setAttribute("errpro", errpro);
			response.sendRedirect("admin/addProduct.jsp");
		}
		else {
			errpro="积分不能为空，插入失败！！";
			application.setAttribute("errpro", errpro);
			response.sendRedirect("admin/addProduct.jsp");
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
