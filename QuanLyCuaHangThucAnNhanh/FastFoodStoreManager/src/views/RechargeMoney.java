package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import models.PersonObserver;
import models.person.customer.Customer;

public class RechargeMoney extends JFrame {

	private JPanel contentPane;
	private JTextField jt_amount;
	private JButton btn_recharge;
	private JLabel lb_available;
	private JLabel lb_available_content;
	private JLabel lb_amount;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechargeMoney frame = new RechargeMoney();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RechargeMoney() {

		setBackground(SystemColor.desktop);
		setTitle("Recharge");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lb_amount = new JLabel("Amount");
		lb_amount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_amount.setBounds(48, 132, 82, 30);
		contentPane.add(lb_amount);

		jt_amount = new JTextField();
		jt_amount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jt_amount.setBounds(140, 132, 242, 30);
		contentPane.add(jt_amount);
		jt_amount.setColumns(10);

		btn_recharge = new JButton("Recharge");
		btn_recharge.setForeground(SystemColor.text);
		btn_recharge.setBackground(SystemColor.desktop);
		btn_recharge.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn_recharge.setBounds(269, 196, 113, 39);
		contentPane.add(btn_recharge);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 65);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Shop Xu");
		lblNewLabel.setBounds(0, 0, 434, 65);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(214, 214, 214));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));

		lb_available = new JLabel("Available");
		lb_available.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_available.setBounds(48, 86, 82, 30);
		contentPane.add(lb_available);

		lb_available_content = new JLabel("Amount");
		lb_available_content.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lb_available_content.setBounds(140, 86, 242, 30);
		contentPane.add(lb_available_content);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getJt_amount() {
		return jt_amount;
	}

	public JButton getBtn_recharge() {
		return btn_recharge;
	}

	public JLabel getLb_available() {
		return lb_available;
	}

	public JLabel getLb_available_content() {
		return lb_available_content;
	}

	public JLabel getLb_amount() {
		return lb_amount;
	}

}
