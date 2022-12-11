import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Message {
	public String username;
	public String message;
	public Message(String usern,String str) {
		this.username=usern;
		this.message=str;
	}
	public String toString() {
		return String.format("%s: %s",username,message );
	}
	public static void chat() throws FileNotFoundException, IOException {
		Scanner input = new Scanner(System.in);
		BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\bechat.txt"));
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\bechat.txt"));
        System.out.println("Enter your username");	
		String username1=input.next();
		String username2;
		boolean count=true;
		try {
		while(count==true) {
				System.out.println("Press 1 to send a message or 2 to see your messages");
				int answer=input.nextInt();
				if(answer==1) {
					System.out.println("Enter the user you want to send the message:");
					username2=input.next();
					System.out.println("Enter the message:");
					String mes=input.next();
					sendAmessage(out,mes);	
				}
				if(answer==2) {
					seeAmessage(in,username1);
				}
				System.out.println("Enter true if you want to stop:");
				count=input.hasNextBoolean();
			}
		} catch (InputMismatchException e) {
			System.out.println("You have to enter either 1 or 2: ");
		}
		
	}
	public static void sendAmessage(BufferedWriter fis,String wer) throws IOException {
		fis.write(wer);
		fis.close();
	}
	public static void seeAmessage(BufferedReader tre,String x) throws IOException {
		System.out.println(x+"sent you the message:"+":"+tre.readLine());
	}
}
