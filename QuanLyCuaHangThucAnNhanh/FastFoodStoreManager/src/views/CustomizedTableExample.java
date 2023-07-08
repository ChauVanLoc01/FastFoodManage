package views;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class CustomizedTableExample {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			// Tạo JFrame
			JFrame frame = new JFrame("Customized JTable Example");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Tạo DefaultTableModel và JTable
			DefaultTableModel tableModel = new DefaultTableModel();
			tableModel.addColumn("Name");
			tableModel.addColumn("Age");
			tableModel.addColumn("Email");

			JTable table = new JTable(tableModel);

			// Tùy chỉnh giao diện cho JTable
			table.setRowHeight(30); // Đặt chiều cao của hàng
			table.setFont(new Font("Arial", Font.PLAIN, 14)); // Đặt font chữ
			table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14)); // Đặt font chữ cho tiêu đề

			// Tùy chỉnh căn giữa dữ liệu trong ô của JTable
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			table.setDefaultRenderer(Object.class, centerRenderer);

			// Đặt kích thước cột của JTable
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(150);
			columnModel.getColumn(1).setPreferredWidth(50);
			columnModel.getColumn(2).setPreferredWidth(200);

			// Thêm dữ liệu vào JTable
			tableModel.addRow(new Object[] { "John Doe", 30, "john.doe@example.com" });
			tableModel.addRow(new Object[] { "Jane Smith", 25, "jane.smith@example.com" });
			tableModel.addRow(new Object[] { "Mike Johnson", 35, "mike.johnson@example.com" });

			// Đặt JTable vào JScrollPane
			JScrollPane scrollPane = new JScrollPane(table);
			frame.getContentPane().add(scrollPane);

			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}
