package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int WIDTH=100;
	private static int HEIGHT=30;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		response.setContentType("image/jpeg");
		ServletOutputStream sos = response.getOutputStream();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-control", "no-cache");
		response.setHeader("expires", "-1");
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) image.getGraphics();
		char[] rands = generateCheckCode();
		drawBackground(g);
		drawRands(g,rands);
		g.dispose();
		//输出到客户端
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(image, "JPEG", bos);
		byte[] buf = bos.toByteArray();
		response.setContentLength(buf.length);
		sos.write(buf);
		bos.close();
		sos.close();
		session.setAttribute("checkCode", new String(rands));
		System.out.println(new String(rands));
	}

	private void drawRands(Graphics2D g, char[] rands) {
		// TODO Auto-generated method stub
		int x0 = 5;
		int y0 = 22;
		for(int i = 0; i < 4; i++){
			int col_r = (int)(Math.random() * 255);
			int col_g = (int)(Math.random() * 255);
			int col_b = (int)(Math.random() * 255);
			g.setColor(new Color(col_r,col_g,col_b));
			g.setFont(new Font(null, Font.ITALIC | Font.BOLD , 22));
			int r = (int) (Math.random() * 90)-45;
			g.rotate(1.0*r/180*Math.PI, x0+(i*20),y0);
			g.drawString(""+rands[i], x0+(i*20), y0);
			g.rotate(1.0*-r/180*Math.PI, x0+(i*20), y0);
		}
		
	}

	private void drawBackground(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);	
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
		

		for(int i = 0; i < 5; i++){
			int bx = (int)(Math.random() * WIDTH);
			int by = (int)(Math.random() * HEIGHT);
			int ex = (int)(Math.random() * WIDTH);
			int ey = (int)(Math.random() * HEIGHT);
			int col_r = (int)(Math.random() * 255);
			int col_g = (int)(Math.random() * 255);
			int col_b = (int)(Math.random() * 255);
			g.setColor(new Color(col_r,col_g,col_b));
			g.drawLine(bx, by, ex, ey);
		}
	}

	private char[] generateCheckCode() {
		// TODO Auto-generated method stub
		String chars = "0123456789abcdefghigklmnopqrstuvwxyz";
		char[] rands =  new char[4];
		for(int i = 0; i < 4; i++){
			int rand = (int)(Math.random() * 36);
			rands[i] = chars.charAt(rand);
		}
		return rands;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
