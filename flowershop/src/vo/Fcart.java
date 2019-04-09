package vo;

import java.util.jar.Attributes.Name;

public class Fcart {
	@Override
	public String toString() {
		return "Fcart [cid=" + cid + ", num=" + num + ", cname=" + cname + ", name=" + name + ", info=" + info
				+ ", price=" + price + ", point=" + point + ", fphoto=" + fphoto + "]";
	}
	private int cid;
	private int num;
	private String cname;
	private String name;
	private String info;
	private int price;
	private int point;
	private String fphoto;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
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
	
	
}
