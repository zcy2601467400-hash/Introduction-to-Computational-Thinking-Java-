    //*******************************************************************
    //
    //   File: Cashier.java          Assignment No.: 5
    //
    //   Author: 曾诚誉      Email: zcy19859231839@126.com
    //
    //   Class: Cashier
    // 
    //   Time spent on this problem: 1h
    //   --------------------
    //      null :) 
    //
    //*******************************************************************
import java.util.Scanner;

public class Cashier 
{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Cashier!\n");

        System.out.print("Enter the unit price: ");
        double unitPrice = input.nextDouble();

        System.out.print("Enter the quantity: ");
        int quantity = input.nextInt();

        System.out.print("Enter the sales tax rate: ");
        double taxRate = input.nextDouble();

        
        double subtotal = unitPrice * quantity;
        double tax = subtotal * (taxRate / 100.0);
        double total = Math.round((subtotal + tax)*100.0)/100.0; // 保留两位小数

        System.out.printf("The total owed amount is $%.2f ($%.2f plus %.1f%% tax)\n",
                total, subtotal, taxRate);

        System.out.print("Enter the paid amount: ");
        double paid = input.nextDouble();

        
        if (paid < total) 
        {
            System.out.printf("You still owe $%.2f.\n", total - paid);
        } 

        if (Math.abs(paid - total) < 0.005)
        {
            System.out.println("Thank you for paying the exact amount!");
        }

        if(paid > total) 
        {
            getChanges(total, paid);
        }
    }

    
    static void getChanges(double owed, double paid) 
    {

    
        double change = paid - owed;
    
        int cents = (int) Math.round(change * 100);

    
        int f50 = cents / 5000; cents %= 5000;
    
        int f20 = cents / 2000; cents %= 2000;
    
        int f10 = cents / 1000; cents %= 1000;
    
        int f5  = cents / 500;  cents %= 500;
    
        int f1  = cents / 100;  cents %= 100;


    
        int q = cents / 25;  cents %= 25;
    
        int d = cents / 10;  cents %= 10;
    
        int n = cents / 5;   cents %= 5;
    
        int p = cents;

    
        System.out.printf("Your change of $%.2f is given as:\n", change);
    
        System.out.println(f50 + " 50 dollars");
    
        System.out.println(f20 + " 20 dollars");
    
        System.out.println(f10 + " 10 dollars");
    
        System.out.println(f5  + " 5 dollars");
    
        System.out.println(f1  + " 1 dollars");
    
        System.out.println(q   + " quarters");
    
        System.out.println(d   + " dimes");
    
        System.out.println(n   + " nickels");
    
        System.out.println(p   + " pennies");
    
    }
}
