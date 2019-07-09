package cn.ccnu.wpy.pojo;

public class Product {
	private int id;
	private String name;
	private int categoryid;
	private int num;
	private double price;
	private String  desc;
	private String imagUrl;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImagUrl() {
		return imagUrl;
	}

	public void setImagUrl(String imagUrl) {
		this.imagUrl = imagUrl;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, int categoryid, int num, double price) {
		super();
		this.id = id;
		this.name = name;
		this.categoryid = categoryid;
		this.num = num;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
