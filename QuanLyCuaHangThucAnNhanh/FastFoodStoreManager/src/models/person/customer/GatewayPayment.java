package models.person.customer;

public interface GatewayPayment {
	boolean pay(double amount);
	
	double getMoney();
	
	boolean recharge(int amount);
}
