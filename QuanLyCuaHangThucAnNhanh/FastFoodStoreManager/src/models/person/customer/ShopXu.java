package models.person.customer;

public class ShopXu implements GatewayPayment {
	private double amount;

	public ShopXu() {
		this.amount = 0;
	}

	@Override
	public boolean pay(double amount) {
		if (this.amount >= amount) {
			this.amount -= amount;
			return true;
		}
		return false;
	}

	@Override
	public double getMoney() {
		return this.amount;
	}

	@Override
	public boolean recharge(int amount) {
		this.amount += amount;
		return true;
	}

}
