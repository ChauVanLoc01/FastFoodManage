package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import models.Item;
import models.PersonObserver;
import models.Subject;
import models.person.Order;
import models.person.customer.Customer;
import models.person.customer.GatewayPayment;
import views.Menu;
import views.RechargeMoney;

public class OrderController {
	private Menu menu;
	private JPanel panel;

	public OrderController(Menu menu, JPanel panel) {
		this.menu = menu;
		this.panel = panel;
	}

	public List<Item> getItems() {
		return this.menu.getItems();
	}

	public void addItem(Item item) {
		this.menu.addItem(item);
	}

	public void deleteItem(Item item) {
		this.menu.deleteItem(item);
	}

	public void payByCustomer(List<Item> items, String address, String phone, PersonObserver customer, int score,
			GatewayPayment gateway) {
		if (items.isEmpty()) {
			JOptionPane.showMessageDialog(panel, "Product list is empty!", "Failed Order",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		} else if (address.equals("") || phone.equals("")) {
			JOptionPane.showMessageDialog(panel, "Address or phone is empty!", "Failed Order",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		double cost = 0;
		for (Item i : items) {
			cost += i.cost();
		}
		if (score > cost * 0.3) {
			JOptionPane.showMessageDialog(panel, "Số lượng score không lớn hơn 30% so với hóa đơn!", "Failed Order",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		Order order = ((Customer) customer).createOrder(items, address, phone, score);
		popupMessage(((Customer) customer).pay(order, gateway), customer, order);
	}


	public void payAgain(Order order, PersonObserver customer) {
		popupMessage(((Customer) customer).payAgain(order), customer, order);
	}

	public void popupMessage(boolean status, PersonObserver customer, Order order) {
		if (status) {
			JOptionPane.showMessageDialog(this.panel, "Thanh toán thành công", "Thanh toán",
					JOptionPane.INFORMATION_MESSAGE);
			this.menu.getItems().clear();
			this.menu.recallDataInList();
			if (customer instanceof Customer) {
				this.menu.initInforForCustomer(this.menu.getCustomer(customer));
				System.out.println("111");
			}
		} else {
			int result = JOptionPane.showConfirmDialog(this.panel,
					"Bạn có muốn nạp tiền vào Shop Xu để tiếp tục thành toán?", "Shop Xu", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				RechargeMoney rechargeView = new RechargeMoney();
				rechargeView.setVisible(true);
				rechargeView.getLb_available_content().setText(((Customer) customer).getGateway().getMoney() + "");
				rechargeView.getBtn_recharge().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int amount = (int) Double.parseDouble(rechargeView.getJt_amount().getText());
						boolean isRecharge = ((Customer) customer).recharge(amount);
						if (isRecharge) {
							rechargeView.getLb_available_content()
									.setText(((Customer) customer).getGateway().getMoney() + "");
							menu.getLableMoneyContent().setText(((Customer) customer).getGateway().getMoney() + "");
							JOptionPane.showMessageDialog(rechargeView, "Nạp tiền vào Shop Xu thành công!", "Nạp tiền",
									JOptionPane.INFORMATION_MESSAGE);
							boolean isPayAgain = ((Customer) customer).payAgain(order);
							if (isPayAgain) {
								JOptionPane.showMessageDialog(rechargeView, "Thanh toán thành công", "Thanh toán",
										JOptionPane.INFORMATION_MESSAGE);
								menu.getItems().clear();
								menu.recallDataInList();
								if (customer instanceof Customer) {
									menu.initInforForCustomer(menu.getCustomer(customer));
								}
							} else {
								JOptionPane.showMessageDialog(rechargeView,
										"Tiền trong Shop Xu không đủ để thanh toán!", "Thanh toán",
										JOptionPane.INFORMATION_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(rechargeView, "Nạp tiền vào Shop Xu thất bại", "Nạp tiền",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
			} else if (result == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(this.panel, "Money in wallet is not enough", "Failed",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void createOrderByEmployee(List<Item> items, String address, String phone, PersonObserver customer,
			Subject sub, int score) {

	}
}
