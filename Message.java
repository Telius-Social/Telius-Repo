import java.util.ArrayList;
import java.util.Scanner;

public class Message { // if Message extended User, we would be able to go without some extra code and also use the inherited fields without re-reading/ checking/ writing them
	public static void chat(String username1,String username4) { // for example, username1 (the user's username) could have been inherited by the User class
		ArrayList<String> messages=new ArrayList<String>(); 
		boolean stop=false;
		System.out.println("Enter first username: "); // why do we need to re-learn and re-check the sender's username if they have already logged in?
		Scanner input1=new Scanner(System.in);
		username1=input1.next();
		System.out.println("Enter second username:  "); 
		Scanner input2=new Scanner(System.in);
		username4=input2.next();
		int index1=0;
		int index2=0;
		for(int i=0;i<User.usernames.size();i++) {
			if(username1==User.usernames.get(i)) {
				index1=i;
			}
			if(username4==User.usernames.get(i)) {
				index2=i;
			}
		}
		while(stop==false) {
			System.out.print(User.usernames.get(index1)+" enter message:"); // needs try catch block (at least 1 char, no more than 1000 chars or smth)
			// messageID
			String message1=input1.next();
			System.out.println(User.usernames.get(index1)+":"+message1);
			System.out.print("|||||"+
					          "||||");
			String messageID=
			System.out.print(User.usernames.get(index2));
			System.out.print(" enter message:");
			String message2=input2.next();
			System.out.println(User.usernames.get(index2)+":"+message2);
			System.out.print("|||||"+
			          "||||");
			System.out.println("enter 1 to stop, 2 to continue: ");
			int sit=input1.nextInt();		
			if(sit==1) {
			stop=true;
		}
		}
}
}
