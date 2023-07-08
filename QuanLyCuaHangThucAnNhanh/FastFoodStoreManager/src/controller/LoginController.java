package controller;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constant.Frame;
import models.Admin;
import models.PersonObserver;
import models.Subject;
import views.Home;

public class LoginController {
	public LoginController(String email, String password, JPanel panel, CardLayout cardLayout, Subject subject,
			JLabel lb_err) {
		PersonObserver person = login(email, password, subject);
		if (person != null) {
			if (person instanceof Admin) {
				
			}
			Home home = new Home(panel, cardLayout, person, subject);
			panel.add(home, Frame.home);
			cardLayout.show(panel, Frame.home);
		} else {
			lb_err.setForeground(new Color(238, 77, 45));
		}
	}

	public PersonObserver login(String email, String password, Subject subject) {
		return subject.login(email, password);
	}
}
