package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import models.ProductObserver;
import models.custom.CustomTableModel;
import models.custom.ProductTableModel;

import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class History extends JPanel {
	private JTable tableHistory;
	private JTabbedPane tabbedPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel panel_total;
	private JPanel panel_success;
	private JPanel panel_delivering;
	private JPanel panel_cancel;
	private JPanel panel_waiting_pay;
	private JTable table;
	private JScrollPane scrollPane;

	public History() {
		setBackground(SystemColor.window);
		setBounds(0, 0, 1228, 619);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Tổng chi tiêu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(82, 10, 114, 30);
		add(lblNewLabel);

		JLabel lblTngnHng = new JLabel("Tổng đơn hàng");
		lblTngnHng.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTngnHng.setBounds(308, 10, 140, 30);
		add(lblTngnHng);

		JLabel lblnHy = new JLabel("Đã hủy");
		lblnHy.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblnHy.setBounds(879, 50, 108, 30);
		add(lblnHy);

		JLabel lblChVnChuyn = new JLabel("Chờ vận chuyển");
		lblChVnChuyn.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblChVnChuyn.setBounds(570, 50, 140, 30);
		add(lblChVnChuyn);

		JLabel lblThnhCng = new JLabel("Thành công");
		lblThnhCng.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblThnhCng.setBounds(570, 10, 108, 30);
		add(lblThnhCng);

		JLabel lblChThanhTon = new JLabel("Chờ thanh toán");
		lblChThanhTon.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblChThanhTon.setBounds(879, 10, 140, 30);
		add(lblChThanhTon);

		JLabel lblNewLabel_1 = new JLabel("10$");
		lblNewLabel_1.setForeground(new Color(153, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(82, 50, 182, 30);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("10$");
		lblNewLabel_1_1.setForeground(new Color(153, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(308, 50, 182, 30);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("100");
		lblNewLabel_1_2.setForeground(SystemColor.desktop);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(740, 10, 108, 30);
		add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("100");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBounds(740, 50, 108, 30);
		add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("100");
		lblNewLabel_1_2_2.setForeground(new Color(204, 102, 0));
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_2.setBounds(1047, 10, 108, 30);
		add(lblNewLabel_1_2_2);

		JLabel lblNewLabel_1_2_2_1 = new JLabel("100");
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2_2_1.setBounds(1047, 50, 108, 30);
		add(lblNewLabel_1_2_2_1);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		tabbedPane.setAlignmentY(Component.TOP_ALIGNMENT);
		tabbedPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		tabbedPane.setBackground(new Color(153, 204, 204));
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(507, 90, 634, 507);
		add(tabbedPane);

		panel_total = new JPanel();
		panel_total.setBackground(SystemColor.window);
		panel_total.setBorder(null);
		panel_total.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.add("Total", panel_total);
		tabbedPane.setBackgroundAt(0, new Color(153, 204, 204));
		panel_total.setLayout(null);
		
//		initTotalOrderData();
		
		panel_success = new JPanel();
		panel_success.setBackground(SystemColor.window);
		panel_success.setBorder(null);
		panel_success.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.add("Success", panel_success);

		panel_delivering = new JPanel();
		panel_delivering.setBackground(SystemColor.window);
		panel_delivering.setBorder(null);
		panel_delivering.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.add("Delivering", panel_delivering);

		panel_cancel = new JPanel();
		panel_cancel.setBackground(SystemColor.window);
		panel_cancel.setBorder(null);
		panel_cancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.add("Cancel", panel_cancel);

		panel_waiting_pay = new JPanel();
		panel_waiting_pay.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_waiting_pay.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_waiting_pay.setBackground(SystemColor.window);
		panel_waiting_pay.setBorder(null);
		panel_waiting_pay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.add("Pay", panel_waiting_pay);
		panel_waiting_pay.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(200, 200, 200)));
		panel.setBackground(SystemColor.window);
		panel.setBounds(82, 91, 415, 506);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 415, 58);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Order");
		lblNewLabel_2.setBounds(0, 0, 415, 60);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_3 = new JLabel("Customer");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(38, 81, 88, 28);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(137, 81, 229, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Customer");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(38, 135, 88, 28);
		panel.add(lblNewLabel_3_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 135, 229, 30);
		panel.add(textField_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Customer");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_2.setBounds(38, 186, 88, 28);
		panel.add(lblNewLabel_3_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(137, 186, 229, 30);
		panel.add(textField_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Customer");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_3.setBounds(38, 238, 88, 28);
		panel.add(lblNewLabel_3_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(137, 238, 229, 30);
		panel.add(textField_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Customer");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_4.setBounds(38, 292, 88, 28);
		panel.add(lblNewLabel_3_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(137, 292, 229, 30);
		panel.add(textField_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Customer");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_5.setBounds(38, 343, 88, 28);
		panel.add(lblNewLabel_3_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(137, 343, 229, 30);
		panel.add(textField_5);

		

	}

	public void initTotalOrderData(List<ProductObserver> products) {
		CustomTableModel productModel = new ProductTableModel(products);
		scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.window);
		scrollPane.setBounds(0, 0, 629, 474);
		panel_total.add(scrollPane);
		
		table = new JTable(productModel);
		scrollPane.setViewportView(table);
		table.setBackground(SystemColor.window);
	}
}