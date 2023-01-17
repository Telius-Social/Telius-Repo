 package telius;

 import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**class Like --- Programm for the like and dislike functions
 * @author Michael Gianoulis
 * @author Dimitra Paravatou
 * 
 * 
*/
    public class Like {
	

       
        /**
         * method likeAmessage() --- Is used for the Like function
		     * 
         * @param mess String
         * @param value boolean
         * @throws IOException
         * 
         */
        public static void likeAmessge(String mess, boolean value) throws IOException { 
	      if(mess != null && value == true) {
		        likeGraphic();
	        }
        }

         /**
         * method dislikeAmessage()---Is used for the Dislike function
		     * 
         * @param mess String
         * @param value boolean
         * @throws IOException
         * 
         */
        public static void dislikeAmessage(String mess, boolean value) throws IOException {
	        if(mess != null && value == false) {
				
		        dislikeGraphic();
	        }
        }

         /**
          * method likeGraphic()--- Is used to show the Like image
		      * 
          * @throws IOException
          * 
          */
        public static void likeGraphic() throws IOException {

	      BufferedImage image = ImageIO.read(new File("..\\src\\main\\resources\\like.jpg"));
	      ImageIcon likeIcon = new ImageIcon(image);
	      JFrame frame = new JFrame();
	      frame.setLayout(new FlowLayout());
	      frame.setSize(300, 250);
	      JLabel label = new JLabel();
	      label.setIcon(likeIcon);
	      frame.add(label);
	      frame.setVisible(true);
	      frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }

         /**
          * method dislikeGraphic()---Is used to show the Dislike image
		      * 
          * @throws IOException
          * 
          */
        public static void dislikeGraphic() throws IOException {
	      BufferedImage image = ImageIO.read(new File("..\\src\\main\\resources\\dislike.jpg"));
	      ImageIcon dislikeIcon = new ImageIcon(image);
	      JFrame frame = new JFrame();
	      frame.setLayout(new FlowLayout());
	      frame.setSize(300, 260);
	      JLabel label = new JLabel();
	      label.setIcon(dislikeIcon);
	      frame.add(label);
	      frame.setVisible(true);
	      frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }

    }
