package cn.w3cshool.struts2;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String name;
	public static final String SUCCESS = "success";
	public static final String NONE = "none";
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String LOGIN = "login";
	public String execute() throws Exception{
		if ("SECRET".equals(name)) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
