package models.manage;

import java.util.ArrayList;
import java.util.List;

import constant.OrderStatus;
import models.person.Order;

public class OrderManage {
	private List<Order> orders;

	public OrderManage() {
		this.orders = new ArrayList<>();
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void addOrder(Order o) {
		this.orders.add(o);
	}

	public void deleteOrder(Order o) {
		this.orders.remove(o);
	}

	public void changeStatusOrder(Order order, String status) {
		for (Order o : this.orders) {
			if (o.equalOrder(order)) {
				o.setStatus(status);
				break;
			}
		}
	}
	
}
