package telius;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Login {

    public static String makeLogin ( ) {

		  System.out.println("Hello, Thank you for joining us");
		  System.out.println("You have chosen to login");
		  boolean flag ;

        Scanner an = new Scanner(System.in);
        System.out.println("Please enter your email");
        String email = an.nextLine();
        System.out.println("and your password");
        String code = an.nextLine();
        //System.out.println( " code = " + code + " email = "+ email);
        an.close();

        //αναζητηση στη βδ με το email και μετα ελεγχος αντιστοιχισης με το κωδικ

        System.out.println("searching for " + email) ;

        int search = Collections.binarySearch(RegisterUser.emails, email ) ; //πινακας , στοιχείο που ψαχνουμε 
        //( απλ δεν εχει δημιουργηθεί ακόμα ο πινακας)
        if (search == -1) {
          System.out.println("You have not registered");
           RegisterUser.register();
          
           flag = false ; 

        } else {
          flag = true ; 

          
          while (flag == true) { 
          if (RegisterUser.passwords.get(search) == code) {

            System.out.println(" You have logged in") ;
            System.out.println(" Enter 3 if you want to logout") ;
            //Logout();
            flag = false ;

          } else {
            System.out.println("Please enter your code again");

            Scanner sc = new Scanner(System.in); 
            code = sc.nextLine();
            sc.close();

          }

          //ισως πρεπει να βαλουμε exception
         

        }

      }
      return email;  
    }
    public static String Logout() {

      System.exit(1);
      String mess = "You have sucessfully logged out"; 
      return mess; 
    }

  }
