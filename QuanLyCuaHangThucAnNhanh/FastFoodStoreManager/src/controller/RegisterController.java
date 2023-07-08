package controller;

import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constant.Frame;
import models.PersonObserver;
import models.Subject;
import views.Register;

public class RegisterController {

	public RegisterController(String name, String email, String password, String phone, JPanel panel,
			CardLayout cardLayout, Subject subject, Register register) {
		PersonObserver customer = register(name, email, password, phone, subject);
		if (customer != null) {
			JOptionPane.showMessageDialog(panel, "Sign up success - Direct to Sign In Page", "Sign Up", JOptionPane.INFORMATION_MESSAGE);
			register.reset();
			cardLayout.show(panel, Frame.login);
		} else {
			JOptionPane.showMessageDialog(panel, "Sign up fail", "Sign Up", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public PersonObserver register(String name, String email, String password, String phone, Subject subject) {
		return subject.register(name, phone, email, password);
	}
}
