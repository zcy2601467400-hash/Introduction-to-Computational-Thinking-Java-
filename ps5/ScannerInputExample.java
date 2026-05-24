import java.util.Scanner;   // so that I can use Scanner

public class ScannerInputExample {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Which year will you graduate? ");
        int gYear = console.nextInt();

        int rYear = gYear - 2025;
        System.out.println("You have " + rYear + " years at XMU!");
    }
}


