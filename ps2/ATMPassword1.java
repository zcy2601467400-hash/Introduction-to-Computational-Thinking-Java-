public class ATMPassword1
{
    public static void main (String[] args)
    {
        System.out.println("Dear thieves, please don’t steal my ATM card.");
        System.out.println("But if you do, here’s my password:");
        firstpart();
        secondpart();
        System.out.println("");
    }

    public static void firstpart() {
        System.out.print("1");
        secondpart(); // added line to change password to 137481374374
    }

    public static void secondpart() {
        System.out.print("8");
        firstpart();
        lucky();
        lastbit();
    }

    public static void lucky() {
        System.out.print("7");
    }

    public static void lastbit() {
        System.out.print("3");
        lucky();
        System.out.print("4");
    }
}