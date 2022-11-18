package telius;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Login {

    public static void main(String[] args) {

		  System.out.println("Hello, Thank you for joining us");
		  System.out.println("You have chosen to login");
		  
        Scanner an = new Scanner(System.in);
        System.out.println("Please enter your email");
        String email = an.nextLine();
        System.out.println("and your password");
        String code = an.nextLine();
        //System.out.println( " code = " + code + " email = "+ email);
        an.close();

        //αναζητηση στη βδ με το email και μετα ελεγχος αντιστοιχισης με το κωδικ

        System.out.println("searching for" + email) ;

        int search = Collections.binarySearch(emails, email ) ; //πινακας , στοιχείο που ψαχνουμε 
        //( απλ δεν εχει δημιουργηθεί ακόμα ο πινακας)
        if (search == -1) {
          System.out.println("You have not registered");
          //καλει την register
           boolean flag ;
           flag = true ; 

        } else {
          boolean flag = true ; 

          
          while (flag == true) { 
          if (passwords.get(search) == code) {

            System.out.println(" You have logged in") ;
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
      
    }

  }
