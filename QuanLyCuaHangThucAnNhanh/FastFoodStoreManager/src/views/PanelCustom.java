package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelCustom {
	private int x, y, width, height = 0;
	private Color foreColor, backgroundColor = null;

	private JPanel p;
	private JButton btn;
	private JTextField text;
	private JPasswordField ps;
	private GridBagConstraints gbc;

	public PanelCustom(int x, int y, int width, int height, int round, Color foreColor, Color backgroundColor) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.foreColor = foreColor;
		this.backgroundColor = backgroundColor;

		this.p = new JPanel(new GridBagLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Dimension arcs = new Dimension(round, round);
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				graphics.setColor(backgroundColor);
				graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);// paint background
				graphics.setColor(foreColor);
				graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);// paint border
			}
		};
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.CENTER;

		this.p.setOpaque(false);
		this.p.setBounds(x, y, width, height);
	}

	public void setBound(JPanel panel) {
		panel.setBounds(x, y, width, height);
	}

	public JPanel createButton(String content, Font font, Color textColor) {
		this.btn = new JButton(content);
		this.btn.setBorder(null);
		this.btn.setFont(font);
		this.btn.setForeground(textColor);
		this.btn.setBackground(this.backgroundColor);
		this.btn.setFocusPainted(false);
		this.btn.setCursor(new Cursor(12));
		this.btn.setPreferredSize(new Dimension(this.width - 10, this.height - 4));

		this.p.setCursor(new Cursor(12));
		this.p.add(this.btn, this.gbc);

		return p;
	}

	public JPanel createTextFiel(int column, Font font) {
		this.text = new JTextField();
		this.text.setBorder(null);
		this.text.setFont(font);
		this.text.setColumns(column);

		this.p.add(this.text, this.gbc);
		return p;
	}

	public JPanel createPasswordTextFiel(int column, Font font) {
		this.ps = new JPasswordField();
		this.ps.setBorder(null);
		this.ps.setFont(font);
		this.ps.setColumns(column);

		this.p.add(this.ps, this.gbc);
		setBound(this.p);
		return p;
	}

	public JPanel getP() {
		return p;
	}

	public JButton getBtn() {
		return btn;
	}

	public JTextField getText() {
		return text;
	}

	public JPasswordField getPs() {
		return ps;
	}

}
