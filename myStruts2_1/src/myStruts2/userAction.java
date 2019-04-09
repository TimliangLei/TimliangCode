package myStruts2;

import com.opensymphony.xwork2.ActionSupport;

public class userAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String info;
	public String add() throws Exception{
		setInfo("添加用户信息");
		return "add";
	}
	public String update() throws Exception{
		setInfo("修改用户信息");
		return "update";
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
