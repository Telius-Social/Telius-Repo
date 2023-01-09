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

import main.java.telius.Files;
import main.java.telius.Register_Login;


public class App {
    class GraphicPane extends JComponent implements ActionListener {
        private JFrame parent;
        /**
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
            g.drawString("Hello Student!", 250, 400);
            try {
                BufferedImage bi = ImageIO.read(new File("logo.png"));
                g.drawImage(bi, 105, 0, parent);
            } catch (IOException e) {
                System.err.println("Could not load image");
            }
           
        }
    }
    
    /**
     * 
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
     * @param args
     */
    public static void main(String[] args) {
        new App();
        System.out.println( "Type '1' if you want to be a part of our community and sign up" ); 
        System.out.println( "if you already have an account type '2' for login " );
        System.out.println("Type 3 if you want to exit");
        

        Scanner an = new Scanner(System.in);
        int selection = an.nextInt();
        //String ok = " ";
        try { 
        Files.LoadFiles();
       // try {
        if (selection == 1 ) {
            
            Register_Login.register();
                
            //καλει τη μεθοδο register 
            //αν ηταν επιτυχής θα γυρισει ενα true που θα μπει στο 
        } else if (selection == 2 ) {
            //System.out.println("ok");
            Register_Login.login();

            
        }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (selection == 1 || selection == 2  ) { // logout
        System.out.println("Ready to send a message?");
        System.out.println("Type 1 to see your messages or 2 to send a new one or 3 to logout");
        }
        //selection = an.nextInt();

        //if (ok != " " ) { 

            //System.out.println( "Ready to sent a message ? Type '1' for Yes" ); 
           
            //Message.chat(ok); 
            //Scanner in  = new Scanner(System.in);
            //int chat = in.nextInt();
            //if(chat == 1 ) {

                //Chat.SentMessage();
            //}

            //System.out.println( "Ready to see your messages and maybe like them ? if so, press '2' " ); 
            //Scanner ans = new Scanner(System.in);
           // int mes = ans.nextInt();

           // if ( mes == 2 ) {

                //Chat.SeeMessage();
           // }

         //ans.close();
         //in.close();
          // }
           if (selection == 3 ) {
            System.out.println("You have sucessfully logged out"); 
            System.exit(0);
           }

        //} catch (FileNotFoundException e) {

            //System.out.println("We should find the file");

            //να γυρισει πανω 
        //}  catch (IOException e) {

           // System.out.println("We warned you about IO");
        //}
        

        
    
        an.close();
        
        
       


    }

}
