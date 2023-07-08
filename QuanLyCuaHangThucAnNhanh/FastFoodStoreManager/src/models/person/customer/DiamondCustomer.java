package models.person.customer;

import constant.Score;
import models.PersonObserver;
import models.person.Order;

public class DiamondCustomer extends Customer {
	public DiamondCustomer(PersonObserver cus) {
		super.person = ((Customer) cus).getPerson();
		super.subject = cus.getSubject();
		super.orders = ((Customer) cus).getOrders();
		super.score = ((Customer) cus).getScore();
	}

	@Override
	public int calScore(Order order) {
		return (int) (order.getTotal() * Score.STRATEGY_DIAMOND);
	}

	@Override
	public void upgradeCustomer(int score, Customer cus) {

	}
}
