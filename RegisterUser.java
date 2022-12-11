package telius;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
//import java.lang.*;
public class RegisterUser {
  
private static String email;
private static String username;
private static String password;
private static String studentId;
protected static ArrayList<String> emails =new ArrayList<String>();
protected static ArrayList<String> usernames =new ArrayList<String>(); 
protected static ArrayList<String> passwords =new ArrayList<String>(); //maybe not public
protected static ArrayList<String> studentIds =new ArrayList<String>();
//protected static ArrayList<User> users=new ArrayList<User>(); 

public static ArrayList<String> FileIntoList(String file) {
	try
    { ArrayList<String> helper =new ArrayList<String>();
      helper = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
    }
 
    catch (IOException e)
    {
 
      // do something
      e.printStackTrace();
    }

	return helper;
}
//τα δικα μας παιρνουν δεδομενα απο το αρχείο 
public static void Change() {

	emails = readFileInList("C:\\Users\\Δήμητρα\\Desktop\\UniQ\\project building\\uniq\\src\\main\\java\\telius\\Emails.txt");
    usernames = readFileInList("C:\\Users\\Δήμητρα\\Desktop\\UniQ\\project building\\uniq\\src\\main\\java\\telius\\Usernames.txt");
	passwords = readFileInList("C:\\Users\\Δήμητρα\\Desktop\\UniQ\\project building\\uniq\\src\\main\\java\\telius\\Passwords.txt");
    studentIds = readFileInList("C:\\Users\\Δήμητρα\\Desktop\\UniQ\\project building\\uniq\\src\\main\\java\\telius\\StudentIds.txt");
	//Iterator<String> itr = emails.iterator();
    //while (itr.hasNext())
      //System.out.println(itr.next());
}


public static Scanner input=new Scanner(System.in);


	public RegisterUser(String email,String username,String password,String studentId) {
		//this.email=email;
        RegisterUser.email = email; 
		//this.username=username;
		//this.password=password;
		//this.studentId=studentId;
		RegisterUser.username=username;
		RegisterUser.password=password;
		RegisterUser.studentId=studentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		//this.email = email;
		RegisterUser.email = email; 
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		//this.username = username;
		RegisterUser.username = username; 
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		//this.password = password;
		RegisterUser.password = password;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		//this.studentId = studentId;
		RegisterUser.studentId = studentId; 

	}

	public String toString(){
		return String.format("Email:%s%nUsername:%s%nPassword:%s%nStudentId:%s%n", email,username,password,studentId);
	}

	public boolean contains(String email2) {
		return false;
	}
	public static String register() {
		boolean makeAnAccount=false;
		String email = " ";
		String username = " ";
		String password = " ";
		String studentId = " ";
		while(makeAnAccount==false) {
			System.out.println("Enter your email:");
			email=input.next();
			//System.out.println(email);
			System.out.println("Enter your username: ");
			username=input.next();
			System.out.println("Enter your password: ");
			password=input.next();
			System.out.println("Enter your University Department: ");
			studentId=input.next();
			makeAnAccount=checkAvailability(email,username,password,studentId);
			if(makeAnAccount==false) {
				System.out.println("Enter your credentials again");
			}
		}
		System.out.println(email);
		if(makeAnAccount==true) {
			emails.add(email);
			usernames.add(username);
			passwords.add(password);
			studentIds.add(studentId);
			//users.add(new RegisterUser(email,username,password,studentId));
			System.out.println("You have been registered");

			Collections.sort(emails);
            Collections.sort(usernames);
            Collections.sort(studentIds);

			//System.out.println(emails);

		}   
            return username;
		}

	private static boolean checkAvailability(String email2, String username2,String password2 ,String studentId2) {
		boolean result=true;
		if(emails.contains(email2)||usernames.contains(username2)||(password2.length()<8 || password2.length()>64)||studentIds.contains(studentId2)) {
			result=false;
		}
		return result;
	}

	

}

	