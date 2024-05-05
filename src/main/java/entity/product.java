package entity;

public class product {
	private String id;
	private String name;
	private double price;
	private int quantity;
	private String images;
	private String description;
	
	public product() {}
	public product(product p) {
		super();
		this.id = p.id;
		this.name = p.name;
		this.price = p.price;
		this.quantity = p.quantity;
		this.images = p.images;
		this.description = p.description;
	}
	public product(String id, String name, double price, int quantity, String images, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.images = images;
		this.description = description;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", images="
				+ images + ", description=" + description + "]";
	}
	
}
