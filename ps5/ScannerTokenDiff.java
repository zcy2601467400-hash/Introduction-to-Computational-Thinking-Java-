
import java.util.Scanner;

// Note that the 'next()' method skips over any preceding
//	whitespace OR newlines to get the first character.
//	Then, it only stops once it sees a whitespace or newline character,
//	and it consumes or discards that final whitespace or newline.

// Compare that to 'nextLine()' which skips any preceding
//	whitespace ONLY.
//	Then, it reads until it hits a newline, and
//	consumes or discards the final newline.

// Compare that to 'nextInt()" which skips any preceding
//	whitespace OR newlines to get the first digit.
//	Then, it stops reading once it sees a non-digit,
//	and leaves that non-digit (e.g., newline) in the input.
public class ScannerTokenDiff {

  public static void main(String [] args) {

    Scanner console = new Scanner(System.in);

     /*System.out.println("==Test 1==");
     System.out.println("Enter a number then [Enter]; I will call nextInt(), and then nextLine():");
     int i1 = console.nextInt();
     String s1 = console.nextLine();
     System.out.println( "i1: " + i1);
     System.out.println( "s1: |" + s1 + "|");*/

    System.out.println("==Test 2==");
    System.out.println("Enter a number then [Enter]; I will call nextInt(), and then next():");
    int i2 = console.nextInt();
    String s2 = console.next();
    System.out.println( "i2: " + i2);
    System.out.println( "s2: |" + s2 + "|");
  } // main

} // class
