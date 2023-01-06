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
	public static String  receiver;
	public static ArrayList<String> messages=new ArrayList<String>();
	public static void sendAmessage() throws IOException {
		Scanner input = new Scanner(System.in);
		BufferedWriter in = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\chat.txt",true));
		System.out.print("Enter the user you want to send the message: ");
		receiver=input.next();
		boolean value = Files.checkRegister(receiver, Files.usernames, Files.dataUsernames);
		while(value==false) {
			System.out.println("This user does not exist");
			System.out.print("Enter again the username:");
			receiver= input.next();
			value = Files.checkRegister(receiver, Files.usernames, Files.dataUsernames);
		}
		if(value==true) {
			System.out.println("Enter the message you want to send: ");
			String mess=input.next();
			mess=String.format("From:%s%nTo:%s%nMessage:%s",UserExperience.username,receiver,mess);
			if(UserExperience.username!=null) {
				in.write(mess);
				in.newLine();
				in.close();
			}
		}
	}
	public static void seeAmessage() throws IOException, ClassNotFoundException {
		BufferedReader out = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\chat.txt"));
		Files.filesToLists(out, messages);
		String textReceiver=null;
		String textMessage=null;
		String textSender=null;
		for(int i=0;i<messages.size();i++) {
			if(messages.get(i).contains("From:")==true) {
				textSender=messages.get(i);
			}
			if(messages.get(i).contains("To:"+UserExperience.username)==true) {
				textReceiver=messages.get(i);
			}
			if(messages.get(i).contains("Message:")==true); {
				textMessage=messages.get(i);
			}
		}
	
		int answer=0;
		Scanner input = new Scanner(System.in);
		if(textSender!=null&&textReceiver!=null&&textMessage!=null) {
			String message=String.format("%s%n%s", textSender,textMessage);
			System.out.println(message);
			System.out.println("Enter 1 to like the message or 2 to dislike the message");
			answer=input.nextInt();
			if(answer==1) {
				Like.likeAmessge(answer);
			}
			if(answer==2) {
				Like.dislikeAmessage(answer);
			}
		} else {
			System.out.println(String.format("No new messages!"));
		}
		
	}
}
