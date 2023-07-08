package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import constant.Frame;
import models.Admin;
import models.PersonObserver;
import models.person.employee.Employee;

public class Navigate extends JPanel {
	private JButton btnMenu = new JButton();
	private JButton btnHistory = new JButton();
	private JButton btnProfile = new JButton();
	private JButton btnLogOut = new JButton();
	private JButton btnManage = new JButton();
	private JButton btnWork = new JButton();
	private JLabel lblNewLabel_4_3;
	private JLabel lblNewLabel_4_4;

	public Navigate(JPanel panel, CardLayout cardLayout, JPanel main_panel, CardLayout cardLayoutMain,
			PersonObserver person) {
		setBackground(Color.WHITE);
		setBounds(0, 0, 78, 616);
		setLayout(null);

		btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenu.setBackground(SystemColor.scrollbar);
		btnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(panel, "Menu");
				btnMenu.setBackground(SystemColor.scrollbar);
				btnHistory.setBackground(Color.WHITE);
				btnProfile.setBackground(Color.WHITE);
				btnManage.setBackground(Color.WHITE);
				btnWork.setBackground(Color.WHITE);
			}
		});
		btnMenu.setBorder(null);
		btnMenu.setFocusPainted(false);
		btnMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		ImageIcon iconMenu = new ImageIcon("../FastFoodStoreManager/img/icon/menu.png");
		btnMenu.setIcon(iconMenu);
		btnMenu.setBounds(0, 0, 78, 70);
		add(btnMenu);
		cardLayout.show(panel, "Menu");
		JLabel lblNewLabel_4 = new JLabel(person instanceof Admin ? "Order" : "Menu");
		lblNewLabel_4.setEnabled(false);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(0, 70, 78, 14);
		add(lblNewLabel_4);

		if (!(person instanceof Admin)) {
			btnHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnHistory.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cardLayout.show(panel, "History");
					btnMenu.setBackground(Color.WHITE);
					btnHistory.setBackground(SystemColor.scrollbar);
					btnProfile.setBackground(Color.WHITE);
					btnManage.setBackground(Color.WHITE);
					btnWork.setBackground(Color.WHITE);
				}
			});
			btnHistory.setBorder(null);
			btnHistory.setFocusPainted(false);
			btnHistory.setBackground(Color.WHITE);
			ImageIcon iconHistory = new ImageIcon("../FastFoodStoreManager/img/icon/history.png");
			btnHistory.setIcon(iconHistory);
			btnHistory.setBounds(0, 95, 78, 70);
			add(btnHistory);

			JLabel lblNewLabel_4_1 = new JLabel("History");
			lblNewLabel_4_1.setEnabled(false);
			lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_4_1.setBounds(0, 164, 78, 20);
			add(lblNewLabel_4_1);

		}
		btnProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(panel, "Profile");
				btnMenu.setBackground(Color.WHITE);
				btnHistory.setBackground(Color.WHITE);
				btnProfile.setBackground(SystemColor.scrollbar);
				btnManage.setBackground(Color.WHITE);
				btnWork.setBackground(Color.WHITE);
			}
		});
		btnProfile.setBorder(null);
		btnProfile.setFocusPainted(false);
		btnProfile.setBackground(Color.WHITE);
		ImageIcon iconFrofile = new ImageIcon("../FastFoodStoreManager/img/icon/profile.png");
		btnProfile.setIcon(iconFrofile);

		btnProfile.setBounds(0, 195, 78, 70);
		add(btnProfile);

		JLabel lblNewLabel_4_2 = new JLabel("Frofile");
		lblNewLabel_4_2.setEnabled(false);
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 15));

		lblNewLabel_4_2.setBounds(0, 266, 78, 14);

		add(lblNewLabel_4_2);

		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(main_panel, "Do you want to sign out?", "Sign out",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					cardLayoutMain.show(main_panel, Frame.login);
				}
			}
		});

		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.setBorder(null);
		btnLogOut.setFocusPainted(false);
		btnLogOut.setBackground(Color.WHITE);
		ImageIcon iconLogOut = new ImageIcon("../FastFoodStoreManager/img/icon/logout.png");
		btnLogOut.setIcon(iconLogOut);
		btnLogOut.setBounds(0, 546, 78, 70);
		add(btnLogOut);

		if (person instanceof Admin) {
			btnManage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnManage.setFocusPainted(false);
			btnManage.setBorder(null);
			btnManage.setBackground(Color.WHITE);
			btnManage.setBounds(0, 95, 78, 70);
			add(btnManage);
			btnManage.setIcon(Helper.getImageIconScale("../FastFoodStoreManager/img/user.png", 70, 70));

			lblNewLabel_4_3 = new JLabel("Manage");
			lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_4_3.setEnabled(false);
			lblNewLabel_4_3.setBounds(0, 165, 78, 17);
			add(lblNewLabel_4_3);

			btnManage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cardLayout.show(panel, "Person");
					btnMenu.setBackground(Color.WHITE);
					btnHistory.setBackground(Color.WHITE);
					btnProfile.setBackground(Color.WHITE);
					btnManage.setBackground(SystemColor.scrollbar);
					btnWork.setBackground(Color.WHITE);
				}
			});
		}
		if (person instanceof Employee) {
			btnWork.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnWork.setFocusPainted(false);
			btnWork.setBorder(null);
			btnWork.setBackground(Color.WHITE);
			btnWork.setBounds(0, 396, 78, 70);
			add(btnWork);
			btnWork.setIcon(Helper.getImageIconScale("../FastFoodStoreManager/img/work.png", 70, 70));

			lblNewLabel_4_4 = new JLabel("Work");
			lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4_4.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel_4_4.setEnabled(false);
			lblNewLabel_4_4.setBounds(0, 470, 78, 14);
			add(lblNewLabel_4_4);

			btnWork.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cardLayout.show(panel, "Work");
					btnMenu.setBackground(Color.WHITE);
					btnHistory.setBackground(Color.WHITE);
					btnProfile.setBackground(Color.WHITE);
					btnManage.setBackground(Color.WHITE);
					btnWork.setBackground(SystemColor.scrollbar);
				}
			});
		}
	}

	public JPanel getPanel() {
		return this;
	}

}
