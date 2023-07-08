package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.OrderController;
import models.Item;
import models.PersonObserver;
import models.Subject;
import models.person.customer.CashOnDelivery;
import models.person.customer.Customer;
import models.person.customer.GatewayPayment;

public class Menu extends JPanel {

	private Food panelFood;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JLabel lb_total;
	private List<Item> items;
	private JPanel panel_2;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JPanel panel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lb_employee;
	private JTextField jt_employee;
	private JTextField jt_phone;
	private JTextField jt_customer;
	private JLabel lb_customer;
	private JLabel lb_phone;
	private Food food;
	private Subject subject;

	private OrderController orderController;
	private JLabel lblNewLabel_4;
	private JPanel panel_infor_employee;
	private JPanel panel_infor_customer;
	private JTextField jt_customer_for_customer;
	private JTextField jt_phone_for_customer;
	private JComboBox<String> cbb_gateway;
	private JLabel lb_phone_for_customer_1;
	private JSpinner spinner;
	private JTextArea textArea;
	private String cashOnDelivery = "Cash on delivery";
	private String shopXu = "Shop xu";
	private JLabel lb_money;
	private JLabel lb_money_content;
	private JPanel panel_money;
	private SpinnerModel spinerModel;

	public Menu(PersonObserver personObserver, Subject subject, JPanel parentPanel) {
		this.items = new ArrayList<>();
		this.subject = subject;
		setBackground(SystemColor.desktop);
		setBounds(0, 0, 1230, 619);
		setLayout(null);

		panel = new JPanel();
		panel.setBackground(SystemColor.controlLtHighlight);
		panel.setBounds(711, 0, 519, 619);
		add(panel);
		panel.setLayout(null);

		lblNewLabel_2 = new JLabel("Total");
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(303, 543, 75, 27);
		panel.add(lblNewLabel_2);

		btnNewButton = new JButton("Pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phone = jt_phone_for_customer.getText();
				String address = textArea.getText();
				int score = (int) spinner.getValue();
				GatewayPayment gateway_payment;
				if (cbb_gateway.getSelectedItem().equals(shopXu)) {
					gateway_payment = ((Customer) personObserver).getGateway();
				} else {
					gateway_payment = new CashOnDelivery();
				}
				if (personObserver instanceof Customer) {
					orderController.payByCustomer(items, address, phone, personObserver, score, gateway_payment);
				} else {
//					orderController.pay(items, address, phone, personObserver, subject, score);
				}
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(199, 537, 110, 42);
		panel.add(btnNewButton);

		lb_total = new JLabel();
		lb_total.setForeground(new Color(139, 0, 0));
		lb_total.setHorizontalAlignment(SwingConstants.CENTER);
		lb_total.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_total.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lb_total.setBounds(398, 543, 110, 27);
		panel.add(lb_total);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(229, 229, 229));
		panel_1.setBounds(0, 0, 519, 52);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_1 = new JLabel("Order Information");
		lblNewLabel_1.setBounds(0, 0, 519, 52);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(SystemColor.scrollbar);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(229, 229, 229));
		panel_2.setBounds(0, 0, 348, 32);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblFood = new JLabel("Food");
		lblFood.setBounds(0, 0, 347, 30);
		panel_2.add(lblFood);
		lblFood.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFood.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood.setForeground(SystemColor.textText);
		lblFood.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFood.setBackground(Color.BLACK);

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(229, 229, 229));
		panel_3.setBounds(356, 0, 347, 32);
		add(panel_3);
		panel_3.setLayout(null);

		lblNewLabel = new JLabel("Beverage");
		lblNewLabel.setBounds(0, 0, 347, 30);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(SystemColor.textText);
		lblNewLabel.setBackground(SystemColor.textText);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		panel_4 = new JPanel();
		panel_4.setBounds(0, 261, 519, 251);
		panel.add(panel_4);
		panel_4.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(206, 206, 206)));
		scrollPane.setBounds(0, 43, 519, 208);
		panel_4.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		Helper.speedScroll(scrollPane);

		lblNewLabel_5 = new JLabel("Product");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setBounds(20, 11, 97, 21);
		panel_4.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Quantity");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(249, 11, 97, 21);
		panel_4.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Price");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_7.setBounds(356, 11, 66, 21);
		panel_4.add(lblNewLabel_7);

		lblNewLabel_4 = new JLabel("Total");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(422, 11, 97, 21);
		panel_4.add(lblNewLabel_4);

		orderController = new OrderController(this, parentPanel);
		recallDataProduct();
		recallDataInList();

		if (personObserver instanceof Customer) {
			initInforForCustomer(personObserver);
		} else {
			initInforForEmployee(personObserver);
		}
	}

	public void initInforForCustomer(PersonObserver personObserver) {
		if (panel_infor_employee != null && panel_infor_customer != null) {
			panel.remove(panel_infor_employee);
			panel.remove(panel_infor_customer);
		}
		panel_infor_customer = new JPanel();
		panel_infor_customer.setBackground(SystemColor.window);
		panel_infor_customer.setBounds(0, 52, 519, 208);
		panel.add(panel_infor_customer);
		panel_infor_customer.setLayout(null);

		JLabel lb_customer_for_customer = new JLabel("Customer");
		lb_customer_for_customer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_customer_for_customer.setBounds(26, 15, 85, 30);
		panel_infor_customer.add(lb_customer_for_customer);

		jt_customer_for_customer = new JTextField(personObserver.getPerson().getName());
		jt_customer_for_customer.setBackground(SystemColor.window);
		jt_customer_for_customer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jt_customer_for_customer.setColumns(10);
		jt_customer_for_customer.setBounds(109, 17, 171, 30);
		panel_infor_customer.add(jt_customer_for_customer);
		jt_customer_for_customer.setEnabled(false);

		JLabel lb_phone_for_customer = new JLabel("Phone");
		lb_phone_for_customer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_phone_for_customer.setBounds(302, 15, 67, 30);
		panel_infor_customer.add(lb_phone_for_customer);

		jt_phone_for_customer = new JTextField(personObserver.getPerson().getPhone());
		jt_phone_for_customer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jt_phone_for_customer.setColumns(10);
		jt_phone_for_customer.setBounds(372, 17, 122, 30);
		panel_infor_customer.add(jt_phone_for_customer);

		JLabel lb_address_for_customer = new JLabel("Address");
		lb_address_for_customer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_address_for_customer.setBounds(27, 59, 74, 30);
		panel_infor_customer.add(lb_address_for_customer);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textArea.setBorder(new LineBorder(new Color(192, 192, 192)));
		textArea.setBounds(110, 65, 385, 46);
		panel_infor_customer.add(textArea);

		String[] gateway = { cashOnDelivery, shopXu };

		cbb_gateway = new JComboBox(gateway);
		cbb_gateway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gateway_payment = (String) cbb_gateway.getSelectedItem();
				if (gateway_payment.equals(shopXu)) {
					panel_money = new JPanel();
					panel_money.setBackground(SystemColor.window);
					panel_money.setBounds(10, 168, 416, 40);
					panel_infor_customer.add(panel_money);
					panel_money.setLayout(null);

					lb_money = new JLabel("Money");
					lb_money.setFont(new Font("Tahoma", Font.PLAIN, 17));
					lb_money.setBounds(99, 2, 73, 29);
					panel_money.add(lb_money);

					lb_money_content = new JLabel(((Customer) personObserver).getGateway() != null
							? ((Customer) personObserver).getGateway().getMoney() + "$"
							: "No Gateway Payment");
					lb_money_content.setForeground(SystemColor.desktop);
					lb_money_content.setFont(new Font("Tahoma", Font.PLAIN, 17));
					lb_money_content.setBounds(174, 2, 190, 29);
					panel_money.add(lb_money_content);

				} else {
					if (panel_money != null) {
						panel_infor_customer.remove(panel_money);
					}
				}
			}
		});
		cbb_gateway.setBackground(SystemColor.window);
		cbb_gateway.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbb_gateway.setBounds(109, 128, 211, 30);
		panel_infor_customer.add(cbb_gateway);

		JLabel lb_gateway_for_customer = new JLabel("Gateway");
		lb_gateway_for_customer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_gateway_for_customer.setBounds(26, 127, 74, 30);
		panel_infor_customer.add(lb_gateway_for_customer);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBackground(new Color(128, 0, 0));
		btnCancel.setBounds(50, 538, 126, 42);
		panel.add(btnCancel);

		spinerModel = new SpinnerNumberModel(0, 0, ((Customer) personObserver).getScore(), 1);
		spinner = new JSpinner(spinerModel);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 17));
		spinner.setBounds(428, 129, 54, 27);
		panel_infor_customer.add(spinner);

		lb_phone_for_customer_1 = new JLabel("Point");
		lb_phone_for_customer_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_phone_for_customer_1.setBounds(372, 127, 54, 30);
		panel_infor_customer.add(lb_phone_for_customer_1);

	}

	public void initInforForEmployee(PersonObserver personObserver) {
		if (panel_infor_employee != null && panel_infor_customer != null) {
			panel.remove(panel_infor_employee);
			panel.remove(panel_infor_customer);
		}
		panel_infor_employee = new JPanel();
		panel_infor_employee.setBackground(SystemColor.window);
		panel_infor_employee.setBounds(0, 52, 519, 179);
		panel.add(panel_infor_employee);
		panel_infor_employee.setLayout(null);

		lb_employee = new JLabel("Employee");
		lb_employee.setBounds(42, 24, 103, 30);
		panel_infor_employee.add(lb_employee);
		lb_employee.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jt_employee = new JTextField(personObserver.getPerson().getName());
		jt_employee.setBounds(159, 24, 321, 30);
		panel_infor_employee.add(jt_employee);
		jt_employee.setColumns(10);
		jt_employee.setEnabled(false);

		lb_phone = new JLabel("Phone");
		lb_phone.setBounds(42, 125, 103, 30);
		panel_infor_employee.add(lb_phone);
		lb_phone.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jt_phone = new JTextField(personObserver.getPerson().getPhone());
		jt_phone.setBounds(159, 125, 321, 30);
		panel_infor_employee.add(jt_phone);
		jt_phone.setColumns(10);

		lb_customer = new JLabel("Customer");
		lb_customer.setBounds(41, 75, 103, 30);
		panel_infor_employee.add(lb_customer);
		lb_customer.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jt_customer = new JTextField();
		jt_customer.setBounds(158, 75, 321, 30);
		panel_infor_employee.add(jt_customer);
		jt_customer.setColumns(10);

	}

	public void recallDataProduct() {
		if (food != null) {
			remove(food);
		}
		food = new Food(this.subject.getProductManage().getFoods(), this.subject.getProductManage().getBeverages(),
				orderController);
		food.setBounds(0, 32, 709, 585);
		add(food);
	}

	public void recallDataInList() {
		scrollPane.setViewportView(null);
		JPanel panel_container = new JPanel();
		panel_container.setBackground(SystemColor.window);
		panel_container.setBorder(new LineBorder(new Color(206, 206, 206)));
		scrollPane.setViewportView(panel_container);
		panel_container.setLayout(new GridLayout(10, 1, 0, 0));
		double cost = 0;
		for (int i = 0; i < items.size(); i++) {
			JPanel p = new ProductInOrder(items.get(i), orderController);
			p.setPreferredSize(new Dimension(519, 42));
			panel_container.add(p);
			cost += items.get(i).getQuantity() * items.get(i).getProductObserver().getProduct().getPrice();
		}
		lb_total.setText("" + cost);
	}

	public List<Item> getItems() {
		return this.items;
	}

	public PersonObserver getCustomer(PersonObserver customer) {
		return this.subject.getCustomerManage().getCustomerObserver(customer);
	}

	public void addItem(Item item) {
		if (this.items.size() == 0) {
			this.items.add(item);
		} else {
			for (Item i : this.items) {
				if (i.equalItem(item)) {
					i.setQuantity(i.getQuantity() + item.getQuantity());
					recallDataInList();
					recallDataProduct();
					return;
				}
			}
			this.items.add(item);
		}
		recallDataInList();
		recallDataProduct();
	}

	public void deleteItem(Item item) {
		for (Item i : this.items) {
			if (i.equalItem(item)) {
				this.items.remove(i);
				i.cancel(i.getQuantity());
				recallDataInList();
				recallDataProduct();
				break;
			}
		}
	}

	public JLabel getLableMoneyContent() {
		return lb_money_content;
	}
}