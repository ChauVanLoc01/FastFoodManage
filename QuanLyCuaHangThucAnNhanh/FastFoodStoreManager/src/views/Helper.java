package views;

import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import models.ProductObserver;

public class Helper {
	public static ImageIcon getImageIconScale(String path, int width, int height) {
		return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}

	public static void speedScroll(JScrollPane scrollPane) {
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10); // Tăng tốc độ cuộn dọc
		scrollPane.getVerticalScrollBar().setBlockIncrement(50);
	}

	public static void showFileChooser(JPanel panel, JLabel lable) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif"));

		int result = fileChooser.showOpenDialog(panel);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			if (selectedFile != null) {
				try {
					// Đọc file ảnh và lấy kích thước
					Image image = ImageIO.read(selectedFile);
					int width = image.getWidth(null);
					int height = image.getHeight(null);

					// Tạo ảnh mới chỉ lấy nửa trái
					Image leftHalfImage = image.getScaledInstance(width / 2, height, Image.SCALE_SMOOTH);

					ImageIcon icon = new ImageIcon(leftHalfImage);
					lable.setIcon(icon);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
