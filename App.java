import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class App {
	public static void main( String[] args ) {
        System.out.println( "Hello Student" );
        System.out.println( "It's a great day to become a member of our community! Type '1' if you want to sign up!" );
        System.out.println( "Already have an account? Type '2' for login!" );
        Scanner an = new Scanner(System.in);
        int selection = an.nextInt();
        String ok = " ";
        if (selection == 1) {
            //καλει τη μεθοδο register 
            ok = RegisterUser.register();
            //αν ηταν επιτυχής θα γυρισει ενα true που θα μπει στο ok
        } else if (selection == 2) {
            System.out.println("ok");
            ok = Login.makeLogin();
        }
        if (ok != " ") {
            System.out.println( "Ready to sent a message ? Type '1' for Yes" );
            try {
            	Message.chat(ok);
            	Scanner in  = new Scanner(System.in);
            	int chat = in.nextInt();
            	if (chat == 1)
            	{ Chat.SentMessage(); }
            	System.out.println( "Ready to see your messages and maybe like them ? if so, press '2' " );
            	Scanner ans = new Scanner(System.in);
            	int mes = ans.nextInt();
            	if (mes == 2)
            	{ Chat.SeeMessage(); }
            	ans.close();
            	in.close();
            } catch (FileNotFoundException e) {
                System.out.println("We should find the file");
            //να γυρισει πανω 
            } catch (IOException e) {
                System.out.println("We warned you about IO");
            }
        }
        an.close();
    }
}
