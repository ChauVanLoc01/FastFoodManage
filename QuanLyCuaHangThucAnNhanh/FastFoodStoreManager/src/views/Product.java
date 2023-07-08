package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import controller.OrderController;
import models.Item;
import models.ProductObserver;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Product extends JPanel {
	private JLabel lb_quantity;
	private JButton btn_decrease;
	private JButton btn_increase;
	private JButton btn_addcard;

	public Product(ProductObserver productObserver, OrderController orderController) {
		setBorder(new LineBorder(SystemColor.controlShadow, 1, true));
		setBounds(0, 0, 169, 292);
		setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(Helper.getImageIconScale(productObserver.getProduct().getAddressImage(), 170, 170));
		lblNewLabel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.controlShadow));
		lblNewLabel.setBounds(0, 0, 168, 168);
		add(lblNewLabel);

		JLabel lb_title = new JLabel(productObserver.getProduct().getName());
		lb_title.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lb_title.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_title.setBounds(0, 196, 168, 28);
		add(lb_title);

		JLabel lblNewLabel_2 = new JLabel(productObserver.getProduct().getPrice() + "$");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 168, 168, 28);
		add(lblNewLabel_2);

		btn_addcard = new JButton("Add Card");
		btn_addcard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int quantity = Integer.parseInt(lb_quantity.getText());
				if (quantity > 0) {
					orderController.addItem(new Item(productObserver, quantity));
				}
			}
		});
		btn_addcard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_addcard.setFocusPainted(false);
		btn_addcard.setBackground(SystemColor.scrollbar);
		btn_addcard.setBounds(0, 258, 168, 32);
		add(btn_addcard);
		btn_addcard.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btn_decrease = new JButton("-");
		btn_decrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quantity = Integer.parseInt(lb_quantity.getText());
				if (quantity > 1) {
					lb_quantity.setText(quantity - 1 + "");
				}
			}
		});
		btn_decrease.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_decrease.setFocusPainted(false);
		btn_decrease.setBackground(SystemColor.window);
		btn_decrease.setBorder(new LineBorder(new Color(192, 192, 192)));
		btn_decrease.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_decrease.setBounds(10, 227, 50, 28);
		add(btn_decrease);

		btn_increase = new JButton("+");
		btn_increase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quantity = Integer.parseInt(lb_quantity.getText());
				if (quantity < productObserver.getProduct().getQuantity()) {
					lb_quantity.setText(quantity + 1 + "");
				}
			}
		});
		btn_increase.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_increase.setFocusPainted(false);
		btn_increase.setBorder(new LineBorder(new Color(192, 192, 192)));
		btn_increase.setBackground(SystemColor.window);
		btn_increase.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_increase.setBounds(112, 227, 47, 28);
		add(btn_increase);

		lb_quantity = new JLabel();
		if (productObserver.getProduct().getQuantity() == 0) {
			lb_quantity.setText("0");
			btn_addcard.setText("Sold out");
			btn_addcard.setEnabled(false);
		} else {
			lb_quantity.setText("1");
		}
		lb_quantity.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_quantity.setHorizontalAlignment(SwingConstants.CENTER);
		lb_quantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb_quantity.setBounds(60, 226, 50, 28);
		add(lb_quantity);
	}
}
