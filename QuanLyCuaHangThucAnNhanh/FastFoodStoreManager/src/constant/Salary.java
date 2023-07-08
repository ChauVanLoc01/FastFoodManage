package constant;

public class Salary {
	public static double salary_of_cashier = 300;
	public static double salary_of_security = 300;
	public static double salary_of_kitchen_staff = 300;
	public static double salary_of_shipeer = 300;
	
	public static double fee_late = 50;
	
	public static String cashier = "cashier";
	public static String security = "security";
	public static String kitchen_staff = "kitchen_staff";
	public static String shipeer = "shipeer";

	public static void changeSalaryOfOneDay(String type, double newSalary) {
		if (cashier.equals(type)) {
			salary_of_cashier = newSalary;
		} else if (security.equals(type)) {
			salary_of_security = newSalary;
		} else if (kitchen_staff.equals(type)) {
			salary_of_kitchen_staff = newSalary;
		} else if (shipeer.equals(type)) {
			salary_of_shipeer = newSalary;
		}
	}
}
