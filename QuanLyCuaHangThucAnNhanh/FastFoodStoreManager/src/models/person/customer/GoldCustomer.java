package models.person.customer;

import constant.Score;
import models.PersonObserver;
import models.person.Order;

public class GoldCustomer extends Customer {
	public GoldCustomer(PersonObserver cus) {
		super.person = ((Customer) cus).getPerson();
		super.subject = cus.getSubject();
		super.orders = ((Customer) cus).getOrders();
		super.score = ((Customer) cus).getScore();
	}

	@Override
	public void upgradeCustomer(int score, Customer cus) {
		if (score >= Score.TARGET_DIAMOND) {
			cus = new SilverCustomer(cus);
			cus.decreaseScore(Score.TARGET_DIAMOND);
		}
	}

	@Override
	public int calScore(Order order) {
		return (int) (order.getTotal() * Score.STRATEGY_GOLD);
	}
}
