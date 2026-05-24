
import java.util.Scanner;

// This class demonstrates the difference between next() and nextLine()
// in Java's Scanner class.
// NOTE: next() behaves similarly to nextInt() and nextDouble().
public class ScannerFun {

  public static void main(String [] args) {

    Scanner scan = new Scanner(System.in);

    // next() - skips any preceding whitespace or newlines,
    //          and starts copying at the first character it sees.
    //          It continues copying until it sees a whitespace or newline.
    System.out.println("Enter a word: ");
    String s = scan.next();
    System.out.println("Read '" + s + "'");

    // Notice how it skips preceding newlines.
    System.out.println("\nI'll use next() again, but hit [enter] a bunch " +
                       "of times before typing your actual string.");
    s = scan.next();
    System.out.println("Read '" + s + "'");

    // Lastly, notice how it leaves the whitespace or newline in the input.
    System.out.println("Type 'one    two' (four spaces) and press enter.");
    s = scan.next();
    String line = scan.nextLine();
    System.out.println("Read '" + s + "' with next(); Read '" 
                        + line + "' used nextLine(), so " 
                        + "it doesn't skip whitespace.");

    // nextLine() - reads whatever input is there and stops at a newline.
    //              Unlike next(), nextInt() and nextDouble(),
    //              nextLine() consumes, or discards the newline that it sees.
    System.out.println("Press [enter]");
    line = scan.nextLine();
    System.out.println("Used nextLine(), line='" + line + "'" +
                       "Note that the newline was discarded.");

    // Another call to nextLine() shows that the newline is no longer there.
    // That is, we need the user to enter another newline before nextLine()
    // completes.
    System.out.println("Press [enter] again");
    line = scan.nextLine();

    System.out.println("Caveat: Intermixing calls to next() and nextLine().");
    System.out.println("Enter a single word and press [enter]: ");
    s = scan.next();
    line = scan.nextLine();
    System.out.println("s='" + s + "' but " +
                       "the newline was left in the input,\nso nextLine() " +
                       "read it and immediately returned an empty String.");
  }

}
