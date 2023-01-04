import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Like {
public static void likeAmessge(String mess, boolean value) throws IOException {
	if(mess!=null && value == true) {
		likeGraphic();
	}
}
public static void dislikeAmessage(String mess, boolean value) throws IOException {
	if(mess != null && value==false) {
		dislikeGraphic();
	}
}
public static void likeGraphic() throws IOException {
	BufferedImage image = ImageIO.read(new File("C:\\Users\\User\\Desktop\\likeemoji.jpg"));
	ImageIcon likeIcon = new ImageIcon(image);
	JFrame frame = new JFrame();
	frame.setLayout(new FlowLayout());
	frame.setSize(300, 250);
	JLabel label = new JLabel();
	label.setIcon(likeIcon);
	frame.add(label);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void dislikeGraphic() throws IOException {
	BufferedImage image = ImageIO.read(new File("C:\\Users\\User\\Desktop\\dislikeemoji.jpg"));
	ImageIcon dislikeIcon = new ImageIcon(image);
	JFrame frame = new JFrame();
	frame.setLayout(new FlowLayout());
	frame.setSize(300, 260);
	JLabel label = new JLabel();
	label.setIcon(dislikeIcon);
	frame.add(label);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}