package views;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import models.PersonObserver;
import models.Subject;

public class Home extends JPanel {

	private CardLayout cardLayout;
	private JPanel jp_content;
	private JPanel primary_panel;
	private JPanel nav_panel;
	private JPanel content_panel;
	private JPanel history_panel;
	private JPanel profile_panel;
	private JPanel work_panel;
	private JPanel work_person;

	public Home(JPanel parentPanel, CardLayout cardLayoutMain, PersonObserver personObserver, Subject subject) {
		cardLayout = new CardLayout();
		setLayout(null);
		setBounds(0, 0, 1350, 756);

		primary_panel = new JPanel();
		primary_panel.setBackground(SystemColor.desktop);
		primary_panel.setBounds(0, 85, 1336, 634);
		primary_panel.setLayout(null);

		this.add(primary_panel);

		jp_content = new JPanel();
		jp_content.setBounds(98, 0, 1228, 619);
		primary_panel.add(jp_content);
		jp_content.setLayout(cardLayout);

		nav_panel = new Navigate(jp_content, cardLayout, parentPanel, cardLayoutMain, personObserver);
		nav_panel.setBounds(10, 0, 78, 619);
		primary_panel.add(nav_panel);

		content_panel = new Menu(personObserver, subject, parentPanel);
		jp_content.add(content_panel, "Menu");

		history_panel = new History();
		jp_content.add(history_panel, "History");

		profile_panel = new Profile(personObserver, this);
		jp_content.add(profile_panel, "Profile");

		work_panel = new Work();
		jp_content.add(work_panel, "Work");

		work_person = new PersonManage(subject);
		jp_content.add(work_person, "Person");

		cardLayout.show(jp_content, "Menu");

		JPanel jp_title = new JPanel();
		jp_title.setBackground(SystemColor.desktop);
		jp_title.setBounds(0, 0, 1336, 86);
		jp_title.setLayout(null);
		this.add(jp_title);

		JLabel lblNewLabel = new JLabel("FAST FOOD STORE");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(0, 10, 1336, 69);
		jp_title.add(lblNewLabel);
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));

		JLabel lb_logo = new JLabel();
		lb_logo.setBounds(10, 10, 78, 69);
		jp_title.add(lb_logo);
		lb_logo.setIcon(Helper.getImageIconScale("../FastFoodStoreManager/img/logo.png", 80, 80));

	}
}