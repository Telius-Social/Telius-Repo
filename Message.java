import java.util.ArrayList;
import java.util.Scanner;

public class Message {
	public static void chat(String username1,String username4) {
		ArrayList<String> messages=new ArrayList<String>();
		boolean stop=false;
		System.out.println("Enter first username: ");
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
			System.out.print(User.usernames.get(index1)+" enter message:");
			String message1=input1.next();
			System.out.println(User.usernames.get(index1)+":"+message1);
			System.out.print("|||||"+
					          "||||");
			System.out.print(User.usernames.get(index2));
			System.out.print(User.usernames.get(index2));
			System.out.print(" enter message:");
			String message2=input2.next();
			System.out.println(User.usernames.get(index2)+":"+message2);
			System.out.print("|||||"+
			          "||||");
			System.out.println("enter 1 to stop 2 to continue: ");
			int sit=input1.nextInt();		
			if(sit==1) {
			stop=true;
		}
		}
}
}
