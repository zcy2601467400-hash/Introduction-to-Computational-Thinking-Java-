//==========================================================
// 
// File: MonteCarloPi.java     
// 
// Author: 曾诚誉           Email: zcy19859231839@126.com 
// 
// Class: MonteCarloPi
// 
// Time spent:  120 minutes
// 
// -------------------- 
// This program calculates an estimation of pi, by generating 
// random numbers, and determining which ones fall inside a 
// circle of radius 0.5, which is contained inside a 1 x 1 square.
// The program asks the user for the number of points to drop, and
// then estimates pi by:  4 * (pointsInCircle / pointsDropped) 
//
//==========================================================

import java.util.Scanner;

public class MonteCarloPi {

    // Enforce a minimal of # of points to drop
    static final int    MIN_N  = 5;

    // A common practice is to define messages as class constants
    static final String PROMPT 
         = "Please input the number of points to drop: ";

    // Specific configuration
    static final double RADIUS = 0.5;

    static final double CIRCLE_CENTER_X = 0.5;
    static final double CIRCLE_CENTER_Y = 0.5;

    public static void main(String[] args) 
    {
        System.out.printf("%s",PROMPT);
        int N = getN();
        int pointsInCircle = 0 ;
        for(int i = 1 ; i <= N ; i++)
        {
            double x = Math.random();
            double y = Math.random();
            if(isInCircle(x, y))
            {
                pointsInCircle = pointsInCircle + 1;
            }
            if(i < 50)
            {
                if(i%5==0)
                {
                    System.out.printf("%d\t",i);
                    System.out.printf("%.15f\n", estimatePi( pointsInCircle, i));                     

                }
            }
            if(i >= 50 && i < 1000)
            {
                if(i%50 ==0)
                {
                    System.out.printf("%d\t",i);
                    System.out.printf("%.15f\n", estimatePi( pointsInCircle, i));
                }
            }
            if(i >= 1000)
            {
                if(i%1000 == 0 )
                {
                    System.out.printf("%d\t",i);
                    System.out.printf("%.15f\n", estimatePi( pointsInCircle, i));
                }
            }



        }
        
    } // end of method main
      

    // Get N from user
    public static int getN() 
    {
        Scanner input = new Scanner(System.in);
        int time = input.nextInt(); 
        if(time >= MIN_N)
        {
            return time ;
        }
        else
        {
            return 0 ; 
        }
        
    }

    // Determine if new point (x, y) is in circle
    public static boolean isInCircle(double x, 
                                     double y) 
    {
        if(Math.sqrt((x-CIRCLE_CENTER_X)*(x-CIRCLE_CENTER_X)+(y-CIRCLE_CENTER_Y)*(y-CIRCLE_CENTER_Y)) <= RADIUS)
        {
            return true ;  
        }
        else
        {
            return false ; 

        }
        // replace below below with your code
        

    }

    // Compute estimate of Pi given pointsInCircle and pointsDropped
    public static double estimatePi(int pointsInCircle, 
                                    int pointsDropped) 
    {
        double pi = 4 * ((double)pointsInCircle / pointsDropped) ;
        return pi ;
        
    }

} 
