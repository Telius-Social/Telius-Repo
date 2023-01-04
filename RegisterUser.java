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
	public static void register() throws IOException {
		String email;
		String username;
		String password;
		String studentId;
		int state=0;
		String[] warnings= new String[5];
		do {
		state=0;	
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your email:");
		email=input.next();
		if(Files.checkForRegister(email, Files.emails, Files.dataEmails)==true) {
		++state;
		warnings[1]="Unavailable email,choose a different email";
		}
		System.out.println("Enter your username: ");
		username=input.next();
		if(Files.checkForRegister(username, Files.usernames, Files.dataUsernames)==true) {
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
		if(Files.checkForRegister(email, Files.studentID, Files.dataID)==true) {
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
	}
}

	
