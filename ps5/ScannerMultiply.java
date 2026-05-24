//==========================================================
// 
// ScannerMultiply.java
// 
// Author: CPSC112
// 
// Class: ScannerMultiply
// 
// ---------------------------------------------------------
// This program reads in two numbers and print their product.
//
//==========================================================
import java.util.Scanner;   // so that I can use Scanner

public class ScannerMultiply { 

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Please type two numbers: ");

        int num1 = console.nextInt();
        // System.out.println("num1: " + num1);

        int num2 = console.nextInt();
        // System.out.println("num2: " + num2);

        int product = num1 * num2;
        System.out.println("The product is " + product);

  } // end of method main

} // end of class
