package vo;

public class Flower {
	private int fid;
	private String name;
	private String info;
	private int price;
	private int point;
	private String fphoto;
	public String getFphoto() {
		return fphoto;
	}
	public void setFphoto(String fphoto) {
		this.fphoto = fphoto;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
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
	@Override
	public String toString() {
		return "Flower [fid=" + fid + ", name=" + name + ", info=" + info + ", price=" + price + ", point=" + point
				+ ", fphoto=" + fphoto + "]";
	}
	
	
	
}
