package inputHw;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String yourName = sc.nextLine();
        System.out.println("Hello " + yourName + "!");
    }
}
