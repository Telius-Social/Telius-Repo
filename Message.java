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
		FileWriter fis = new FileWriter("C:\\Users\\User\\Desktop\\chat.txt", true);
		PrintWriter out = new PrintWriter(fis);
		System.out.println("You can send a message to the following users:");
		Files.filesToLists(Files.dataUsernames, Files.usernames);
		if (Files.usernames.isEmpty() == false) {
			for (int i = 0; i < Files.usernames.size(); i++) {
				if (Files.usernames.get(i) != null) {
					System.out.println(Files.usernames.get(i));
				}
			}
		}
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
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).contains("From:") == true
					&& messages.get(i).contains("From:" + UserExperience.username) == false
					&& messages.get(i).contains("Message:") == false) {
				textSender = messages.get(i);
			}
			if (textSender != UserExperience.username)
			{
				if (messages.get(i).contains("Message:") == true && textSender != null) {
					textMessage = messages.get(i);
					String message1 = String.format("%s%n%s", textSender, textMessage);
					texts.add(message1);
					textSender = null;
				}
			}
		}
		Scanner rew = new Scanner(System.in);
		for (int j = 0; j < texts.size(); j++) {
			System.out.println((j + 1) + ":" + texts.get(j));
			System.out.println("To like the message press 1,to dislike the message press 2, to continue press 0");
			int answer = rew.nextInt();
			if (answer == 1) {
				Like.likeAmessge(answer);
			}
			if (answer == 2) {
				Like.dislikeAmessage(answer);
			}
		}
		
	}
}
