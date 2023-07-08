package models;

public class Item {
	private ProductObserver productObserver;
	private int quantity;

	public Item(ProductObserver productObserver, int quantity) {
		this.productObserver = productObserver;
		this.quantity = quantity;
		buy(quantity);
	}

	public ProductObserver getProductObserver() {
		return productObserver;
	}

	public void setProductObserver(ProductObserver productObserver) {
		this.productObserver = productObserver;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double cost() {
		return this.productObserver.cost() * quantity;
	}

	public void increase(int amount) {
		this.productObserver.increase(amount);
	}

	public void decrease(int amount) {
		this.productObserver.descrease(amount);
	}

	public void buy(int amount) {
		this.productObserver.buy(amount);
	}

	public void cancel(int amount) {
		this.productObserver.cancel(amount);
	}

	public boolean equalItem(Item item) {
		return this.productObserver.getProduct().getId().equals(item.productObserver.getProduct().getId());
	}
}
