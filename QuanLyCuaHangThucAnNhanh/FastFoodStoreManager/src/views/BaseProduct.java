package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class BaseProduct extends JPanel {
	private JPanel jp_product;
	private JPanel jp_beverage;
	public BaseProduct() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 527, 585);
		add(scrollPane);
		
		jp_product = new JPanel();
		scrollPane.setViewportView(jp_product);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(537, 0, 348, 585);
		add(scrollPane_1);
		
		jp_beverage = new JPanel();
		scrollPane_1.setViewportView(jp_beverage);
		
	}

}
