package telius; 
import java.io.IOException;
import java.util.Scanner;

/**class Register_Login --- Programm for the register/login functions
 * @author Michael Gianoulis
 * @author Dimitra Paravatou
 * 
 * 
*/
public class Register_Login {
	protected static String email;
	protected static String username;
	protected static String password; 
	protected static String studentId;
	
	/**method register()---Is used for the register function
	 * @throws IOException
	 * 
	 */
	public static void register() throws IOException {
		
		int state = 0;
		String[] warnings = new String[5];
		Scanner input = new Scanner(System.in);
		do {
		  state = 0;	
		  System.out.println("Enter your email:");
		  email=input.next();
		  
		  //checks if the given email already exists in the database 
		  if(Files.checkForRegister(email, Files.emails, Files.dataEmails) == true) {
		     ++state;
		     warnings[1] = "Unavailable email,choose a different email";
		   }
	     
		  System.out.println("Enter your username: ");
		  username = input.next();
		  
		  //checks if the given username already exists in the database(so it won't be used again)
		  if(Files.checkForRegister(username, Files.usernames, Files.dataUsernames)==true) {
			  ++state;
			  warnings[2] = "Unavailable username,choose a different username";
			}
		  
		  System.out.println("Enter your password: ");
		  password=input.next();

		  //checks if the given password is the recommended size 
		  if(password.length() < 8 || password.length() > 64) {
			 ++state;
			 warnings[3]="Invalid password email,choose a different password that has 8 to 64 characters";
		   }
		  System.out.println("Enter your studentId: ");
		  studentId = input.next(); 
		  
		   //checks if the given studentID already exists in the database 
		   if(Files.checkForRegister(studentId, Files.studentID, Files.dataID)==true) {
			  ++state;
			  warnings[4] = "Unavailable studentID,choose a different studentID";
			}
		  
		   if(state > 0) {
			 warnings[4] = "Invalid credentials, please enter the necessary fields ";
		   }

		   //show the appropriate error message for every occasion
		   for(int i = 0;i < 5;i++) {
			 if(warnings[i]!=null&&state>0) {
				 System.out.println(warnings[i]);
			    }
		
		    }
		} while (state > 0);

		//if no same credentials where found, proceed with registration 
		if (state == 0) {
			Files.updateFiles(email, username, password, studentId);
			Files.closeFiles();
			System.out.println("You have been registered!");
		}
        
		//System.out.println("Do you want to login?");
		//int value=0;
		//System.out.println("If you want to login press 1:");
		//value=input.nextInt();
		//if(value==1) {
			//login();
		//}
		//input.close();
	}
	/**
	 * method login() --- Is used for the login function
	 * @throws IOException
	 * 
	 */
	public static void login() throws IOException {
		String warning = "Invalid username/password please try again or register";
		int answer = 0;
		int a = 0;
		boolean value1;
		boolean value2;
		Scanner put = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println("Enter your credentials");
			System.out.println();
			System.out.print("Username: ");
			username = input.nextLine(); 
			System.out.println(); 
			
			//checks if the given username exists in the database
			value1 = Files.checkForRegister(username, Files.usernames, Files.dataUsernames);
			if (value1 == true) {
				a = Files.usernames.indexOf(username); 
			}
			System.out.print("Password: ");
			password = input.nextLine(); 

			//checks if the given password exists in the database
			value2 = Files.checkForRegister(password, Files.passwords, Files.getDataPassword());

			//checks if the given password corresponds to the given username 
            if (value2 == true) {
				
				value2 = (password.equals(Files.passwords.get(a))); 
			}
			
			//if the given credentials were false, the user can enter his credentials again or register 
			if(value1 == false||value2==false) {
				System.out.println(warning);
				System.out.println("If you want to register press 1");
				System.out.println("If you want to enter your credentials again, enter 0");
				answer= put.nextInt();
			}

		} while((value1 == false || value2 == false) && answer == 0);

		if(answer == 1) {
			register();
		}

		//if the given credentials were correct, proceed with login 
		if(value1 == true && value2 == true) {
			System.out.println("You have been logged in!");
			if(Files.datanot.readLine()!=null) {
				System.out.println("Your notifications:");
				Files.readNotifications(Files.datanot,Files.notifications);
			}else{
				System.out.println("No notifications");
			}
		}

		//input.close(); 
	}
}
