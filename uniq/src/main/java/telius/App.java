package telius;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * class App --- The menu of the App
 * @author Dimitra Paravatou
 * @author Michael Gianoulis
 * 
 */
public class App {
    /**
     * class GraphicPane--- inner class to show Graphics 
     * @author Dimitra Paravatou
     * @author Michael Gianoulis
     * 
     */
    public String a;
    class GraphicPane extends JComponent implements ActionListener {
        private JFrame parent;
        /**
         * Constructor of class GraphicPane
         * @param parent
         */
        public GraphicPane(JFrame parent) {
            
            super();
            this.parent = parent;
            
        }
        
        /* (non-Javadoc)
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(parent, "To use our app, please follow the instructions in the black box and close the UniQ window", "Welcome!", JOptionPane.INFORMATION_MESSAGE);
        }
        /* (non-Javadoc)
         * @see javax.swing.JComponent#paint(java.awt.Graphics)
         */
        @Override public void paint(Graphics g) {
            g.setFont(new Font(Font.SERIF , Font.BOLD, 40));
            g.setColor(Color.BLUE);
            g.drawString("Hello, Student!", 250, 400);
            String localDir=System.getProperty("resources.dir");
            try {
                //System.out.println(localDir);
                BufferedImage bi = ImageIO.read(new File( "..\\src\\main\\resources\\Logo.png"));
                //(..\\..\\resources\\Logo.png)
                g.drawImage(bi, 105, 0, parent);
            } catch (IOException e) {
                System.err.println("Could not load image");
            }
           
        }
    }
    
    /**
     * method App()
     * The constractor of App class
     */
    public App() {
        JFrame frame = new JFrame("UniQ App by team Telius");
        GraphicPane gp = new GraphicPane(frame);
        

        
        frame.setBounds(0,0, 800, 600);
        
        frame.setLayout(new BorderLayout());        
        frame.add(gp, BorderLayout.CENTER);
        JButton bu = new JButton("Let's Begin");
        bu.setFont(new Font(Font.SERIF,Font.BOLD,30));
        bu.setBackground(Color.CYAN);
        bu.addActionListener(new GraphicPane(frame));
        frame.add((bu),BorderLayout.SOUTH);
        
        
        // Remember, the method show() is deprecated
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    /**
     * Prints the menu of the App to the user
     * @param args
     * 
     */
    public static void main(String[] args) {
        File directory = new File("./");
		String a = directory.getAbsolutePath();
        new App();
        //File.getFilePointer();
        
        int selection;
        do{
        System.out.println( "Type '1' if you want to be a part of our community and sign up" ); 
        System.out.println( "if you already have an account type '2' for login " );
        System.out.println("Type 3 if you want to exit");
        

        Scanner an = new Scanner(System.in);
        selection = an.nextInt();
       }while(selection<1 || selection>3);
        
        try { 
        Files.loadFiles();
       
            if (selection == 1 ) { 
                
                //register
                Register_Login.register();
                     
                
            } else if (selection == 2 ) {

                //login
                Register_Login.login();
   
            } 
        }catch (IOException e) {
            e.printStackTrace();
        }

       int me = 0;
       Scanner dot = new Scanner(System.in);
        
       do{
         System.out.println("Ready to send a message?");
         System.out.println("Type 4 to see your messages or 5 to send a new one or 6 to logout");
        
         me = dot.nextInt();
        
            try {
            

                if (me == 4) { 

                 //seeMessage
                 Message.seeAmessage();

                } else if ( me == 5) {
                  
                  //sendMessage
                  Message.sendAmessage();
                }

        
            }catch (ClassNotFoundException e) {
              e.printStackTrace(); 

            }catch (IOException e) {
             e.printStackTrace();
            }
        
        }while(me != 6);

        if(selection == 3 || me == 6 ) { //logout
            System.out.println("You have sucessfully logged out"); 
            System.exit(0);
        }
        
        // dot.close();
        
       //an.close();
        
    }

}
