import java.util.Collections;
import java.util.Scanner;

public class Login {
	public static String makeLogin() {
		System.out.println("Hello, Thank you for joining us!");
		System.out.println("You have chosen to login");
		boolean flag ;
		Scanner an = new Scanner(System.in);
	    System.out.println("Please enter your email");
        String email = an.nextLine();
        System.out.println("searching for " + email) ;
        int search = Collections.binarySearch(RegisterUser.emails, email);
        //πινακας , στοιχείο που ψαχνουμε
        //( απλα δεν εχει δημιουργηθεί ακόμα ο πινακας)
        while ( search == -1 ) {
            System.out.println("We are sorry to inform you that this email has not been used to register an account, you can press 1 to try writing your email again, or 2 in order to register");
            String answer = an.nextLine();
            if ( answer.equals(2) ) {
            	RegisterUser.register();
            } else if ( answer.equals(1) ) {
            	System.out.println("Let's hope it's right this time...");
            	String email2 = an.nextLine();
            	int search2 = Collections.binarySearch(RegisterUser.emails, email2);
            	search = search2;
            } else {
            	throw new OutOfBoundAnswerException("Nope, not this symbol. You can press 1 to try again or 2 to register!");
            }
        }
        System.out.println("Please enter your password to proceed");
        String code = an.nextLine();
        search = Collections.binarySearch(RegisterUser.passwords, code);
        while ( search == -1 ) {
            System.out.println("It seems like this password has not been assigned to this account, you can press 1 to try writing your password again, or 2 in order to register with a new email account.");
            String answer = an.nextLine();
            if ( answer.equals(2) ) {
            	RegisterUser.register();
            } else if ( answer.equals(1) ){
            	System.out.println("Please enter your password");
            	code = an.nextLine();
            	int search2 = Collections.binarySearch(RegisterUser.passwords, code);
            	search = search2;
            } else {
            	throw new OutOfBoundAnswerException("Nope, not this symbol. You can press 1 to try again or 2 to register!");
            }
        }
        System.out.println( " code = " + code + " email = "+ email);
        System.out.println(" You have logged in") ;
        System.out.println(" Enter 3 if you want to logout. Enter anything else if you want to proceed into UniQ") ;
        String answer = an.nextLine();
        an.close();
        if (answer.equals(3)) {	
            Logout();
        }
    }
    public static String Logout() {
        System.exit(1);
        String mess = "You have sucessfully logged out";
        return mess;
    }
}

