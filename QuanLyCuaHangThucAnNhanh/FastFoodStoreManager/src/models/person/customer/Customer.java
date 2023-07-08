package models.person.customer;

import java.util.List;

import constant.OrderStatus;
import models.Item;
import models.PersonObserver;
import models.person.Order;

public abstract class Customer extends PersonObserver {
	protected int score;
	protected GatewayPayment gateway = new ShopXu();

	public GatewayPayment getGateway() {
		return gateway;
	}

	public void setGateway(GatewayPayment gateway) {
		this.gateway = gateway;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void incrementScore(int score) {
		setScore(this.score + score);
	}

	public void decreaseScore(int score) {
		setScore(this.score - score);
	}

	public Order createOrder(List<Item> items, String address, String phone, int score) {
		return new Order(items, address, phone, this, super.subject, score);
	}

	public boolean pay(Order order, GatewayPayment gateway) {
		if (gateway.pay(order.getTotal())) {
			for (Order o : super.orders) {
				if (o.equalOrder(order)) {
					o.setStatus(OrderStatus.success);
					this.subject.getCustomerManage().buySuccess(this.orders, this, order.getDiscount(),
							this.calScore(order));
					this.subject.getOrderManage().changeStatusOrder(order, OrderStatus.success);
					upgradeCustomer(this.score, this);
					return true;
				}
			}
		}
		return false;
	}

	public boolean payAgain(Order order) {
		for (Order o : this.orders) {
			if (o.equalOrder(order) && this.gateway.pay(order.getTotal())) {
				o.setStatus(OrderStatus.success);
				this.subject.getCustomerManage().buySuccess(this.orders, this, order.getDiscount(),
						this.calScore(order));
				this.subject.getOrderManage().changeStatusOrder(order, OrderStatus.success);
				upgradeCustomer(this.score, this);
				return true;
			}
		}
		return false;
	}

	public boolean cancelOrder(String note, Order order) {
		for (Order o : this.orders) {
			if (o.equalOrder(order) && o.getStatus().equals(OrderStatus.waiting_transaction)) {
				order.setStatus(OrderStatus.cancel);
				order.cancel(note);
				return true;
			}
		}
		return false;
	}

	public void updateAvatar(String image) {
		this.person.setImage(image);
	}

	public boolean changePassword(String currentPassword, String newPassword) {
		return this.person.changePassword(currentPassword, newPassword);
	}

	public boolean recharge(int amount) {
		return ((GatewayPayment) this.gateway).recharge(amount);
	}

	public abstract void upgradeCustomer(int score, Customer cus);

	public abstract int calScore(Order order);

}
