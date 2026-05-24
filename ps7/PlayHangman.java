import java.util.Scanner;

public class PlayHangman {
   static final int MAXCHANCES = 8;

   public static void main(String[] args) {
      String response = "y";
      
      Scanner scan = new Scanner (System.in);

      do {
         // create the game for one round
         Hangman.initialize( MAXCHANCES );
         
         Hangman.play();
      
         System.out.println();
         
         System.out.print ("Play another round of Hangman (y/n)? ");
         response = scan.nextLine();
         
         System.out.println ();

      } while (response.equalsIgnoreCase("y")); // allows y or Y
   
   } // end of method main

} // end of class
