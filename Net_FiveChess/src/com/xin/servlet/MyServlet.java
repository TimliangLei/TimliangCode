package com.xin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SERVICE = "service";
	private static final String SERVICEREAD = "serviceRead";
	private static final String CLIENT = "client";
	private static final String CLIENTREAD = "clientread";
	private static final String NO = "no";	
	
	private static final String CLEARSERVICE = "clearService";//清除对方的result值
	private static final String CLEARCLIENT = "clearClient";//清除对方的result值	
	private static final String CLIENTCLOSE = "clientClose";//客户端退出标志
	private static final String SERVICECLOSE = "serviceClose";//服务端退出标志	
	private static final String CLIENT_CONET = "client_conet";//客户端连接上标志
	private static final String SERVICE_CONET = "service_conet";//服务端连接上标志
	private static final String SERVICEZERO = "servicezero";//服务端归0标志
	private static final String CLIENTZERO = "clientzero";//客户端归0标志

	private PrintWriter outService;
	private PrintWriter outClient;


	private String x = null,y = null;//用来缓存(服务端－－客户端)发送过来下棋的字符串变量
	boolean flag1 = true;//服务端控制变量
	boolean flag2 = false;
	boolean flag3 = false;
	
	boolean flag4 = true;//客户端控制变量
	boolean flag5 = false;
	boolean flag6 = false;
	
	public MyServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doPost(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//设置输入输出编码集
		response.setCharacterEncoding("utf-8");
		
		outService = response.getWriter();//获取服务器连接时的输出流对象
		outClient = response.getWriter();


		String name = request.getParameter("name");	//获取每次连接Servlet时的对象名和值			
		String num = request.getParameter("num");	
		
		//根据上面获取到的name值，做出不同的操作处理
		if(CLEARSERVICE.equals(name)){//如果连接过来的是服务端对（前参数y的值）清0标志
			System.out.println("服务端对y归null");			
			y = null;
		}
		if(CLEARCLIENT.equals(name)){//如果连接过来的是客户端（前参数x的值）清0标志
			System.out.println("服务端对x归null");			
			x = null;
		}
		
		
		
		if(SERVICEZERO.equals(name)){//如果连接过来的是服务端,每一次连接时，对本方所有参数归0标志
			System.out.println("服务端对参数清0");
			x = null;
			y = null;
			flag1 = true;
			flag2 = false;
			flag3 = false;
		}

		if(CLIENTZERO.equals(name)){//如果连接过来的是服务端,每一次连接时，对本方所有参数归0标志
			System.out.println("客户端对参数清0");
			x = null;
			y = null;
			flag4 = true;
			flag5 = false;
			flag6 = false;
		}
		if(SERVICE.equals(name)){//如果连接过来的是服务端,正常连接，带着下棋步骤字符串过来的，把字符串存到x
			System.out.println("服务端");
			if(num!=null){//第一次传进来值可能是空
				//用一个标志，来轮转服务端和客户端的连接，轮到谁，谁才起做用
				x = num;
			}
		}

		if(SERVICEREAD.equals(name)){//如果连接过来的是服务端读取程序(死循环读取),通过读取回不同的信息做出不同的做作
			System.out.println("服务端读取");
			
			if(flag4){//服务端第一次连接进来，只进一次的循环，把flag5改为true,表示服务端以连接上了
				flag4 = false;
				flag5 = true;
			}
			
			
			if(flag2){//只有当客户端连接上了，这个循环才能进入，发送一个信息回给服务端，说客户端以连接上
				flag2 = false;
				outService.print(CLIENT_CONET);
				outService.flush();
				outService.close();				
			}
			if(flag3){//当对方异常退出时，，这个循环才能进入，发送一个信息回给服务端，说对方异常退出
				flag3 = false;
				outService.print(CLIENTCLOSE);
				outService.flush();
				outService.close();	
			}			
			
			if(y!=null){//当缓存下棋步骤的字符串参数有效时，发送一个信息回给服务端，把对方下棋的字符串发过去
				outService.print(y);
				outService.flush();
				outService.close();
			}else{//当无效时，发个NO回去，对面进行处理
				outService.print(NO);
				outService.flush();
				outService.close();

			}


		}
		if(CLIENT.equals(name)){//如果连接过来的是客户,正常连接，带着下棋步骤字符串过来的，把字符串存到y
			System.out.println("客户端");
			if(num!=null){//第一次传进来值可能是空
				//用一个标志，来轮转服务端和客户端的连接，轮到谁，谁才起做用
				y = num;
			}

		}
		
		
		if(CLIENTREAD.equals(name)){//如果连接过来的是客户端读取程序，(死循环读取),通过读取回不同的信息做出不同的做作
			System.out.println("客户端读取");		
			
			if(flag1){//客户端第一次连接进来，只进一次的循环，把flag2改为true,表示客户端以连接上了
				flag1 = false;
				flag2 = true;
			}
			if(flag5){//只有当服务端连接上了，这个循环才能进入，发送一个信息回给客户端，说服务端以连接上
				flag5 = false;
				outClient.print(SERVICE_CONET);
				outClient.flush();
				outClient.close();				
			}
			if(flag6){//当对方异常退出时，，这个循环才能进入，发送一个信息回给服务端，说对方异常退出
				flag6 = false;
				outClient.print(CLIENTCLOSE);
				outClient.flush();
				outClient.close();	
			}
			
			if(x!=null){//当缓存下棋步骤的字符串参数有效时，发送一个信息回给客户端，把对方下棋的字符串发过去
				outClient.print(x);
				outClient.flush();
				outClient.close();
			}else{	//当无效时，发个NO回去，对面进行处理			
				outClient.print(NO);	
				outClient.flush();
				outClient.close();
			
			}
		}
		if(CLIENTCLOSE.equals(name)){//客户端关闭传过来的标志
			flag3 = true;
		}
		if(SERVICECLOSE.equals(name)){//客户端关闭传过来的标志
			flag6 = true;
		}
	}

}
