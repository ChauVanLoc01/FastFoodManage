package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import constant.Password;
import models.manage.CustomerManage;
import models.manage.EmployeeManage;
import models.manage.OrderManage;
import models.manage.ProductManage;
import models.person.Order;
import models.person.customer.Customer;
import models.person.employee.Employee;

public class Center implements Subject {
	private static Subject instance;

	private OrderManage orderManage;
	private CustomerManage customerManage;
	private EmployeeManage employeeManage;
	private ProductManage productManage;

	private Center() {
		this.customerManage = new CustomerManage(this);
		this.employeeManage = new EmployeeManage();
		this.orderManage = new OrderManage();
		this.productManage = new ProductManage();
	}

	public static Subject getInstance() {
		if (instance == null) {
			return new Center();
		}
		return instance;
	}

	public OrderManage getOrderManage() {
		return orderManage;
	}

	public CustomerManage getCustomerManage() {
		return customerManage;
	}

	public EmployeeManage getEmployeeManage() {
		return employeeManage;
	}

	public ProductManage getProductManage() {
		return productManage;
	}

	@Override
	public PersonObserver login(String email, String password) {
		List<PersonObserver> list = new ArrayList<>();
		list.addAll(this.customerManage.getCustomers());
		list.addAll(this.employeeManage.getEmployees());
		list.addAll(this.employeeManage.getAdmins());
		for (PersonObserver o : list) {
			if (o.getPerson().getAccount().validateAccount(email, password)) {
				return o;
			}
		}
		return null;
	}

	@Override
	public PersonObserver register(String name, String phone, String email, String password) {
		return this.customerManage.register(name, email, password, phone);
	}

	@Override
	public void disableAccount(boolean status, PersonObserver personObserver) {
		personObserver.disableAccount(status);
	}

//	------------------ Food ---------------------------------------

	@Override
	public void addProduct(ProductObserver p) {
		this.productManage.addProduct(p);
	}

	@Override
	public void deleteProduct(ProductObserver p) {
		this.productManage.deleteProduct(p);
	}

//	------------------ Customer --------------------------------------

	@Override
	public void addCustomer(PersonObserver p) {
		this.customerManage.addCustomer(p);
	}

	@Override
	public void deleteCustomer(PersonObserver p) {
		this.customerManage.deleteCustomer(p);
	}

//	------------------ Employee --------------------------------------

	@Override
	public void addEmployee(PersonObserver p) {
		this.employeeManage.addEmployee(p);
	}

	@Override
	public void deleteEmployee(PersonObserver p) {
		this.employeeManage.deleteEmployee(p);
	}

	@Override
	public void addAdmin(PersonObserver p) {
		this.employeeManage.addAdmin(p);
	}
//	------------------ Order -----------------------------------------

	@Override
	public void addOrder(Order o) {
		this.orderManage.addOrder(o);
	}

	@Override
	public void deleteOrder(Order o) {
		this.orderManage.deleteOrder(o);
	}
//	------------------ Vourcher --------------------------------------

	@Override
	public Vourcher createVourcher(String title, String content, String code, double cost, Date startDate,
			Date expiredDate) {
		return new Vourcher(code, cost, startDate, expiredDate);
	}

	@Override
	public Notification createNotification() {
		return null;
	}

}
