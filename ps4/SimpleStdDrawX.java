//==========================================================
// 
// SimpleStdDrawX.java              IOCT F25 
// 
// Author: Y. Richard Yang
//         Qiao Xiang
//
// Class: SimpleStdDrawX 
// 
// ---------------------------------------------------------
//   This is a demo program for basic functions of StdDraw.
//   Note: This program needs StdDraw, and hence
//   you need to also download StdDraw.java
//
//   Here is a procedure to test SimpleStdDraw.java StdDraw.java:
//     Suppose you are using Eclipse. Here is a procedure. 
//     - First, download StdDraw.java and SimpleStdDrawX.java 
//       from the Schedule page. Assume that you download 
//       them at Desktop. 
//     - Next, create a Java Project. Assume that you name 
//       it TestStdDraw. Make sure that Project Layout is to 
//       use root for both source and class files. Make sure 
//       that you use default package. 
//     - Next, drag the two downloaded files to the "default 
//       package" under TestStdDraw project. When you drag, 
//       Eclipse will ask if link or copy. Please choose copy. 
//     - Now, you should be able to run SimpleStdDraw.
//==========================================================

import java.awt.Color;

public class SimpleStdDrawX {

    public static void main(String[] args) {
        // A default canvas is 512x512, you can change it to other sizes
        
	final int SIZE = 800;
        StdDraw.setCanvasSize(SIZE, SIZE);
	
        /*
         * Approach 1: Using default scale [0, 1]x[0, 1]
         */
        //StdDraw.line(0, 0, 1, 1);
        //StdDraw.line(1, 0, 0, 1);
        
        /*
         *  Approach 2: Scale to pixel sizes
         */
       StdDraw.setXscale(0, SIZE);
       StdDraw.setYscale(0, SIZE);
       StdDraw.setPenColor(Color.RED);
       StdDraw.line(0, 0, SIZE, SIZE);
       StdDraw.setPenColor(Color.BLUE);
       StdDraw.line(SIZE, 0, 0, SIZE);

    } // end of main

} // class
