package telius;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;



/**class Files --- Programm for saving data to Files
 * @author Michael Gianoulis
 * @author Dimitra Paravatou
 * 
 * 
*/
public class Files  {
	public static BufferedWriter enterEmails;
	public static BufferedReader dataEmails;
	public static BufferedWriter enterUserNames; 
	public static BufferedReader dataUsernames;
	public static BufferedWriter enterID;
	public static BufferedReader dataID;
	private static BufferedWriter enterPassword;
	private static BufferedReader dataPassword;
	public static PrintWriter notification;
	public static BufferedReader datanot;
	public static ArrayList<String> emails= new ArrayList<String>();
	public static ArrayList<String> usernames= new ArrayList<String>();
	public static ArrayList<String> passwords= new ArrayList<String>(); 
	public static ArrayList<String> studentID= new ArrayList<String>();
	public static ArrayList<String> notifications=new ArrayList<String>();
	
	/**
	 * method loadFiles()---The files are loaded to BufferedReader/BufferedWriter objects, in order to be used in the App.
	 * 
	 * @throws IOException
	 * 
	 */
	public static void loadFiles() throws IOException {
		
		enterEmails = new BufferedWriter(new FileWriter("..\\src\\main\\resources\\UserEmails.txt",true));
		dataEmails = new BufferedReader(new FileReader("..\\src\\main\\resources\\UserEmails.txt"));
		enterUserNames =  new BufferedWriter(new FileWriter("..\\src\\main\\resources\\Usernames.txt",true));
		dataUsernames = new BufferedReader(new FileReader("..\\src\\main\\resources\\Usernames.txt"));
		enterPassword = new BufferedWriter(new FileWriter("..\\src\\main\\resources\\passwords.txt",true));
		setDataPassword(new BufferedReader(new FileReader("..\\src\\main\\resources\\passwords.txt")));
		enterID = new BufferedWriter(new FileWriter("..\\src\\main\\resources\\UserIds.txt",true));
		dataID = new BufferedReader(new FileReader("..\\src\\main\\resources\\UserIds.txt"));
		notification=new PrintWriter(new FileWriter("..\\src\\main\\resources\\notifications.txt", true));
	    datanot=new BufferedReader(new FileReader("..\\src\\main\\resources\\notifications.txt"));
	}

	/**
	 * 
	 * @return BufferedReader
	 */
	public static BufferedReader getDataPassword() {
		return dataPassword;
	}

	/**
	 * @param dataPassword
	 */
	public static void setDataPassword(BufferedReader dataPassword) {
		Files.dataPassword = dataPassword;
	}

	/**
	 * method closeFiles() --- Closes the connection to the Files
	 * @throws IOException
	 * 
	 */
	public static void closeFiles() throws IOException {
	   try {
		 enterEmails.close();
		 enterUserNames.close();
		 enterPassword.close();
		 enterID.close();


			
		} catch (NullPointerException e) {
		   e.printStackTrace();
		}
		
	}	
	/**
	 * method updateFiles() --- the new data aquired(email, username, password, studentID), during the run of the App, are saved to the appropriate Files
	 * @param str1 
	 * @param str2 
	 * @param str3 
	 * @param str4 
	 * @throws IOException
	 * 
	 */
	public static void updateFiles(String str1, String str2, String str3, String str4) throws IOException {

		enterEmails.newLine();
		 
		enterEmails.append(str1);
		
		enterUserNames.newLine();
		
		enterUserNames.append(str2);
		
		enterPassword.newLine();
		
		enterPassword.write(str3);
		
		enterID.newLine();
		
		enterID.append(str4);
	
	}

	/**
	 * method checkForRegister()--- checks if the given object already exists in the ArrayList, if so return true
	 * @param str1 
	 * @param str2
	 * @param str3
	 * @return boolean
	 * @throws IOException
	 * 
	 */
	public static boolean checkForRegister(String str1, ArrayList<String> str2, BufferedReader str3) throws IOException { 
		
		filesToLists(str3, str2); 
		if(str2.contains(str1) == true) {
			return true;
		} else {
			return false;
		}
	}
		/**
		 * method filesToLists()--- loads the BufferedReader object to an ArrayList for easier manipulation of it's contents
		 * @param ob BufferedReader
		 * @param list ArrayList<String>
		 * @throws IOException
		 * 
		 */
		public static void filesToLists(BufferedReader ob, ArrayList<String> list) throws IOException {
		try {
        
			String str = ob.readLine(); 
		    while(str != null) {
			  list.add(str);
			  str = ob.readLine(); 
			}
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * method readNotifications()--- Is used for the notification function
	 * @param ob BufferedReader
	 * @param list ArrayList<String>
	 * @throws IOException
	 */
	public static void readNotifications(BufferedReader ob,ArrayList<String> list) throws IOException {
		filesToLists(ob,list);
		for(int i=0;i<list.size();i++) {
			if(list.get(i).contains("From:"+Register_Login.username)==true) {
				System.out.println(list.get(i+1)+" from the user you sent it to");
			}
		} 
	}
	
}
