package test;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
public class biaopian extends SimpleTagSupport {
	String size="";
	

	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public void doTag() throws JspException, IOException {
		super.doTag();
		JspContext js=this.getJspContext();//��ȡSimpleTagSupport���д��뵽JspContext�������ֵ����ȡ��ǩ�ڲ������ݱ���name
		JspFragment jg=this.getJspBody();//��ȡSimpleTagSupport���д��뵽JspFragment�������ֵ����ȡ��ǩ֮�������
		JspWriter out=js.getOut();
		
		if(size.equals("true")){
			jg.invoke(null);
			
		}
		
	}
	

}
