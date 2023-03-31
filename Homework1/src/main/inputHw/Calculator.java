package inputHw;

import java.util.Scanner;

public class Calculator {
    public static int Addition(int a, int b) {
        return a + b;
    }

    public static int Subtraction(int a, int b) {
        return a - b;
    }

    public static int Multiplication(int a, int b) {
        return a * b;
    }

    public static double Division(int a, int b) {
        return (double)a / b;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int firstNum = sc.nextInt();
        System.out.print("Enter second number: ");
        int secondNum = sc.nextInt();

        System.out.println("\nAddition: " + Addition(firstNum, secondNum));
        System.out.println("Subtraction: " + Subtraction(firstNum, secondNum));
        System.out.println("Multiplication: " + Multiplication(firstNum, secondNum));
        System.out.print("Division: " + Division(firstNum, secondNum));
    }
}
