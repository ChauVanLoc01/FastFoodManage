package views;

import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

public class Calendar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calendar frame = new Calendar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calendar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 10, 400, 400);
		contentPane.add(calendar);
		calendar.setTodayButtonVisible(true);
//		jCalendar.setWeekOfYearVisible(false);
		calendar.addPropertyChangeListener("calendar", new PropertyChangeListener() {
		    @Override
		    public void propertyChange(PropertyChangeEvent evt) {
		        if (evt.getPropertyName().equals("calendar")) {
		            Date selectedDate = calendar.getDate();
//		            JOptionPane.showMessageDialog(this,
//		                    "Message Example",
//		                    "Title Example",
//		                    JOptionPane.INFORMATION_MESSAGE);
		        }
		    }
		});
		System.out.println(calendar.getCalendar());
	}
	public void createUI(JPanel contentPane) {
		

		


	}

}
