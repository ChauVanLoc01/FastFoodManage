package models.product;

import java.util.ArrayList;
import java.util.List;

import constant.GenerateId;
import models.PersonObserver;

public class Product {
	private String id;
	private String name;
	private int quantity;
	private int quantitySold;
	private double price;
	private String addressImage;
	private List<Rate> rates;

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

	public Product(String name, int quantity, double price, String addressImage) {
		this.id = GenerateId.generateId();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.addressImage = addressImage;
		this.quantitySold = 0;
		this.rates = new ArrayList<>();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAddressImage() {
		return addressImage;
	}

	public void setAddressImage(String addressImage) {
		this.addressImage = addressImage;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public void update(String name, double price, String addressImage) {
		setName(name);
		setPrice(price);
		setAddressImage(addressImage);
	}

	public void buy(int amount) {
		this.quantity -= amount;
		this.quantitySold += amount;
	}

	public void cancel(int amount) {
		this.quantity += amount;
		this.quantitySold -= amount;
	}

	public void increase(int amount) {
		this.quantity += amount;
	}

	public void decrease(int amount) {
		this.quantity -= amount;
	}

	public void createRating(double rating, String content, PersonObserver personObserver) {
		this.rates.add(new Rate(rating, content, personObserver));
	}
	
	public boolean equalProduct(Product product) {
		return this.id.equals(product.getId());
	}
	
}
