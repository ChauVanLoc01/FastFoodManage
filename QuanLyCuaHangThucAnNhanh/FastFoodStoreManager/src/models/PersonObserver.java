package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import constant.OrderStatus;
import models.person.Order;
import models.person.Person;
import models.person.customer.GatewayPayment;

public abstract class PersonObserver {
	protected Person person;
	protected Subject subject;
	protected List<Notification> notifications = new ArrayList<>();
	protected List<Order> orders = new ArrayList<>();

	public Subject getSubject() {
		return this.subject;
	}

	public Person getPerson() {
		return person;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public void updateInformation(String cccd, String name, Date dob, String sex, String phone, String email,
			String address) {
		this.person.updateInformation(cccd, name, dob, sex, phone, email, address);
	}

	public boolean changePassword(String currentPassword, String newPassword) {
		return this.person.changePassword(currentPassword, newPassword);
	}

	public void disableAccount(boolean status) {
		this.person.getAccount().setStatus(status);
	}

	public Order createOrder(List<Item> items, String address, String phone, int score) {
		return new Order(items, address, phone, this, subject, score);
	}

}
