package models.person.employee;

import java.util.List;

import constant.OrderStatus;
import constant.Salary;
import models.Item;
import models.PersonObserver;
import models.person.Order;

public abstract class Employee extends PersonObserver {
	protected List<TimeWork> timeWork;
	protected ISalary iSalary;

	public void setTimeWork(List<TimeWork> timeWork) {
		this.timeWork = timeWork;
	}

	public List<TimeWork> getTimeWork() {
		return timeWork;
	}

	public TimeWork getLatestTimeWork() {
		return this.timeWork.get(this.timeWork.size() - 1);
	}

	public double salary() {
		return this.iSalary.salary(this);
	}

	public double salaryByPosition() {
		if (this instanceof Cashier) {
			return Salary.salary_of_cashier;
		} else if (this instanceof KitchenStaff) {
			return Salary.salary_of_kitchen_staff;
		} else if (this instanceof Shipper) {
			return Salary.salary_of_shipeer;
		}
		return 0;
	}

	public void disableAccount(boolean status) {
		super.person.getAccount().setStatus(status);
	}

	public Order createOrder(List<Item> items, PersonObserver customer, PersonObserver employee) {
		return new Order(items, customer, employee, super.subject);
	}

	public boolean sell(Order order) {
		for (Order o : super.orders) {
			if (o.equalOrder(order)) {
				o.setStatus(OrderStatus.success);
				this.subject.getEmployeeManage().sellSuccessByEmployee(this, orders);
				this.subject.getOrderManage().changeStatusOrder(order, OrderStatus.success);
				return true;
			}
		}
		return false;
	}
}
