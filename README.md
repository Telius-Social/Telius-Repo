# UniQ
## University Oriented Communication App
### Ομαδική Εργασία Πρoγραμματισμός 2 (Ομάδα Telius)

## Οδηγίες μεταγλώττισης Προγράμματος
Ο χρήστης βρίσκεται στο branch default και πατώντας πάνω στο πράσινο κουμπί Code επιλέγει να κατεβάσει το .zip αρχείο που περιέχει ολόκληρο το branch. Έπειτα το κάνει εξαγωγή όπου επιθυμεί και μέσω της γραμμής εντολών μπαίνει στο επίπεδο φακέλου uniq και μετά ο χρήστης μπορεί είτε να εκτελέσει την εντολή mvn clean package στο επίπεδο φακέλου uniq από την γραμμή εντολών για τη δημιουργία του jar είτε (το οποίο είναι το προτεινόμενο) να πάει στο επίπεδο φακέλων uniq\target και να εκτελέσει την παρακάτω εντολή.

## Οδηγίες Εκτέλεσης Προγράμματος
Η εκτέλεση του προγράμματος γίνεται στη γραμμή εντολών με την εντολή: **java -cp uniq-1.0-SNAPSHOT.jar telius.App** στο επίπεδο φακέλων uniq\target.

## Οδηγίες Χρήσης Προγράμματος
Ο χρήστης εκτελεί την παραπάνω εντολή και εμφανίζεται ένα πλαίσιο καλωσορίσματος με το λογότυπο της εφαρμογής. Ο χρήστης κάνει κλικ πάνω στο 
παράθυρο και εμφανίζεται ένα νέο παράθυρο που τον παροτρύνει να ακολουθήσει τις οδηγίες που εμφανίζονται στο πλαίσιο της γραμμής εντολών.
Δίνονται οι επιλογές **Register** (1), **Login** (2) και **Exit** (3), επιλέγοντας 1 ή 2 ή 3 αντίστοιχα.

Αν ο χρήστης επιλέξει να εγγραφεί στην εφαρμογή, θα πρέπει να εισάγει το **Email**, το επιθυμητό **Username**, **Password** και το **StudentID** 
του. Σε περίπτωση που τα στοιχεία του συμπίμπτουν με άλλων χρηστών ή ο κωδικός του είναι μικρός σε έκταση, εμφανίζονται τα κατάλληλα μηνύματα λαθών. 
Αν ο χρήστης επιλέξει να συνδεθεί, εισάγει τα στοιχεία του **(Username, Password)**. Σε περίπτωση εισαγωγής στοιχείων που δεν υπάρχουν στη βάση, η 
εφαρμογή δίνει στο χρήστη την επιλογή να επαναλάβει την εισαγωγή των στοιχείων του ή να εγγραφεί στην εφαρμογή.Εμφανίζονται οι ειδοποιήσεις του.

Μετά από επιτυχημένη εγγραφή/σύνδεση στην εφαρμογή ο χρήστης έχει την επιλογή είτε να δει τα μηνυματά του **See messages** (4), είτε να στείλει
ένα νέο μήνυμα σε κάποιο άλλο χρήστη της εφαρμογής **Send a message** (5), είτε να αποσυνδεθεί απο την εφαρμογή **Logout**(6), επιλέγοντας 4 ή 5 ή 6 αντίστοιχα. 
Αν ο χρήστης επιλέξει να δει τα μηνυματά του δίνεται η επιλογή να κάνει **Like**, επιλέγοντας 1 ή **Dislike** επιλέγοντας 2 και εμφανίζεται η αντίστοιχη εικόνα. Έπειτα, η εφαρμογή επιστρέφει το χρήστη στο μενού μηνύματος.

## Παρουσίαση Δομής του αποθετηρίου
Ο φάκελος uniq που περιέχει τους φακέλους:
.vscode
src
target
και το αρχείο pom.xml

Στο **φάκελο target** υπάρχει μεταξύ άλλων **το αρχείο.jar** που εκτελείται με τη παραπάνω εντολή 

Στο φάκελο src υπάρχουν οι φάκελοι main και test

Στο φάκελο test\java\telius βρίσκονται οι κλάσεις TestJunit.java και TestJRunner.java (Eμφανίστηκαν αρκετά προβλήματα κατά τη χρήση του JUnit)
Στο φάκελο main υπάρχουν οι φάκελοι java,resources,trials

Στο φάκελο uniq\src\main\java\telius υπάρχουν τα αρχεία:
App.java
Register_Login.java
Files.java
Message.java
Like.java
 και τα αντίστοιχα .class που περιέχουν το κώδικα της εφαρμογής.

Στο φάκελο uniq\src\main\resources υπάρχουν τα αρχεία:
userEmails.txt
Usernames.txt
passwords.txt
userIds.txt
chat.txt
που αποτελούν τη βάση δεδομένων της εφαρμογής.
και τα αρχεία 
Logo.png
like.jpg
dilike.jpg
που είναι οι εικόνες που χρησιμοποιούνται στην εφαρμογή.


## Διάγραμμα UML

![UML](https://user-images.githubusercontent.com/116435775/212921558-c2399592-68c6-4b30-b3ff-729edf739e4b.png)
## Επισκόπηση των δομών δεδομένων και των αλγορίθμων που χρησιμοποιεί η εφαρμογή
 ### Δομές Δεδομένων
 ArrayLists<>
 ### Αλγόριθμοι
 search(), contains()



