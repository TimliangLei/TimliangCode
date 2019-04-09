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
	
	private static final String CLEARSERVICE = "clearService";//����Է���resultֵ
	private static final String CLEARCLIENT = "clearClient";//����Է���resultֵ	
	private static final String CLIENTCLOSE = "clientClose";//�ͻ����˳���־
	private static final String SERVICECLOSE = "serviceClose";//������˳���־	
	private static final String CLIENT_CONET = "client_conet";//�ͻ��������ϱ�־
	private static final String SERVICE_CONET = "service_conet";//����������ϱ�־
	private static final String SERVICEZERO = "servicezero";//����˹�0��־
	private static final String CLIENTZERO = "clientzero";//�ͻ��˹�0��־

	private PrintWriter outService;
	private PrintWriter outClient;


	private String x = null,y = null;//��������(����ˣ����ͻ���)���͹���������ַ�������
	boolean flag1 = true;//����˿��Ʊ���
	boolean flag2 = false;
	boolean flag3 = false;
	
	boolean flag4 = true;//�ͻ��˿��Ʊ���
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
		request.setCharacterEncoding("utf-8");//��������������뼯
		response.setCharacterEncoding("utf-8");
		
		outService = response.getWriter();//��ȡ����������ʱ�����������
		outClient = response.getWriter();


		String name = request.getParameter("name");	//��ȡÿ������Servletʱ�Ķ�������ֵ			
		String num = request.getParameter("num");	
		
		//���������ȡ����nameֵ��������ͬ�Ĳ�������
		if(CLEARSERVICE.equals(name)){//������ӹ������Ƿ���˶ԣ�ǰ����y��ֵ����0��־
			System.out.println("����˶�y��null");			
			y = null;
		}
		if(CLEARCLIENT.equals(name)){//������ӹ������ǿͻ��ˣ�ǰ����x��ֵ����0��־
			System.out.println("����˶�x��null");			
			x = null;
		}
		
		
		
		if(SERVICEZERO.equals(name)){//������ӹ������Ƿ����,ÿһ������ʱ���Ա������в�����0��־
			System.out.println("����˶Բ�����0");
			x = null;
			y = null;
			flag1 = true;
			flag2 = false;
			flag3 = false;
		}

		if(CLIENTZERO.equals(name)){//������ӹ������Ƿ����,ÿһ������ʱ���Ա������в�����0��־
			System.out.println("�ͻ��˶Բ�����0");
			x = null;
			y = null;
			flag4 = true;
			flag5 = false;
			flag6 = false;
		}
		if(SERVICE.equals(name)){//������ӹ������Ƿ����,�������ӣ��������岽���ַ��������ģ����ַ����浽x
			System.out.println("�����");
			if(num!=null){//��һ�δ�����ֵ�����ǿ�
				//��һ����־������ת����˺Ϳͻ��˵����ӣ��ֵ�˭��˭��������
				x = num;
			}
		}

		if(SERVICEREAD.equals(name)){//������ӹ������Ƿ���˶�ȡ����(��ѭ����ȡ),ͨ����ȡ�ز�ͬ����Ϣ������ͬ������
			System.out.println("����˶�ȡ");
			
			if(flag4){//����˵�һ�����ӽ�����ֻ��һ�ε�ѭ������flag5��Ϊtrue,��ʾ���������������
				flag4 = false;
				flag5 = true;
			}
			
			
			if(flag2){//ֻ�е��ͻ����������ˣ����ѭ�����ܽ��룬����һ����Ϣ�ظ�����ˣ�˵�ͻ�����������
				flag2 = false;
				outService.print(CLIENT_CONET);
				outService.flush();
				outService.close();				
			}
			if(flag3){//���Է��쳣�˳�ʱ�������ѭ�����ܽ��룬����һ����Ϣ�ظ�����ˣ�˵�Է��쳣�˳�
				flag3 = false;
				outService.print(CLIENTCLOSE);
				outService.flush();
				outService.close();	
			}			
			
			if(y!=null){//���������岽����ַ���������Чʱ������һ����Ϣ�ظ�����ˣ��ѶԷ�������ַ�������ȥ
				outService.print(y);
				outService.flush();
				outService.close();
			}else{//����Чʱ������NO��ȥ��������д���
				outService.print(NO);
				outService.flush();
				outService.close();

			}


		}
		if(CLIENT.equals(name)){//������ӹ������ǿͻ�,�������ӣ��������岽���ַ��������ģ����ַ����浽y
			System.out.println("�ͻ���");
			if(num!=null){//��һ�δ�����ֵ�����ǿ�
				//��һ����־������ת����˺Ϳͻ��˵����ӣ��ֵ�˭��˭��������
				y = num;
			}

		}
		
		
		if(CLIENTREAD.equals(name)){//������ӹ������ǿͻ��˶�ȡ����(��ѭ����ȡ),ͨ����ȡ�ز�ͬ����Ϣ������ͬ������
			System.out.println("�ͻ��˶�ȡ");		
			
			if(flag1){//�ͻ��˵�һ�����ӽ�����ֻ��һ�ε�ѭ������flag2��Ϊtrue,��ʾ�ͻ�������������
				flag1 = false;
				flag2 = true;
			}
			if(flag5){//ֻ�е�������������ˣ����ѭ�����ܽ��룬����һ����Ϣ�ظ��ͻ��ˣ�˵�������������
				flag5 = false;
				outClient.print(SERVICE_CONET);
				outClient.flush();
				outClient.close();				
			}
			if(flag6){//���Է��쳣�˳�ʱ�������ѭ�����ܽ��룬����һ����Ϣ�ظ�����ˣ�˵�Է��쳣�˳�
				flag6 = false;
				outClient.print(CLIENTCLOSE);
				outClient.flush();
				outClient.close();	
			}
			
			if(x!=null){//���������岽����ַ���������Чʱ������һ����Ϣ�ظ��ͻ��ˣ��ѶԷ�������ַ�������ȥ
				outClient.print(x);
				outClient.flush();
				outClient.close();
			}else{	//����Чʱ������NO��ȥ��������д���			
				outClient.print(NO);	
				outClient.flush();
				outClient.close();
			
			}
		}
		if(CLIENTCLOSE.equals(name)){//�ͻ��˹رմ������ı�־
			flag3 = true;
		}
		if(SERVICECLOSE.equals(name)){//�ͻ��˹رմ������ı�־
			flag6 = true;
		}
	}

}
