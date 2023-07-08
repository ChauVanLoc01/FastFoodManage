package models;

import java.util.Date;

import models.manage.CustomerManage;
import models.manage.EmployeeManage;
import models.manage.OrderManage;
import models.manage.ProductManage;
import models.person.Order;

public interface Subject {

	PersonObserver login(String email, String password);

	PersonObserver register(String name, String phone, String email, String password);

	void disableAccount(boolean status, PersonObserver personObserver);

//-------------------Product--------------------------------------

	void addProduct(ProductObserver p);

	void deleteProduct(ProductObserver p);

// -------------------Customer---------------------------------

	void addCustomer(PersonObserver p);

	void deleteCustomer(PersonObserver p);

//-------------------Employee---------------------------------

	void addEmployee(PersonObserver p);

	void deleteEmployee(PersonObserver p);

	void addAdmin(PersonObserver p);
//-------------------Order---------------------------------

	void addOrder(Order o);

	void deleteOrder(Order o);

//-------------------Notification---------------------------------

	Notification createNotification();

	Vourcher createVourcher(String title, String content, String code, double cost, Date startDate, Date expiredDate);

	OrderManage getOrderManage();

	CustomerManage getCustomerManage();

	EmployeeManage getEmployeeManage();

	ProductManage getProductManage();
}
