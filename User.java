import java.util.Scanner;
import java.util.ArrayList;
import java.lang.*;
public class User {
private static String email;
private static String username;
private static String password;
private static String studentId;
private static ArrayList<String> emails=new ArrayList<String>();
private static ArrayList<String> usernames=new ArrayList<String>(); 
private static ArrayList<String> passwords=new ArrayList<String>(); 
private static ArrayList<String> studentIds=new ArrayList<String>();
private static ArrayList<User> users=new ArrayList<User>();
public static Scanner input=new Scanner(System.in);
	public User(String email,String username,String password,String studentId) {
		this.email=email;
		this.username=username;
		this.password=password;
		this.studentId=studentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String toString(){
		return String.format("Email:%s%nUsername:%s%nPassword:%s%nStudentId:%s%n", email,username,password,studentId);
	}

	public boolean contains(String email2) {
		return false;
	}
	public static void register() {
		boolean makeAnAccount=false;
		while(makeAnAccount==false) {
			System.out.println("Enter your email:");
			String email=input.next();
			System.out.println("Enter your username: ");
			String username=input.next();
			System.out.println("Enter your password: ");
			String password=input.next();
			System.out.println("Enter your studentId: ");
			String studentId=input.next();
			makeAnAccount=checkAvailability(email,username,password,studentId);
			if(makeAnAccount==false) {
				System.out.println("Enter your credentials again");
			}
		}
		if(makeAnAccount==true) {
			emails.add(email);
			usernames.add(username);
			passwords.add(password);
			studentIds.add(studentId);
			users.add(new User(email,username,password,studentId));
			System.out.println("You have been registered");
		}
		
		}

	private static boolean checkAvailability(String email2, String username2,String password2 ,String studentId2) {
		boolean result=true;
		if(emails.contains(email2)||usernames.contains(username2)||(password2.length()<8 || password2.length()>64)||studentIds.contains(studentId2)) {
			result=false;
		}
		return result;
	}

}
