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
		JspContext js=this.getJspContext();//获取SimpleTagSupport类中传入到JspContext里面的数值即获取标签内部的内容比如name
		JspFragment jg=this.getJspBody();//获取SimpleTagSupport类中传入到JspFragment里面的数值即获取标签之间的内容
		JspWriter out=js.getOut();
		
		if(size.equals("true")){
			jg.invoke(null);
			
		}
		
	}
	

}
