package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.time.YearMonth;
import java.util.Date;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import constant.Sex;
import controller.ProfileController;
import models.PersonObserver;
import models.person.customer.Customer;

public class Profile extends JPanel {
	private JTextField jt_fullName;
	private JTextField jt_phone;
	private JTextField jt_cccd;
	private JTextField jt_email;
	private JPasswordField jt_currentPassword;
	private JPasswordField jt_newPassword;
	private JPasswordField jt_confirmNewPassword;
	private JPasswordField passwordField_3;
	private JLabel lb_avatar;
	private JButton btnChangeImage;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnOtherGender;

	private String full_name;
	private String email;
	private String cccd;
	private String phone;
	private Date dob;
	private JLabel lb_error;
	private JComboBox comboBoxMonth;
	private JComboBox comboBoxYear;
	private JComboBox comboBoxDay;
	private JPanel panel_2;
	private JPanel panel;
	private JPanel jp_payment;
	private JTextArea ta_address;
	private ButtonGroup group;
	private JButton btn_addGatewayPayment;

	private ProfileController profileController;
	private JButton btn_savePassword;

	private JPanel primary;
	private JLabel lb_money;

	/**
	 * Create the panel.
	 */
	public Profile(PersonObserver personObserver, JPanel panel) {
		profileController = new ProfileController(personObserver);
		this.primary = panel;

		setBackground(SystemColor.window);
		setBounds(0, 0, 1228, 619);
		setLayout(null);
		ImageIcon juice = new ImageIcon("../FastFoodStoreManager/img/avatar.png");
		Image imageJuice = juice.getImage();
		Image resizeImageJuice = imageJuice.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon juiceImg = new ImageIcon(resizeImageJuice);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlightText);
		panel_1.setBounds(0, 0, 1228, 619);
		add(panel_1);
		panel_1.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel_2.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_2.setBackground(SystemColor.window);
		panel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 0, 718, 619);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("INFORMATION");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(0, 0, 718, 50);
		panel_2.add(lblNewLabel_2);

		JLabel lblFullName = new JLabel("Name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFullName.setBounds(253, 70, 150, 30);
		panel_2.add(lblFullName);

		jt_fullName = new JTextField();
		jt_fullName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jt_fullName.setBounds(413, 70, 270, 30);
		panel_2.add(jt_fullName);
		jt_fullName.setColumns(10);

		JLabel lblFullName_1 = new JLabel("PhoneNumber");
		lblFullName_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFullName_1.setBounds(253, 264, 150, 30);
		panel_2.add(lblFullName_1);

		JLabel lblFullName_2 = new JLabel("CCCD");
		lblFullName_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFullName_2.setBounds(253, 314, 160, 30);
		panel_2.add(lblFullName_2);

		JLabel lblFullName_3 = new JLabel("Address");
		lblFullName_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFullName_3.setBounds(253, 369, 150, 30);
		panel_2.add(lblFullName_3);

		jt_phone = new JTextField();
		jt_phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jt_phone.setColumns(10);
		jt_phone.setBounds(413, 264, 270, 30);
		panel_2.add(jt_phone);

		jt_cccd = new JTextField();
		jt_cccd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jt_cccd.setColumns(10);
		jt_cccd.setBounds(413, 314, 270, 30);
		panel_2.add(jt_cccd);

		JScrollPane scrollPaneAddress = new JScrollPane();
		scrollPaneAddress.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneAddress.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneAddress.setBounds(413, 369, 270, 105);
		panel_2.add(scrollPaneAddress);

		ta_address = new JTextArea();
		ta_address.setFont(new Font("Tahoma", Font.PLAIN, 17));
		ta_address.setLineWrap(true);
		scrollPaneAddress.setViewportView(ta_address);

		rdbtnFemale = new JRadioButton(Sex.FEMALE);
		rdbtnFemale.setFocusPainted(false);
		rdbtnFemale.setBackground(SystemColor.window);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnFemale.setBounds(413, 118, 86, 23);
		panel_2.add(rdbtnFemale);

		JLabel lblFullName_1_1 = new JLabel("Gender");
		lblFullName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFullName_1_1.setBounds(253, 118, 150, 30);
		panel_2.add(lblFullName_1_1);

		JLabel lblBirthday = new JLabel("Day Of Birthday");
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBirthday.setBounds(253, 158, 150, 30);
		panel_2.add(lblBirthday);

		rdbtnMale = new JRadioButton(Sex.MALE);
		rdbtnMale.setFocusPainted(false);
		rdbtnMale.setBackground(SystemColor.window);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnMale.setBounds(501, 118, 70, 23);
		panel_2.add(rdbtnMale);

		rdbtnOtherGender = new JRadioButton(Sex.OTHER);
		rdbtnOtherGender.setFocusPainted(false);
		rdbtnOtherGender.setBackground(SystemColor.window);
		rdbtnOtherGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnOtherGender.setBounds(573, 118, 80, 23);
		panel_2.add(rdbtnOtherGender);

		group = new ButtonGroup();
		group.add(rdbtnFemale);
		group.add(rdbtnMale);
		group.add(rdbtnOtherGender);

		JButton btn_saveInformation = new JButton("Save");
		btn_saveInformation.setFocusPainted(false);
		btn_saveInformation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int month = (int) comboBoxMonth.getSelectedItem();
				int year = (int) comboBoxYear.getSelectedItem();
				String sex = getSelectedRadioButton(group).getText();
				String name = jt_fullName.getText();
				String email = jt_email.getText();
				String phone = jt_phone.getText();
				String address = ta_address.getText();
				String cccd = jt_cccd.getText();
				if (comboBoxDay.getSelectedItem() != null) {
					int day = (int) comboBoxDay.getSelectedItem();
					setTextAll(profileController.updateProfile(cccd, name, new Date(year, month, day), sex, phone,
							email, address));
				} else {
					setTextAll(profileController.updateProfile(cccd, name, null, sex, phone, email, address));
				}
			}
		});
		btn_saveInformation.setForeground(SystemColor.text);
		btn_saveInformation.setBackground(SystemColor.desktop);
		btn_saveInformation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_saveInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_saveInformation.setBounds(506, 533, 150, 30);
		panel_2.add(btn_saveInformation);

		JLabel lblBirthday_1 = new JLabel("Email");
		lblBirthday_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBirthday_1.setBounds(253, 214, 150, 30);
		panel_2.add(lblBirthday_1);

		jt_email = new JTextField();
		jt_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jt_email.setColumns(10);
		jt_email.setBounds(413, 214, 270, 30);
		panel_2.add(jt_email);

		lb_avatar = new JLabel();
		lb_avatar.setIcon(Helper.getImageIconScale("../FastFoodStoreManager/img/avatar.png", 174, 174));
		lb_avatar.setBounds(31, 70, 174, 174);
		panel_2.add(lb_avatar);

		btnChangeImage = new JButton("Change Image");
		btnChangeImage.setFocusPainted(false);
		btnChangeImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnChangeImage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChangeImage.setBounds(31, 282, 174, 30);
		panel_2.add(btnChangeImage);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setTextAll(personObserver);
			}
		});
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBackground(new Color(128, 0, 0));
		btnCancel.setBounds(329, 533, 150, 30);
		panel_2.add(btnCancel);
		btnChangeImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showFileChooser();
			}
		});

		comboBoxDay = new JComboBox<>();
		comboBoxDay.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxDay.setBounds(413, 159, 70, 30);
		panel_2.add(comboBoxDay);

		comboBoxMonth = new JComboBox<>();
		comboBoxMonth.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxMonth.setBounds(501, 158, 70, 30);
		panel_2.add(comboBoxMonth);

		comboBoxYear = new JComboBox<>();
		comboBoxYear.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxYear.setBounds(593, 158, 75, 30);
		panel_2.add(comboBoxYear);

		if (personObserver instanceof Customer) {
			jp_payment = new JPanel();
			jp_payment.setBorder(new LineBorder(new Color(0, 0, 0)));
			jp_payment.setBackground(SystemColor.window);
			jp_payment.setBounds(717, 294, 511, 325);
			panel_1.add(jp_payment);
			jp_payment.setLayout(null);

			JLabel lblNewLabel_2_1_1 = new JLabel("PAYMENT");
			lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblNewLabel_2_1_1.setBounds(0, 0, 511, 41);
			jp_payment.add(lblNewLabel_2_1_1);
			ImageIcon creditCard = new ImageIcon("../FastFoodStoreManager/img/creditCard.jpg");
			Image imageCreditCard = creditCard.getImage();
			Image resizeImageCreditCard = imageCreditCard.getScaledInstance(367, 181, Image.SCALE_SMOOTH);
			ImageIcon creditCardImg = new ImageIcon(resizeImageCreditCard);

			JLabel lb_amount = new JLabel("Amount");
			lb_amount.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lb_amount.setBounds(48, 126, 150, 30);
			jp_payment.add(lb_amount);

			passwordField_3 = new JPasswordField();
			passwordField_3.setBounds(247, 126, 200, 30);
			jp_payment.add(passwordField_3);

			JButton btn_savePayment = new JButton("Recharge");
			btn_savePayment.setFocusPainted(false);
			btn_savePayment.setForeground(SystemColor.text);
			btn_savePayment.setBackground(SystemColor.desktop);
			btn_savePayment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btn_savePayment.setBounds(320, 193, 150, 30);
			jp_payment.add(btn_savePayment);
			btn_savePayment.setFont(new Font("Tahoma", Font.PLAIN, 20));

			JLabel lblFullName_6_2_1 = new JLabel("Money in account");
			lblFullName_6_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblFullName_6_2_1.setBounds(48, 77, 161, 30);
			jp_payment.add(lblFullName_6_2_1);

			lb_money = new JLabel();
			lb_money.setForeground(new Color(139, 0, 0));
			lb_money.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lb_money.setBounds(247, 77, 200, 30);
			lb_money.setText(((Customer) personObserver).getGateway() != null
					? "" + ((Customer) personObserver).getGateway().getMoney()
					: "No Gateway Payment");
			jp_payment.add(lb_money);

			if (((Customer) personObserver).getGateway() == null) {
				btn_addGatewayPayment = new JButton("Add Gateway Payment");
				btn_addGatewayPayment.setForeground(Color.WHITE);
				btn_addGatewayPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btn_addGatewayPayment.setFocusPainted(false);
				btn_addGatewayPayment.setBackground(new Color(139, 0, 0));
				btn_addGatewayPayment.setBounds(66, 193, 240, 30);
				btn_addGatewayPayment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				jp_payment.add(btn_addGatewayPayment);
			}
		}

		panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(SystemColor.window);
		panel.setBounds(717, 0, 511, 294);
		panel_1.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("PASSWORD");
		lblNewLabel_2_1.setBounds(0, 0, 511, 50);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel lblFullName_6 = new JLabel("Password");
		lblFullName_6.setBounds(44, 67, 150, 30);
		panel.add(lblFullName_6);
		lblFullName_6.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jt_currentPassword = new JPasswordField();
		jt_currentPassword.setBounds(243, 67, 200, 30);
		panel.add(jt_currentPassword);

		jt_newPassword = new JPasswordField();
		jt_newPassword.setBounds(243, 122, 200, 30);
		panel.add(jt_newPassword);

		JLabel lblFullName_6_1 = new JLabel("New Password");
		lblFullName_6_1.setBounds(44, 121, 150, 30);
		panel.add(lblFullName_6_1);
		lblFullName_6_1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblFullName_6_1_1 = new JLabel("Confirm New Password");
		lblFullName_6_1_1.setBounds(44, 179, 200, 30);
		panel.add(lblFullName_6_1_1);
		lblFullName_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jt_confirmNewPassword = new JPasswordField();
		jt_confirmNewPassword.setBounds(243, 179, 200, 30);
		panel.add(jt_confirmNewPassword);

		jt_confirmNewPassword.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				checkConfirmPassword();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				checkConfirmPassword();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkConfirmPassword();
			}
		});

		btn_savePassword = new JButton("Save");
		btn_savePassword.setFocusPainted(false);
		btn_savePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String currentPassword = jt_currentPassword.getText();
				String newPassword = jt_newPassword.getText();
				if (!currentPassword.equals(newPassword)
						&& profileController.changePassword(currentPassword, newPassword)) {
					JOptionPane.showMessageDialog(getPanel(), "Change password success!", "Change password",
							JOptionPane.INFORMATION_MESSAGE);
					jt_currentPassword.setText("");
					jt_newPassword.setText("");
					jt_confirmNewPassword.setText("");
				} else {
					JOptionPane.showMessageDialog(getPanel(), "Change password fail!", "Change password",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_savePassword.setBackground(SystemColor.desktop);
		btn_savePassword.setForeground(SystemColor.text);
		btn_savePassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_savePassword.setBounds(293, 235, 150, 30);
		panel.add(btn_savePassword);
		btn_savePassword.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lb_error = new JLabel("invalid");
		lb_error.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lb_error.setForeground(new Color(255, 255, 255));
		lb_error.setBounds(253, 163, 129, 14);
		panel.add(lb_error);

		setTextAll(personObserver);
		initDataDateOfBirth(personObserver);
	}

	public void showFileChooser() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif"));

		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			if (selectedFile != null) {
				try {
					// Đọc file ảnh và lấy kích thước
					Image image = ImageIO.read(selectedFile);
					int width = image.getWidth(null);
					int height = image.getHeight(null);

					// Tạo ảnh mới chỉ lấy nửa trái
					Image leftHalfImage = image.getScaledInstance(width / 2, height, Image.SCALE_SMOOTH);

					ImageIcon icon = new ImageIcon(leftHalfImage);
					lb_avatar.setIcon(Helper.getImageIconScale(selectedFile.getAbsolutePath(), 200, 200));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public void setTextAll(PersonObserver personObserver) {
		jt_fullName.setText(personObserver.getPerson().getName());
		jt_email.setText(personObserver.getPerson().getAccount().getEmail());
		jt_phone.setText(personObserver.getPerson().getPhone());
		jt_cccd.setText(personObserver.getPerson().getCccd() != null ? personObserver.getPerson().getCccd() : "");
		ta_address.setText(
				personObserver.getPerson().getAddress() != null ? personObserver.getPerson().getAddress().toString()
						: "");
		selectedSex(personObserver.getPerson().getSex() != null ? personObserver.getPerson().getSex() : "");
	}

	public void selectedSex(String sex) {
		if (sex.equals(Sex.FEMALE)) {
			rdbtnFemale.setSelected(true);
		} else if (sex.equals(Sex.MALE)) {
			rdbtnMale.setSelected(true);
		} else {
			rdbtnOtherGender.setSelected(true);
		}
	}

	public void checkConfirmPassword() {
		if (jt_newPassword.getText().equals(jt_confirmNewPassword.getText())) {
			lb_error.setForeground(SystemColor.white);
		} else {
			lb_error.setForeground(new Color(238, 77, 45));
		}
	}

	public void initDataDateOfBirth(PersonObserver personObserver) {
		int currentYear = new Date().getYear();
		Object[] years = new Integer[currentYear];
		for (int i = 0; i < currentYear; i++) {
			years[i] = 1900 + i;
		}
		comboBoxYear.setModel(new DefaultComboBoxModel<>(years));

		Object[] months = new Integer[12];
		for (int i = 0; i < 12; i++) {
			months[i] = i + 1;
		}
		comboBoxMonth.setModel(new DefaultComboBoxModel<>(months));

		comboBoxMonth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lấy tháng được chọn
				int selectedMonth = (int) comboBoxMonth.getSelectedItem();

				// Lấy số ngày trong tháng được chọn
				YearMonth yearMonthObject = YearMonth.of(new Date().getYear() + 1900, selectedMonth);
				int daysInMonth = yearMonthObject.lengthOfMonth();

				// Cập nhật danh sách các ngày trong JComboBox ngày
				Integer[] days = new Integer[daysInMonth];
				for (int i = 0; i < daysInMonth; i++) {
					days[i] = i + 1;
				}
				comboBoxDay.setModel(new DefaultComboBoxModel<>(days));
			}
		});
		comboBoxDay.setSelectedItem(personObserver.getPerson().getDateOfBirth() != null
				? personObserver.getPerson().getDateOfBirth().getDate()
				: 1);
		comboBoxMonth.setSelectedItem(personObserver.getPerson().getDateOfBirth() != null
				? personObserver.getPerson().getDateOfBirth().getMonth() + 1
				: 1);
		comboBoxYear.setSelectedItem(personObserver.getPerson().getDateOfBirth() != null
				? personObserver.getPerson().getDateOfBirth().getYear() + 1900
				: 2023);
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

	public JPanel getPanel() {
		return this.primary;
	}
}