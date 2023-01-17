package telius;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**class Message --- Programm for the message function
 * @author Michael Gianoulis
 * @author Dimitra Paravatou
 * 
 * 
*/
public class Message {
	public static String receiver;
	public static ArrayList<String> messages = new ArrayList<String>();

    /**
	 * method send Amessage()---Is used for the sent a message function 
	 * 
	 * @throws IOException
	 * 
	 */
	public static void sendAmessage() throws IOException {
		Scanner input = new Scanner(System.in);
		FileWriter fis = new FileWriter("..\\src\\main\\resources\\chat.txt", true);
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
		receiver = input.next();
		//checks if the requested receiver exists in the database
		boolean value = Files.checkForRegister(receiver, Files.usernames, Files.dataUsernames);
		while (value == false) {
			System.out.println("This user does not exist");
			System.out.print("Enter again the username:");
			receiver = input.next();
			value = Files.checkForRegister(receiver, Files.usernames, Files.dataUsernames);
		}
		if (value == true) {
			Scanner enter = new Scanner(System.in);
			System.out.print("Enter a message:");
			String message = enter.nextLine();
			String mess = String.format("From:%s%nTo:%s%nMessage:%s", Register_Login.username, receiver, message);
			//the message is saved to the file
			if (Register_Login.username != null) {
				out.write(mess);
				out.println();
				out.close();
			}
		}
	}
    
	/**
	 * method seeAmessage()---Is used for the see message function
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 *  
	 */
	public static void seeAmessage() throws IOException, ClassNotFoundException {
		BufferedReader out = new BufferedReader(new FileReader("..\\src\\main\\resources\\chat.txt"));
		//Loads the  BufferedReader object to an ArrayList for easier manipulation of it's contents
		Files.filesToLists(out, messages);
		ArrayList<String> texts = new ArrayList<String>();
		String textReceiver = null;
		String textMessage = null;
		String textSender = null;
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).contains("To:"+Register_Login.username)==true) {
				textSender = messages.get(i-1);
				textReceiver=messages.get(i);
			}
				if (messages.get(i).contains("Message:") == true && textSender != null&&textReceiver!=null) {
					textMessage = messages.get(i);
					String message1 = String.format("%s%n%s", textSender, textMessage);
					texts.add(message1);
					textSender = null;
					textReceiver=null;
				}
			
		}
		Scanner rew = new Scanner(System.in);
		for (int j = 0; j < texts.size(); j++) {
			System.out.println((j + 1) + ":" + texts.get(j));
			System.out.println("To like the message press 1,to dislike the message press 2, to continue press 0");
			int answer = rew.nextInt();
			if (answer == 1) {
				Like.likeAmessge(texts.get(j),true);
				Files.notification.write(texts.get(j)+"-->liked");
				Files.notification.println();
			}
			if (answer == 2) {
				Like.dislikeAmessage(texts.get(j),false);
				Files.notification.write(texts.get(j)+"-->disliked");
				Files.notification.println();
			}
		}
		if(texts.isEmpty()==true) {
			System.out.println("No messages!");
		}
		Files.notification.close();
		Files.notification.close();
	}
}
