import java.io.IOException;
import java.util.Scanner;

public class Register_Login {
	public static String email;
	public static String username;
	public static String password;
	public static String studentId;
	public static void register() throws IOException {
		int state=0;
		String[] warnings= new String[5];
		Scanner input = new Scanner(System.in);
		do {
		state=0;	
		System.out.println("Enter your email:");
		email=input.next();
		if(Files.checkRegister(email, Files.emails, Files.dataEmails)==true) {
		++state;
		warnings[1]="Unavailable email,choose a different email";
		}
		System.out.println("Enter your username: ");
		username=input.next();
		if(Files.checkRegister(username, Files.usernames, Files.dataUsernames)==true) {
			++state;
			warnings[2]="Unavailable username,choose a different username";
			}
		System.out.println("Enter your password: ");
		password=input.next();
		if(password.length()<8 || password.length()>64) {
			++state;
			warnings[3]="Invalid password email,choose a different pawwsord that has 8 to 64 characters";
			}
		System.out.println("Enter your studentId: ");
		studentId=input.next(); 
		if(Files.checkRegister(email, Files.studentID, Files.dataID)==true) {
			++state;
			warnings[4]="Unavailable studentID,choose a different studentID";
			}
		if(state>0) {
			warnings[4]="Invalid credentials, please enter the necessary fields ";
		}
		for(int i = 0;i<5;i++) {
			if(warnings[i]!=null&&state>0) {
				System.out.println(warnings[i]);
			}
		
		}
		} while (state > 0);
		if (state==0) {
			Files.updateFiles(email, username, password, studentId);
			Files.closeFiles();
			System.out.println("You have been registered!");
		}
		System.out.println("Do you want to login?");
		int value=0;
		System.out.println("If you want to login press 1:");
		value=input.nextInt();
		if(value==1) {
			login();
		}
	}
	public static void login() throws IOException {
		String warning = "Invalid username/password please try again or register";
		int answer=0;
		boolean value1;
		boolean value2;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Enter your credentials");
			System.out.println();
			System.out.print("Username: ");
			username = input.next();
			value1 = Files.checkRegister(username, Files.usernames, Files.dataUsernames);
			System.out.print("Password: ");
			password = input.next();
			value2 = Files.checkRegister(password, Files.passwords, Files.dataPassword);
			if(value1==false||value2==false) {
				System.out.println(warning);
				System.out.println("If you want to register press 1");
				System.out.println("If you want to enter again your credentials enter 0");
				answer=input.nextInt();
			}
		}while((value1==false||value2==false)&&answer==0);
		if(answer==1) {
			register();
		}
		if(value1==true&&value2==true) {
			System.out.println("You have been logged in!");
		}
	}
}
