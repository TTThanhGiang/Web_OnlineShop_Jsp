package entity;


public class cartItem extends product {
	private int quantity;

	public cartItem(product p, int quantity) {
		super(p);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void increaseQuantity(int value) {
		quantity += value;
	}
	
	public void decreaseQuantity() {
		quantity--;
	}
}
