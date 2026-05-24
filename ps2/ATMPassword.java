//*******************************************************************
//
//   File: ATMPassword.java          Assignment No.: 2
//
//   Author:曾诚誉       Email: zcy19859231839@126.com
//
//   Class: ATMPassword
// 
//   Time spent on this problem: 10min
//   --------------------
//   
//   The original program prints out: 1817347
//
//*******************************************************************
public class ATMPassword
{
  public static void main (String[] args)
  {
    System.out.println("Dear thieves, please don't steal my ATM card.");
    System.out.println("But if you do, here's my password:");
    firstpart();                                                            //原始输出1
    secondpart();                                                           //原始输出817374
    System.out.println("");
  }                                                                         //原始输出1817374

  public static void firstpart() {
    System.out.print("1");   
    lastbit();                                                              //新添加的代码行，它使输出变为1374813747374                                                                                
  }

  public static void secondpart() {
    System.out.print("8");                                                //原始输出8
    firstpart();                                                            //原始输出1                                   
    lucky();                                                                //原始输出7
    lastbit();                                                              //原始输出374
  }

  public static void lucky() {
    System.out.print("7");                                                //原始输出7
  }

  public static void lastbit() {
    System.out.print("3");                                                //原始输出3
    lucky();                                                                //原始输出7
    System.out.print("4");                                                //原始输出4
  }
}