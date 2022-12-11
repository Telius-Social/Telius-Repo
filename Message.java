package telius;
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
	public static void chat(String username1) throws FileNotFoundException, IOException {
		try {
		Scanner input = new Scanner(System.in);
		BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\Δήμητρα\\Desktop\\UniQ\\project building\\uniq\\src\\main\\java\\telius\\bechat.txt"));
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Δήμητρα\\Desktop\\UniQ\\project building\\uniq\\src\\main\\java\\telius\\bechat.txt"));
        //System.out.println("Enter your username");	
		//String username1=input.next();
		String username2 = " ";
		boolean count=true;
		try {
		while(count==true) {
				System.out.println("Ready to comnunicate with others? Press 1 to send a message or 2 to see your messages");
				int answer=input.nextInt();
				if(answer==1) {
					System.out.println("Enter the user you want to send the message:");
					username2 = input.next();

					System.out.println("Enter the message:");
					String mes=input.next();
					sendAmessage(out,mes);	
				}
				if(answer==2) {
					seeAmessage(in,username1);
				}
				System.out.println("Enter false if you want to stop:");
				
				count = input.hasNextBoolean();
				if (count == false) {
					System.out.println("Thank you for using our App");
				} 
			}
		} catch (InputMismatchException e) {
			System.out.println("You have to enter either 1 or 2: ");
		}
		input.close();

	} catch (FileNotFoundException e) {
		
		System.out.println("Give us a moment");

	} catch (IOException e) {
		System.out.println("Hold on a minute");

	}
	}
	public static void sendAmessage(BufferedWriter fis,String wer) throws IOException {
		fis.write(wer);
		fis.close();
	}
	public static void seeAmessage(BufferedReader tre,String x) throws IOException {
		if (tre.readLine() == null) {
			System.out.println("No new messages");
		} else {
		System.out.println(x +" sent you the message:"+":"+tre.readLine());
		System.out.println("Like a message? Type it's number");
		Scanner put = new Scanner(System.in);
		int m = put.nextInt();
		newLike(m);

		} 

	put.close();
	}
	public static int newLike(int numberOfLikes) {
		return ++numberOfLikes;
	}
}