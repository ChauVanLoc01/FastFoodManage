package views;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import models.PersonObserver;
import models.Subject;

public class PersonManage extends JPanel {
	private JPanel jp_customer;
	private JPanel jp_employee;

	public PersonManage(Subject subject) {
		setBorder(null);
		setBackground(SystemColor.desktop);
		setBounds(0, 0, 1228, 619);
		setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(SystemColor.window);
		tabbedPane.setBounds(0, 0, 1228, 619);
		add(tabbedPane);

		jp_customer = new ManageBase(subject.getCustomerManage().getCustomers(), null, "Customer");
		jp_customer.setBackground(SystemColor.window);
		jp_customer.setBorder(null);
		tabbedPane.add(jp_customer, "Customer");
		jp_customer.setLayout(null);

		jp_employee = new ManageBase(subject.getEmployeeManage().getEmployees(), null, "Employee");
		jp_employee.setBackground(SystemColor.window);
		jp_employee.setBorder(null);
		tabbedPane.add(jp_employee, "Employee");
	}
}
