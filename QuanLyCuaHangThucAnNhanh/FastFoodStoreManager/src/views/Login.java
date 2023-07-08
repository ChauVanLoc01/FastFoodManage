package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constant.Colors;
import constant.Fonts;
import constant.Frame;
import controller.LoginController;
import models.Subject;

public class Login {
	private JPanel contentPane;
	private JLabel lb_email;
	private JLabel lb_error;
	private JLabel lb_password;
	private PanelCustom passwordPanelCustom;
	private PanelCustom emailPanelCustom;

	public Login() {
	}

	public JPanel createLogin(JPanel parentPanel, CardLayout cardLayout, Subject subject) {
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image image = new ImageIcon("img\\primary.jpg").getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(new BorderLayout());

		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Dimension arcs = new Dimension(15, 15); // Border corners arcs {width,height}, change this to whatever
														// you want
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				graphics.setColor(getBackground());
				graphics.fillRoundRect(contentPane.getWidth() * 1 / 5, contentPane.getHeight() * 1 / 10,
						contentPane.getWidth() * 3 / 5, contentPane.getHeight() * 8 / 10, 15, 15);// paint background
			}
		};
		panel.setOpaque(false);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login to your account");
		lblNewLabel.setFont(Fonts.tahoma_bold_40);
		lblNewLabel.setBounds(365, 140, 485, 53);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Welcome back");
		lblNewLabel_1.setFont(Fonts.tahoma_plain_25);
		lblNewLabel_1.setBounds(365, 100, 187, 41);
		panel.add(lblNewLabel_1);

		lb_email = new JLabel("Email");
		lb_email.setFont(Fonts.tahoma_plain_25);
		lb_email.setBounds(365, 221, 82, 31);
		panel.add(lb_email);

		lb_error = new JLabel("Email or password invalid");
		lb_error.setFont(Fonts.tahoma_plain_20);
		lb_error.setForeground(SystemColor.white);
		lb_error.setBounds(465, 223, 400, 31);
		panel.add(lb_error);

		emailPanelCustom = new PanelCustom(365, 270, 606, 49, 15, new Color(223, 228, 234), new Color(255, 255, 255));
		JPanel emailPanel = emailPanelCustom.createTextFiel(38, Fonts.tahoma_plain_18);
		panel.add(emailPanel);

		lb_password = new JLabel("Password");
		lb_password.setFont(Fonts.tahoma_plain_25);
		lb_password.setBounds(365, 350, 149, 31);
		panel.add(lb_password);

		passwordPanelCustom = new PanelCustom(365, 399, 606, 49, 15, new Color(223, 228, 234),
				new Color(255, 255, 255));
		JPanel passwordPanel = passwordPanelCustom.createPasswordTextFiel(38, Fonts.tahoma_plain_18);
		panel.add(passwordPanel);

		JLabel lb_forgot_password = new JLabel("Forgot password?");
		lb_forgot_password.setForeground(new Color(112, 161, 255));
		lb_forgot_password.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lb_forgot_password.setBounds(524, 422, 187, 31);
		panel.add(lb_forgot_password);

		JLabel lblNewLabel_3 = new JLabel("Bạn chưa có tài khoản?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(500, 575, 199, 28);
		panel.add(lblNewLabel_3);

		PanelCustom panelLoginCustom = new PanelCustom(365, 497, 606, 59, 15, new Color(223, 228, 234), Colors.blue);
		JPanel loginPanel = panelLoginCustom.createButton("Login", Fonts.tahoma_bold_20, new Color(255, 255, 255));
		panel.add(loginPanel);
		panelLoginCustom.getBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginController(emailPanelCustom.getText().getText(), passwordPanelCustom.getPs().getText(),
						parentPanel, cardLayout, subject, lb_error);
			}
		});

		JLabel lb_register_now = new JLabel("Đăng ký ngay");
		lb_register_now.setForeground(new Color(238, 77, 45));
		lb_register_now.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb_register_now.setBounds(700, 575, 130, 28);
		lb_register_now.setCursor(new Cursor(12));
		panel.add(lb_register_now);

		lb_register_now.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(parentPanel, Frame.register);
			}
		});

		return contentPane;
	}
}
