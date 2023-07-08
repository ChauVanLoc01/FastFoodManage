package views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.OrderController;
import models.Item;
import models.ProductObserver;

public class Food extends JPanel {
	private JScrollPane scrollPane = new JScrollPane();
	private JScrollPane scrollPane_1 = new JScrollPane();

	public Food(List<ProductObserver> foods, List<ProductObserver> beverages, OrderController orderController) {
		setBackground(SystemColor.desktop);
		setLayout(null);
		setBounds(0, 0, 703, 585);

		init(foods, beverages, orderController);
	}

	public void init(List<ProductObserver> foods, List<ProductObserver> beverages, OrderController orderController) {
		scrollPane.setViewportView(null);
		scrollPane.setBounds(0, 0, 348, 585);
		Helper.speedScroll(scrollPane);
		add(scrollPane);

		JPanel jp_food = new JPanel(new GridLayout(0, 2, 10, 10));
		jp_food.setBackground(SystemColor.desktop);
		scrollPane.setViewportView(jp_food);

		for (int i = 0; i < foods.size(); i++) {
			Product product = new Product(foods.get(i), orderController);
			product.setPreferredSize(new Dimension(169, 290));
			jp_food.add(product);
		}

		scrollPane_1.setViewportView(null);
		scrollPane_1.setBounds(355, 0, 348, 585);
		Helper.speedScroll(scrollPane_1);
		add(scrollPane_1);

		JPanel jp_beverageFood = new JPanel(new GridLayout(0, 2, 10, 10));
		jp_beverageFood.setBackground(SystemColor.desktop);
		scrollPane_1.setViewportView(jp_beverageFood);

		for (int i = 0; i < beverages.size(); i++) {
			Product product = new Product(beverages.get(i), orderController);
			product.setPreferredSize(new Dimension(169, 290));
			jp_beverageFood.add(product);
		}
	}
}