package views;

import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;

import javax.swing.JLabel;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.SystemColor;

public class Work extends JPanel {
	private JButton btnCheck;

	/**
	 * Create the panel.
	 */
	public Work() {
		setBackground(SystemColor.window);
		setBounds(0, 0, 1228, 619);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Lương hiện tại trong tháng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(89, 66, 290, 40);
		add(lblNewLabel);

		JPanel jp_dateTime = new JPanel();
		jp_dateTime.setBackground(SystemColor.window);
		jp_dateTime.setBounds(550, 66, 523, 310);
		add(jp_dateTime);

		JCalendar calendar = new JCalendar();
		calendar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		calendar.setPreferredSize(new Dimension(500, 300));
		jp_dateTime.add(calendar);

		calendar.addPropertyChangeListener("calendar", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("calendar")) {
					Date selectedDate = calendar.getDate();
					System.out.println(selectedDate);
//		            JOptionPane.showMessageDialog(this,
//		                    "Message Example",
//		                    "Title Example",
//		                    JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnCheck = new JButton("Điểm danh");
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCheck.setBounds(717, 379, 181, 33);
		add(btnCheck);

		JLabel lblNewLabel_1 = new JLabel("10$");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(385, 66, 197, 40);
		add(lblNewLabel_1);
	}

}
