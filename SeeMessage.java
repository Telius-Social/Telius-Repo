package telius;
import java.util.ArrayList;
import java.util.Scanner; 

public class SeeMessage {

    public static void main(String[] args) {
        
        //υποθετω οτι ειναι συνδεδεμενος με το username του ο χρηστης οποτε καλειται απο την user ή οπως τη λενε μια μέθοδος
        // που γυρανει το username 
        String username = "Hi" ; //= η μεθοδος που αναφερεται από πανω  

        System.out.println("Would you like to see your messages? If so, enter yes  ");

        Scanner input1=new Scanner(System.in);
		String answear =input1.next();

        if (answear == "Yes" || answear == "yes") {

            //θα καλει τη μεθοδο που θα φορτωνει τα μηνυματα απο το αρχειο στο arraylist με παραμετρο το username
            //τωρα θα το δημιουργησω 
            
             ArrayList<String> messages = new ArrayList<String>();
               for (int i = 0; i < messages.size(); i++) {
               System.out.println(messages.get(i));
                 } //και εμφανιζει τα μηνυματα που μπορουν να εχουν τη μορφη "username αποστολεα: κειμενο μηνυματος "

                 System.out.println("Would you like to like a message? If so, enter the number of the message you want to like");
                 Scanner input2=new Scanner(System.in);
		        int liked =input2.nextInt();

                //καλει την like με ορισμα τον αριθμο μηνυματος και ισως τη λιστα που δημιουργηθηκε πριν 

                System.out.println("Would you like to answer to a message? If so, enter the number of the message you want to reply to");

                Scanner input3=new Scanner(System.in);
		        int reply =input3.nextInt();
                //και καλει την μεθοδο sentmessage -περιπου- με παραμετρο τον αριθμο 

                System.out.printf(username, liked , reply );


                input2.close();
                input3.close();
        }

      input1.close();   
    }
    
}
