This assignment gives you a chance to use the environments and write a couple Java programs. There are many issues when you start to write your first program. Hence, we highly recommend that you do NOT wait until the last day.

Due: 11:55 p.m., Oct. 16, Thursday.

Grading rubric

FAQ

Part 1. "Hello World" (using the Java Compiler)
In this course, each Java file should always consist of the following three components:

Assignment specification (comments)
correct filename and assignment number
your name and email address
a list of classes defined by this file
time you spent on this file
a brief specification about this program
Actual class definitions
Create the HelloWorld.java file:

//*******************************************************************
//
//   File: HelloWorld.java          Assignment No.: 1
//
//   Author: Qiao Xiang           Email: qiaoxiang@xmu.edu.cn
//
//   Class: HelloWorld
// 
//   Time spent on this problem: 0.5 hour
//   --------------------
//      This program prints a string called "Hello World!".
//
//*******************************************************************
  
  
public class HelloWorld 
{
   public static void main(String[] args) 
   {
      System.out.println("Hello World!");
   } // end of method main   
} // end of class HelloWorld
Compile HelloWorld.java and run the program.

Part 2. Error Messages
Introduce the following errors, one at a time, to the HelloWorld program above. Record any error messages that the compiler produces, if any. You may want to use copy and paste to record the error messages. Restore the program before you introduce a new one. Try to predict what will happen before you make each change.

change class to Class
change class name from HelloWorld to helloWorld
change main to Main
change "Hello World!" to "Hell world!"
remove the first quotation mark
remove the last quotation mark
change println to printLn
remove the semicolon at the end of the System.out.println line
remove the last brace in the program
remove the second to the last brace in the program
Please save (cut and paste or type) all of the error messages in a file named Errors.txt

Part 3. A More Complicated Java Program
Write a Java application that prints, on separate lines, your name, the computer you are programming in Java (e.g., Pantheon, my personal Mac X, my personal Windows), your favorite book, and your favorite restaurant. Label each piece of information in the output, for example,

Computer: my personal Win7

Please name the source file as Self.java. The file should include comments similar to Part 1.
