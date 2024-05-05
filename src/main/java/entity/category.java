package entity;

public class category {
	private String id;
	private String name;
	private int totalProduct;
	
	public category(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public category(String id, String name, int totalProduct) {
		super();
		this.id = id;
		this.name = name;
		this.totalProduct = totalProduct;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalProduct() {
		return totalProduct;
	}
	public void setTotalProduct(int totalProduct) {
		this.totalProduct = totalProduct;
	}
	@Override
	public String toString() {
		return "category [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
