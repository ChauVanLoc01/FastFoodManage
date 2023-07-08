package models.custom;

import java.util.List;

import models.ProductObserver;

public class ProductTableModel extends CustomTableModel {
	private List<ProductObserver> dataList;
	private String[] columnNames = { "Name", "Price", "Quantity", "Sold" };

	public ProductTableModel(List<ProductObserver> dataList) {
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
		ProductObserver product = dataList.get(row);
		switch (column) {
		case 0:
			return product.getProduct().getName();
		case 1:
			return product.getProduct().getPrice();
		case 2:
			return product.getProduct().getQuantity();
		case 3:
			return product.getProduct().getQuantitySold();
		default:
			return null;
		}
	}

	@Override
	public Object getItem(int row) {
		return this.dataList.get(row);
	}
}
