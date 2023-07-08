package models.manage;

import java.util.ArrayList;
import java.util.List;

import models.ProductObserver;
import models.product.beverage.Beverage;
import models.product.food.Food;

public class ProductManage {
	private List<ProductObserver> products;

	public ProductManage() {
		this.products = new ArrayList<>();
	}

	public List<ProductObserver> getFoods() {
		List<ProductObserver> result = new ArrayList<>();
		for (ProductObserver p : this.products) {
			if (p instanceof Food) {
				result.add(p);
			}
		}
		return result;
	}

	public List<ProductObserver> getBeverages() {
		List<ProductObserver> result = new ArrayList<>();
		for (ProductObserver p : this.products) {
			if (p instanceof Beverage) {
				result.add(p);
			}
		}
		return result;
	}

	public void addProduct(ProductObserver o) {
		this.products.add(o);
	}

	public void deleteProduct(ProductObserver o) {
		this.products.remove(o);
	}

	public void buy(ProductObserver productObserver, int amount) {
		for (ProductObserver p : this.products) {
			if (p.equalProductObserver(productObserver)) {
				p.getProduct().buy(amount);
			}
		}
	}

	public void cancel(ProductObserver productObserver, int amount) {
		for (ProductObserver p : this.products) {
			if (p.equalProductObserver(productObserver)) {
				p.getProduct().cancel(amount);
			}
		}
	}

	public void increaseQuantity(ProductObserver productObserver, int amount) {
		for (ProductObserver p : this.products) {
			if (p.equalProductObserver(productObserver)) {
				p.getProduct().increase(amount);
			}
		}
	}

	public void decreaseQuantity(ProductObserver productObserver, int amount) {
		for (ProductObserver p : this.products) {
			if (p.equalProductObserver(productObserver)) {
				p.getProduct().decrease(amount);
			}
		}
	}
}
