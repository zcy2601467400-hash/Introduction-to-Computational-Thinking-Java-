//*******************************************************************
//
//   File: FileName.java          Assignment No.: 3
//
//   Author: 曾诚誉      Email: zcy19859231839@126.com
//
//   Class: DrawRocket
// 
//   Time spent on this problem: 45min 
//   --------------------
//      Please give a description about your design. 
//
//*******************************************************************
public class DrawRocket
{
    public static void main(String[] args)
    {
        drawRocket(3);
        System.out.println();
        drawRocket(5);
    }

    

    public static void drawRocket(int size)
    {
        Top_and_Bottom(size);
        Divider(size);
        MiddleSection1(size);
        MiddleSection2(size);
        Divider(size);
        MiddleSection2(size);
        MiddleSection1(size);
        Divider(size);
        Top_and_Bottom(size);
    }

    public static void printSpaces(int nSpaces) 
    {
        for (int i = 1; i <= nSpaces; i++)
            System.out.print(" ");
    }

    public static void Top_and_Bottom(int size)
    {
        for(int line = 1 ; line <= (2 * size) - 1  ; line++)
        {
            printSpaces((2 * size) - line);
            for(int slash = 1 ; slash <= line ;slash++)
            {
                System.out.print("/");
            }
            System.out.print("**");
            for(int backslash = 1 ; backslash <= line ; backslash++)
            {
                System.out.print("\\");
            }
            System.out.println();
        }
    }

    public static void Divider(int size)
    {
        System.out.print("+");
        for(int length = 1 ; length <= 2 * size ; length++)
        {
            System.out.print("=*");
        }
        System.out.print("+");
        System.out.println();
    }

    public static void MiddleSection1(int size)
    {
        
        for(int line = 1 ; line <= size  ; line++)
        {
            System.out.print("|");
            for(int left_dot = 1 ; left_dot <= size - line; left_dot++)
            {
                System.out.print(".");
            }
            for(int slash_and_backslash = 1 ; slash_and_backslash <= line ; slash_and_backslash++)
            {
                System.out.print("/\\");
            }
            for(int middle_dot = 1 ; middle_dot <= 2 * (size - line) ; middle_dot++ )
            {
                System.out.print(".");
            }
            for(int slash_and_backslash = 1 ; slash_and_backslash <= line ; slash_and_backslash++)
            {
                System.out.print("/\\");
            }
            for(int right_dot = 1 ; right_dot <= size - line; right_dot++)
            {
                System.out.print(".");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static void MiddleSection2(int size)
    {
        for(int line = size ; line >= 1  ; line--)
        {
            System.out.print("|");
            for(int left_dot = size - line ; left_dot >= 1; left_dot--)
            {
                System.out.print(".");
            }
            for(int slash_and_backslash = line ; slash_and_backslash >= 1 ; slash_and_backslash--)
            {
                System.out.print("\\/");
            }
            for(int middle_dot = 2 * (size - line) ; middle_dot >= 1 ; middle_dot-- )
            {
                System.out.print(".");
            }
            for(int slash_and_backslash = line ; slash_and_backslash >= 1 ; slash_and_backslash--)
            {
                System.out.print("\\/");
            }
            for(int right_dot = size - line ; right_dot >= 1; right_dot--)
            {
                System.out.print(".");
            }
            System.out.print("|");
            System.out.println();
        }

    }
}

