package views;

import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.OrderController;
import models.Item;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductInOrder extends JPanel {
	private JCheckBox cb_product;
	private JLabel lb_quantity;
	private JLabel lb_price;

	public ProductInOrder(Item item, OrderController orderController) {
		setBackground(SystemColor.window);
		setLayout(null);

		cb_product = new JCheckBox(item.getProductObserver().getProduct().getName());
		cb_product.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				orderController.deleteItem(item);
			}
		});
		cb_product.setBackground(SystemColor.window);
		cb_product.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cb_product.setAlignmentX(Component.CENTER_ALIGNMENT);
		cb_product.setBounds(16, 7, 225, 27);
		add(cb_product);

		lb_quantity = new JLabel("" + item.getQuantity());
		lb_quantity.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_quantity.setHorizontalAlignment(SwingConstants.CENTER);
		lb_quantity.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_quantity.setBounds(257, 7, 51, 27);
		add(lb_quantity);

		lb_price = new JLabel(item.getProductObserver().getProduct().getPrice() + "");
		lb_price.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_price.setHorizontalAlignment(SwingConstants.CENTER);
		lb_price.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_price.setBounds(343, 7, 58, 27);
		add(lb_price);

		JLabel lb_total = new JLabel(item.getProductObserver().getProduct().getPrice() * item.getQuantity() + "");
		lb_total.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_total.setBounds(427, 7, 91, 27);
		add(lb_total);
	}
}
