package vo;

public class Cart {
	private int cid;
	private String cname;
	private int num;
	
	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", cname=" + cname + ", num=" + num + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
