package models;

import java.util.Date;
import java.util.List;

import constant.OrderStatus;
import models.person.Order;
import models.person.Person;

public class Admin extends PersonObserver {
	public Admin(String name, String phone, String email, String password, Subject subject) {
		super.person = new Person(name, phone, email, password);
		super.subject = subject;
		super.subject.addAdmin(this);
	}

	public PersonObserver createEmployeecreateEmployee(String rule, String cccd, String name, Date dateOfBirth,
			Date expiredDate, String sex, String address, String email, String phone) {
		return this.subject.getEmployeeManage().createEmployee(rule, cccd, name, dateOfBirth, expiredDate, sex, address,
				email, phone, super.subject);
	}

	public void disableAccount(boolean status, PersonObserver personObserver) {
		super.subject.disableAccount(status, personObserver);
	}

	public void deleteEmployee(PersonObserver personObserver) {
		super.subject.deleteEmployee(personObserver);
	}

	public Order createOrder(List<Item> items, PersonObserver customer, PersonObserver employee) {
		return new Order(items, customer, employee, super.subject);
	}

	public boolean sell(Order order) {
		for (Order o : super.orders) {
			if (o.equalOrder(order)) {
				o.setStatus(OrderStatus.success);
				this.subject.getEmployeeManage().sellSuccessByAdmin(this, orders);
				this.subject.getOrderManage().changeStatusOrder(order, OrderStatus.success);
				return true;
			}
		}
		return false;
	}

	public void updateProduct(ProductObserver productObserver) {
	}

	public boolean deleteProduct() {
		return false;
	}
}