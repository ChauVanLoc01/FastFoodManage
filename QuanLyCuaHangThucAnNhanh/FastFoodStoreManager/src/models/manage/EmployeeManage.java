package models.manage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import constant.Rule;
import models.PersonObserver;
import models.Subject;
import models.person.Order;
import models.person.employee.Cashier;
import models.person.employee.Employee;
import models.person.employee.KitchenStaff;
import models.person.employee.Shipper;

public class EmployeeManage {
	private List<PersonObserver> employees;
	private List<PersonObserver> admins;

	public EmployeeManage() {
		this.employees = new ArrayList<>();
		this.admins = new ArrayList<>();
	}

	public List<PersonObserver> getEmployees() {
		return employees;
	}

	public List<PersonObserver> getAdmins() {
		return admins;
	}

	public void addEmployee(PersonObserver o) {
		this.employees.add(o);
	}

	public void deleteEmployee(PersonObserver o) {
		this.employees.remove(o);
	}

	public void addAdmin(PersonObserver o) {
		this.admins.add(o);
	}

	public PersonObserver createEmployee(String rule, String cccd, String name, Date dateOfBirth, Date expiredDate,
			String sex, String address, String email, String phone, Subject subject) {
		if (rule.equals(Rule.Cashier)) {
			return new Cashier(cccd, name, dateOfBirth, expiredDate, sex, address, email, phone, subject);
		} else if (rule.equals(Rule.Shipper)) {
			return new Shipper(cccd, name, dateOfBirth, expiredDate, sex, address, email, phone, subject);
		}
		return new KitchenStaff(cccd, name, dateOfBirth, expiredDate, sex, address, email, phone, subject);
	}

	public void disableAccount(boolean status, PersonObserver employee) {
		((Employee) employee).disableAccount(status);
	}

	public void sellSuccessByEmployee(PersonObserver employee, List<Order> orders) {
		for (PersonObserver p : this.employees) {
			if (p.getPerson().equalPerson(employee.getPerson())) {
				p.getOrders().clear();
				p.getOrders().addAll(orders);
				break;
			}
		}
	}
	
	public void sellSuccessByAdmin(PersonObserver admin, List<Order> orders) {
		for (PersonObserver p : this.admins) {
			if (p.getPerson().equalPerson(admin.getPerson())) {
				p.getOrders().clear();
				p.getOrders().addAll(orders);
				break;
			}
		}
	}

}
