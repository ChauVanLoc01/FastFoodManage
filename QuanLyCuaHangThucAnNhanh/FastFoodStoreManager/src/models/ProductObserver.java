package models;

import models.product.Product;

public abstract class ProductObserver {
	protected Product product;
	protected Subject subject;

	public double cost() {
		return this.product.getPrice();
	}

	public void update(String name, double price, String addressImage) {
		this.product.update(name, price, addressImage);
	}

	public void increase(int amount) {
		this.subject.getProductManage().increaseQuantity(this, amount);
	}

	public void descrease(int amount) {
		this.subject.getProductManage().decreaseQuantity(this, amount);
	}

	public void buy(int amount) {
		this.subject.getProductManage().buy(this, amount);
	}

	public void cancel(int amount) {
		this.subject.getProductManage().cancel(this, amount);
	}

	public void createRating(double rating, String content, PersonObserver personObserver) {
		this.product.createRating(rating, content, personObserver);
	}

	public Product getProduct() {
		return product;
	}

	public boolean equalProductObserver(ProductObserver productObserver) {
		return this.product.equalProduct(productObserver.getProduct());
	}

}
