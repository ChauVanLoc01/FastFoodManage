package models.person.customer;

public class CashOnDelivery implements GatewayPayment {

	@Override
	public boolean pay(double amount) {
		return true;
	}

	@Override
	public double getMoney() {
		return 0;
	}

	@Override
	public boolean recharge(int amount) {
		return false;
	}
}
