import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Files  {
	public static BufferedWriter enterEmails;
	public static BufferedReader dataEmails;
	public static BufferedWriter enterUserNames; 
	public static BufferedReader dataUsernames;
	public static BufferedWriter enterID;
	public static BufferedReader dataID;
	private static BufferedWriter enterPassword;
	private static BufferedReader dataPassword;
	public static ArrayList<String> emails= new ArrayList<String>();
	public static ArrayList<String> usernames= new ArrayList<String>();
	public static ArrayList<String> passwords= new ArrayList<String>();
	public static ArrayList<String> studentID= new ArrayList<String>();
	public static void LoadFiles() throws IOException {
		enterEmails = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\userEmails.txt",true));
		dataEmails = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\UserEmails.txt"));
		enterUserNames =  new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\Usernames.txt",true));
		dataUsernames = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\Usernames.txt"));
		enterPassword = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\passwords.txt",true));
		dataPassword = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\passwords.txt"));
		enterID = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\UserIds.txt",true));
		dataID = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\UserIds.txt"));
	}
	public static void closeFiles() throws IOException {
		enterEmails.close();
		enterUserNames.close();
		enterPassword.close();
		enterID.close();
	}	
	public static void updateFiles(String str1,String str2,String str3,String str4) throws IOException {
		enterEmails.newLine();
		enterEmails.append(str1);
		enterUserNames.newLine();
		enterUserNames.append(str2);
		enterPassword.newLine();
		enterPassword.write(str3);
		enterID.newLine();
		enterID.append(str4);	
	}
	public static boolean checkForRegister(String str1,String str2,String str3) throws IOException {
		filesToLists(ob,list);
		if(list.contains(str)==true) {
			return true;
		} else {
			return false;
		}
	}
		public static void filesToLists(BufferedReader ob,ArrayList<String> list) throws IOException {
		
		while(ob.readLine()!=null) {
			list.add(ob.readLine());
		}
	}
	
}
