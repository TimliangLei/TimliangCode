package cn.w3cschool.struts2;

public class HelloWorldAction {
	 private String name;

	   public String execute() throws Exception {
	      return "success";//execute方法来响应用户的动作
	   }
	   
	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }
}

