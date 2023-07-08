package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumnModel;

import models.PersonObserver;
import models.ProductObserver;
import models.custom.CustomTableModel;
import models.custom.CustomerTableModel;
import models.custom.EmployeeTableModel;
import models.custom.ProductTableModel;
import models.person.employee.Cashier;
import models.person.employee.KitchenStaff;
import models.person.employee.Shipper;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageBase extends JPanel {
	private JPanel primary_panel;
	private JPanel panel_title;
	private JLabel lb_title;
	private JButton btnNewButton;
	private JButton btn_create;
	private JButton btnCancel;
	private JButton btnDisable;
	private JPanel panel_btn;
	private JPanel panel_change;
	private JPanel content_panel;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnOtherGender;
	private ButtonGroup buttonGroup;
	private JTextField jt_name;
	private JTextField jt_cccd;
	private JTextField jt_phone;
	private JTextField jt_email;
	private JComboBox ex_day;
	private JComboBox ex_month;
	private JComboBox ex_year;
	private JComboBox comboBoxType;
	private JComboBox dob_day;
	private JComboBox dob_month;
	private JComboBox dob_year;
	private JTextArea ta_address;
	private JPanel panel_list;
	private JTable table;
	private JScrollPane scrollPane;
	private CustomTableModel model;

	public ManageBase(List<PersonObserver> personObserver, List<ProductObserver> productObserver, String rule) {
		setBackground(SystemColor.window);
		setBorder(null);
		setLayout(null);
		setBounds(0, 0, 1261, 619);

		primary_panel = new JPanel();
		primary_panel.setBorder(new LineBorder(SystemColor.windowBorder, 1, true));
		primary_panel.setBackground(SystemColor.window);
		primary_panel.setBounds(0, 0, 400, 584);
		add(primary_panel);
		primary_panel.setLayout(null);

		panel_title = new JPanel();
		panel_title.setBackground(new Color(224, 224, 224));
		panel_title.setBounds(0, 0, 400, 50);
		primary_panel.add(panel_title);
		panel_title.setLayout(null);

		initTitle();
		initContent(true, rule);
		initList(personObserver, null, rule);
	}

	public void initList(List<PersonObserver> personObservers, List<ProductObserver> productObserver, String rule) {
		panel_list = new JPanel();
		panel_list.setBorder(new MatteBorder(0, 1, 0, 0, (Color) SystemColor.controlShadow));
		panel_list.setBackground(SystemColor.window);
		panel_list.setBounds(399, 0, 825, 584);
		add(panel_list);
		panel_list.setLayout(null);

		if (rule.equals("Customer")) {
			model = new CustomerTableModel(personObservers);
		} else if (rule.equals("Employee")) {
			model = new EmployeeTableModel(personObservers);
		} else {
			model = new ProductTableModel(productObserver);
		}

		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setBackground(SystemColor.window);
		scrollPane.setBorder(new MatteBorder(0, 1, 0, 0, (Color) SystemColor.controlShadow));
		scrollPane.setBounds(0, 0, 825, 584);
		panel_list.add(scrollPane);

		table = new JTable(model);
		table.setDoubleBuffered(true);
		table.setRowHeight(27);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setBorder(new MatteBorder(0, 1, 0, 0, (Color) SystemColor.controlShadow));
		table.setBackground(SystemColor.window);
		scrollPane.setViewportView(table);

		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 20));

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				setAll(personObservers.get(table.getSelectedRow()));
				lb_title.setText("Information");
				initChangeButton();
				
			}
		});

		if (rule.equals("Customer")) {
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(180);
			columnModel.getColumn(1).setPreferredWidth(50);
			columnModel.getColumn(2).setPreferredWidth(70);
			columnModel.getColumn(3).setPreferredWidth(150);
			columnModel.getColumn(4).setPreferredWidth(100);
			columnModel.getColumn(5).setPreferredWidth(50);
		} else if (rule.equals("Employee")) {
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(200);
			columnModel.getColumn(1).setPreferredWidth(70);
			columnModel.getColumn(2).setPreferredWidth(50);
			columnModel.getColumn(3).setPreferredWidth(70);
			columnModel.getColumn(4).setPreferredWidth(100);
			columnModel.getColumn(5).setPreferredWidth(70);
			columnModel.getColumn(6).setPreferredWidth(50);
		} else {
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(200);
			columnModel.getColumn(1).setPreferredWidth(80);
			columnModel.getColumn(2).setPreferredWidth(50);
			columnModel.getColumn(3).setPreferredWidth(50);
		}
	}

	public void initTitle() {
		lb_title = new JLabel("Information");
		lb_title.setBounds(140, 0, 260, 50);
		panel_title.add(lb_title);
		lb_title.setBackground(new Color(212, 212, 212));
		lb_title.setBorder(null);
		lb_title.setHorizontalTextPosition(SwingConstants.CENTER);
		lb_title.setHorizontalAlignment(SwingConstants.LEFT);
		lb_title.setFont(new Font("Tahoma", Font.BOLD, 20));

		btnNewButton = new JButton("Create");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setAll(null);
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(new Color(255, 99, 71));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(10, 11, 95, 32);
		panel_title.add(btnNewButton);
	}

	public void initCreateButton() {
		if (panel_change != null) {
			primary_panel.remove(panel_change);
		}
		panel_btn = new JPanel();
		panel_btn.setBackground(new Color(224, 224, 224));
		panel_btn.setBounds(0, 503, 400, 81);
		primary_panel.add(panel_btn);
		panel_btn.setLayout(null);

		btn_create = new JButton("Create");
		btn_create.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_create.setForeground(SystemColor.text);
		btn_create.setBackground(SystemColor.desktop);
		btn_create.setBounds(246, 5, 104, 39);
		panel_btn.add(btn_create);
	}

	public void initChangeButton() {
		if (panel_btn != null) {
			primary_panel.remove(panel_btn);
		}
		panel_change = new JPanel();
		panel_change.setBackground(SystemColor.window);
		panel_change.setBounds(0, 504, 400, 80);
		primary_panel.add(panel_change);
		panel_change.setLayout(null);

		btnNewButton = new JButton("Save");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(270, 0, 98, 33);
		panel_change.add(btnNewButton);

		btnCancel = new JButton("Cancel");
		btnCancel.setFocusPainted(false);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setForeground(SystemColor.text);
		btnCancel.setBackground(new Color(139, 0, 0));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(150, 0, 98, 33);
		panel_change.add(btnCancel);

		btnDisable = new JButton("Disable");
		btnDisable.setFocusPainted(false);
		btnDisable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDisable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDisable.setBounds(21, 0, 105, 33);
		panel_change.add(btnDisable);

	}

	public void initContent(boolean isRead, String rule) {
		content_panel = new JPanel();
		content_panel.setBackground(SystemColor.window);
		content_panel.setBounds(0, 50, 400, 445);
		primary_panel.add(content_panel);
		content_panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(36, 20, 68, 26);
		content_panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(36, 61, 68, 26);
		content_panel.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(36, 143, 68, 26);
		content_panel.add(lblSex);
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblCccd = new JLabel("CCCD");
		lblCccd.setBounds(36, 104, 68, 26);
		content_panel.add(lblCccd);
		lblCccd.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(36, 223, 68, 26);
		content_panel.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setBounds(36, 180, 79, 26);
		content_panel.add(lblBirthday);
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 17));

		buttonGroup = new ButtonGroup();

		rdbtnFemale = new JRadioButton("FeMale");
		rdbtnFemale.setBounds(128, 146, 86, 23);
		content_panel.add(rdbtnFemale);
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnFemale.setFocusPainted(false);
		rdbtnFemale.setBackground(Color.WHITE);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(216, 145, 70, 23);
		content_panel.add(rdbtnMale);
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnMale.setFocusPainted(false);
		rdbtnMale.setBackground(Color.WHITE);

		rdbtnOtherGender = new JRadioButton("Other");
		rdbtnOtherGender.setBounds(288, 145, 80, 23);
		content_panel.add(rdbtnOtherGender);
		buttonGroup.add(rdbtnOtherGender);
		rdbtnOtherGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnOtherGender.setFocusPainted(false);
		rdbtnOtherGender.setBackground(Color.WHITE);

		jt_name = new JTextField();
		jt_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jt_name.setBounds(128, 61, 240, 30);
		content_panel.add(jt_name);

		jt_cccd = new JTextField();
		jt_cccd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jt_cccd.setBounds(128, 102, 240, 30);
		content_panel.add(jt_cccd);

		String EmployeeType[] = { "Cashier", "Shipper", "Kitchen Staff" };

		comboBoxType = new JComboBox(EmployeeType);
		comboBoxType.setBackground(SystemColor.window);
		comboBoxType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxType.setBounds(128, 20, 240, 30);
		content_panel.add(comboBoxType);
		if (rule.equals("Customer")) {
			comboBoxType.setEnabled(false);
		}

		dob_day = new JComboBox();
		dob_day.setBounds(128, 181, 57, 30);
		content_panel.add(dob_day);

		dob_month = new JComboBox();
		dob_month.setBounds(206, 181, 57, 30);
		content_panel.add(dob_month);

		dob_year = new JComboBox();
		dob_year.setBounds(290, 181, 78, 30);
		content_panel.add(dob_year);

		jt_email = new JTextField();
		jt_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jt_email.setBounds(128, 222, 240, 30);
		content_panel.add(jt_email);

		JLabel lblPhone_1 = new JLabel("Phone");
		lblPhone_1.setBounds(36, 265, 68, 26);
		content_panel.add(lblPhone_1);
		lblPhone_1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jt_phone = new JTextField();
		jt_phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jt_phone.setBounds(128, 264, 240, 30);
		content_panel.add(jt_phone);

		JLabel lblExpire = new JLabel("Expire");
		lblExpire.setBounds(36, 307, 79, 26);
		content_panel.add(lblExpire);
		lblExpire.setFont(new Font("Tahoma", Font.PLAIN, 17));

		ex_day = new JComboBox();
		ex_day.setBounds(128, 308, 57, 30);
		content_panel.add(ex_day);

		ex_month = new JComboBox();
		ex_month.setBounds(206, 308, 57, 30);
		content_panel.add(ex_month);

		ex_year = new JComboBox();
		ex_year.setBounds(290, 308, 78, 30);
		content_panel.add(ex_year);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(36, 351, 79, 26);
		content_panel.add(lblAddress);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));

		ta_address = new JTextArea();
		ta_address.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ta_address.setBorder(new LineBorder(SystemColor.scrollbar));
		ta_address.setBounds(128, 353, 240, 73);
		content_panel.add(ta_address);
	}

	public void setAll(PersonObserver personObserver) {
		if (personObserver instanceof Cashier) {
			comboBoxType.setSelectedIndex(0);
		} else if (personObserver instanceof Shipper) {
			comboBoxType.setSelectedIndex(1);
		} else if (personObserver instanceof KitchenStaff) {
			comboBoxType.setSelectedIndex(2);
		}
		if (personObserver != null) {
			jt_name.setText(personObserver.getPerson().getName());
			jt_cccd.setText(personObserver.getPerson().getCccd());
			jt_email.setText(personObserver.getPerson().getAccount().getEmail());
			jt_phone.setText(personObserver.getPerson().getPhone());
			ta_address.setText(personObserver.getPerson().getAddress());
			if (panel_change != null) {
				primary_panel.remove(panel_change);
			}
			initChangeButton();
		} else {
			if (panel_btn != null) {
				primary_panel.remove(panel_btn);
			}
			initCreateButton();
			lb_title.setText("Create Employee");
			jt_name.setText("");
			jt_cccd.setText("");
			jt_email.setText("");
			jt_phone.setText("");
			ta_address.setText("");
		}
	}

	private JRadioButton getSelectedRadioButton(ButtonGroup buttonGroup) {
		ButtonModel selectedModel = buttonGroup.getSelection();
		if (selectedModel != null) {
			for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
				JRadioButton radioButton = (JRadioButton) buttons.nextElement();
				if (radioButton.getModel() == selectedModel) {
					return radioButton;
				}
			}
		}
		return null;
	}
}
