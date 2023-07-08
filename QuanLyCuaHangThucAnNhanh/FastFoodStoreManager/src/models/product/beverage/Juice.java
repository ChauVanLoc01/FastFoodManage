package models.product.beverage;

import models.Subject;
import models.product.Product;

public class Juice extends Beverage {
	public Juice(String name, int quantity, double price, String addImg, Subject sub) {
		super.product = new Product(name, quantity, price, addImg);
		super.subject = sub;
		super.subject.addProduct(this);
	}
}
