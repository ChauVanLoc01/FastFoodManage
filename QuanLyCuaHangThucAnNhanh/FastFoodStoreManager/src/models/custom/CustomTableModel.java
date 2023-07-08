package models.custom;

import javax.swing.table.AbstractTableModel;

public abstract class CustomTableModel extends AbstractTableModel {
	public abstract int getRowCount();

	public abstract int getColumnCount();

	public abstract String getColumnName(int column);

	public abstract Object getValueAt(int row, int column);
	
	public abstract Object getItem(int row);
}
