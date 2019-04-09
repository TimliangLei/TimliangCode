package vo;

public class Fcheck {
	private int pid;
	private int checkid;
	private String username;
	private int num;
	private String name;
	private String info;
	private int price;
	private int point;
	private String fphoto;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getFphoto() {
		return fphoto;
	}
	public void setFphoto(String fphoto) {
		this.fphoto = fphoto;
	}
	@Override
	public String toString() {
		return "Fcheck [pid=" + pid + ", checkid=" + checkid + ", username=" + username + ", num=" + num + ", name="
				+ name + ", info=" + info + ", price=" + price + ", point=" + point + ", fphoto=" + fphoto + "]";
	}
	
}
