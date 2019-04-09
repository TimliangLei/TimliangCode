package vo;

public class Check {
	private int id;
	private int checkid;
	private String username;
	private int num;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCheckid() {
		return checkid;
	}
	public void setCheckid(int checkid) {
		this.checkid = checkid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Check [id=" + id + ", checkid=" + checkid + ", username=" + username + ", num=" + num + "]";
	}
	
}
