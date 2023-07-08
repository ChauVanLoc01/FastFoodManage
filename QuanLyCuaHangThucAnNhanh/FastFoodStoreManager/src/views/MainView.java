package views;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constant.Frame;
import models.Subject;

public class MainView extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;
	private Login login;
	private Register register;
	private Home home;

	public void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainView(Subject subject) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1350, 756);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);

		login = new Login();
		JPanel loginPanel = login.createLogin(contentPane, cardLayout, subject);
		contentPane.add(loginPanel, Frame.login);

		register = new Register();
		JPanel registerPanel = register.createRegister(contentPane, cardLayout, subject);
		contentPane.add(registerPanel, Frame.register);

		cardLayout.show(contentPane, Frame.login);
		setContentPane(contentPane);
	}

}
