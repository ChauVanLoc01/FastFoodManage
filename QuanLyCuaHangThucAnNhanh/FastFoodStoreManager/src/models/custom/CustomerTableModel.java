package models.custom;

import java.util.Date;
import java.util.List;

import models.PersonObserver;

public class CustomerTableModel extends CustomTableModel {
	private List<PersonObserver> dataList;
	private String[] columnNames = { "Name", "Sex", "Birth Day", "Email", "Phone", "Status" };

	public CustomerTableModel(List<PersonObserver> dataList) {
		this.dataList = dataList;
	}

	public int getRowCount() {
		return dataList.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public Object getValueAt(int row, int column) {
		PersonObserver product = dataList.get(row);
		Date d = product.getPerson().getDateOfBirth();

		switch (column) {
		case 0:
			return product.getPerson().getName();
		case 1:
			return product.getPerson().getSex();
		case 2:
			if (d != null) {
				int day = d.getDate();
				int month = d.getMonth() + 1;
				int year = d.getYear() + 1900;
				return day + "/" + month + "/" + year;
			}
			return "";
		case 3:
			return product.getPerson().getAccount().getEmail();
		case 4:
			return product.getPerson().getPhone();
		case 5:
			return product.getPerson().getAccount().getStatus();
		default:
			return null;
		}
	}

	@Override
	public Object getItem(int row) {
		return this.dataList.get(row);
	}
}
