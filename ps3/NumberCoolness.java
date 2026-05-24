//*******************************************************************
//
//   File: NumberCoolness.java          Assignment No.: 3
//
//   Author:曾诚誉       Email:zcy19859231839@126.com
//
//   Class: NumberCoolness
// 
//   Time spent on this problem:  20min
//   --------------------
//      Please give a description about your design. 
//
//*******************************************************************

public class NumberCoolness 
{

    // main
    public static void main(String[] args) 
    {
        printNumberCoolness(3);
        printNumberCoolness(9);
    }

    public static void printSpaces(int nSpaces) 
    {
        for (int i = 1; i <= nSpaces; i++)
            System.out.print(" ");
    }

    
    // Your method here
    /*public static void printNumberCoolness(int n) 
    {
        for (int i = 1; i <= n; i++) 
        {
            printSpaces(n - i);
            
            int LeftNumber = 0;
            
            for (int j = 1 ; j <= i ; j++) 
            {
                LeftNumber = LeftNumber * 10 + j;
            }
            
            int RightNumber = LeftNumber * 8 + i;
            
            System.out.println(LeftNumber + " x 8 + " + i + " = " + RightNumber);
        }
        System.out.println(); 
    }*/
    public static void printNumberCoolness(int n) 
    {
        int i = 1, num = 0;                        
        while (i <= n) 
        {
            num = num * 10 + i;
            int result = num * 8 + i , spacesCount = n - i;
            String spaces = spacesCount > 0 ? String.format("%" + spacesCount + "s", "") : ""; 
            System.out.println(spaces + num + " x 8 + " + i + " = " + result);                 
            i++;                                                                              
        }
    }
}