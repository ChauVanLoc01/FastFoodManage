package models.person.customer;

import java.util.ArrayList;

import constant.Score;
import models.Subject;
import models.person.Order;
import models.person.Person;

public class NewCustomer extends Customer {
	public NewCustomer(String name, String phone, String email, String password, Subject subject) {
		super.person = new Person(name, phone, email, password);
		super.orders = new ArrayList<>();
		super.subject = subject;
		this.subject.addCustomer(this);
	}

	@Override
	public void upgradeCustomer(int score, Customer cus) {
		if (score >= Score.TARGET_SILVER) {
			cus = new SilverCustomer(cus);
			cus.decreaseScore(Score.TARGET_SILVER);
		}
	}

	@Override
	public int calScore(Order order) {
		return (int) (order.getTotal() * Score.STRATEGY_NEW);
	}
}
