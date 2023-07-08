package views;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

public class SwingTableExample extends JFrame {

	public SwingTableExample(ArrayList<MyObject> dataList) {
		setTitle("Swing Table Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Tạo một custom table model với danh sách object và các tên cột
		CustomTableModel tableModel = new CustomTableModel(dataList);

		// Tạo JTable với custom table model
		JTable table = new JTable(tableModel);

		// Thêm JTable vào JScrollPane để hỗ trợ cuộn
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);

		pack();
		setLocationRelativeTo(null);
	}

	// Custom table model kế thừa từ AbstractTableModel
	class CustomTableModel extends AbstractTableModel {
		private ArrayList<MyObject> dataList;
		private String[] columnNames = { "Column 1", "Column 2", "Column 3" };

		public CustomTableModel(ArrayList<MyObject> dataList) {
			this.dataList = dataList;
		}

		@Override
		public int getRowCount() {
			return dataList.size();
		}

		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public String getColumnName(int column) {
			return columnNames[column];
		}

		@Override
		public Object getValueAt(int row, int column) {
			MyObject myObject = dataList.get(row);
			switch (column) {
			case 0:
				return myObject.getProperty1();
			case 1:
				return myObject.getProperty2();
			case 2:
				return myObject.getProperty3();
			default:
				return null;
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ArrayList<MyObject> dataList = new ArrayList<>();
			dataList.add(new MyObject("Value 1", "Value 2", "Value 3"));
			dataList.add(new MyObject("Value 4", "Value 5", "Value 6"));
			dataList.add(new MyObject("Value 7", "Value 8", "Value 9"));

			SwingTableExample example = new SwingTableExample(dataList);
			example.setVisible(true);
		});
	}
}

// Định nghĩa lớp MyObject để biểu diễn đối tượng trong ArrayList
class MyObject {
	private String property1;
	private String property2;
	private String property3;

	public MyObject(String property1, String property2, String property3) {
		this.property1 = property1;
		this.property2 = property2;
		this.property3 = property3;
	}

	public String getProperty1() {
		return property1;
	}

	public String getProperty2() {
		return property2;
	}

	public String getProperty3() {
		return property3;
	}
}
